package modele;

import modele.*;
import vue.*;
import java.awt.*;
import javax.swing.*;

public class Roi extends Piece
{
	public Roi(boolean couleur)
	{
		super("roi", couleur);
	}

	public boolean moveIsPossible(Case c)
	{
		//Premier cas : la case est occupe par un pion de la meme couleur
		if(commonMoveProperty(c))
			return false; 

		//Deuxieme cas: on se deplace sur la case a gauche ou celle a droite
		else if(position.getLigne()==c.getLigne())//si la case cible est sur la meme ligne 
		{
			if(c.getColonne()==position.getColonne()-1 || c.getColonne()==position.getColonne()+1)
				return true;
		}

		//Troisieme cas: on se deplace sur la case en avant ou en arriere 
		else if(position.getColonne()==c.getColonne())//si la case cible est sur la meme colonne 
		{
			if(c.getLigne()==position.getLigne()-1 || c.getLigne()==position.getLigne()+1)
				return true;
		}

		//Quatrieme cas: on se déplace sur la premiere diagonale
		else if(position.getColonne()==c.getColonne()+1 || position.getColonne()==c.getColonne()-1 )
		{
			if(c.getLigne()==position.getLigne()-1 || c.getLigne()==position.getLigne()+1)
				return true;
		}

		//Cinquieme cas: on se déplace sur la deuxieme diagonale
		else if(position.getLigne()==c.getLigne()+1 || position.getLigne()==c.getLigne()-1)
		{
			if(c.getColonne()==position.getColonne()-1 || c.getColonne()==position.getColonne()+1)
				return true;
		}
		
		return false;
	}
	
}