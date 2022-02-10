package modele;


import vue.*;
import java.awt.*;
import javax.swing.*;

public class Cavalier extends Piece
{
	public Cavalier(boolean couleur)
	{
		super("cavalier", couleur);
	}

	public boolean moveIsPossible(Case c)
	{
		//Premier cas : la case est occupe par un pion de la meme couleurç
		if(commonMoveProperty(c))
			return false;

		//Deuxieme cas : le cavalier se deplace en L sur une ligne au dessus ou en dessous
		else if((c.getLigne()	==position.getLigne()+1
			||	 c.getLigne()	==position.getLigne()-1)
			&&	(c.getColonne()	==position.getColonne()+2
			||	 c.getColonne()	==position.getColonne()-2))
			return true;

		//Deuxieme cas : le cavalier se deplace en L sur 2 une colonne à gauche ou à droite
		else if((c.getLigne()	==position.getLigne()+2
			||	 c.getLigne()	==position.getLigne()-2)
			&&	(c.getColonne()	==position.getColonne()+1
			||	 c.getColonne()	==position.getColonne()-1))
			return true;

		return false;
		
	}

}

