package modele;

import vue.*;
import java.awt.*;
import javax.swing.*;

public class Pion extends Piece
{

	public Pion(boolean couleur)
	{
		super("pion", couleur);
	}


	public boolean moveIsPossible(Case c)
	{
		//Premier cas : la case est occupe par un pion de la meme couleur
		if(commonMoveProperty(c))
			return false;
		
		//Deuxieme cas : la case n'est pas occupee => le pion peut se déplacer d'une case en avant
		else if(!c.getEstOccupe())
		{
			//deplacement du pion blanc
			if (getCouleur()
			&&  position.getColonne()==c.getColonne() 
			&&  c.getLigne()		 ==position.getLigne()-1)						
			
				return true;
			
			//deplacement du pion noir
			else if(!getCouleur()
				&& position.getColonne()==c.getColonne() 
				&& c.getLigne()			 ==position.getLigne()+1)
				
				return true;
			else
				return false;
			
		}

		/*Troisieme cas : la case est occupee par l'autre joueur 
		=> le pion peut se déplacer d'une case sur les diagonales(quand le pion capture)*/
		else
		{
			//capture du pion blanc
			if (getCouleur()
			&&	c.getLigne()==position.getLigne()-1
			&& (c.getColonne()==position.getColonne()-1
			||  c.getColonne()==position.getColonne()+1))
				return true;

			//capture du pion noir
			else if (!getCouleur()
			&&	c.getLigne()==position.getLigne()+1
			&& (c.getColonne()==position.getColonne()-1
			||  c.getColonne()==position.getColonne()+1))
				return true;

			else
				return false;
		}

	}}