package modele;


import vue.*;
import java.awt.*;
import javax.swing.*;

public class Tour extends Piece
{
	public Tour(boolean couleur)
	{
		super("tour", couleur);
	}
	public boolean moveIsPossible(Case c)
	{
		//Premier cas : la case est occupe par un pion de la meme couleur
		if(commonMoveProperty(c))
			return false;
		
		// Deuxieme cas: la case n'est ni sur la meme ligne ni sur la meme colonne
		if(c.getLigne()		!= position.getLigne() 
		&& c.getColonne()	!= position.getColonne())
			return false;

		//Troisieme cas : la case est sur la meme ligne mais entre les deux cases il y'a un pion 
		else if(c.getLigne()==position.getLigne())
		{
			int j = Math.max(c.getColonne(),position.getColonne());
			int i = Math.min(c.getColonne(),position.getColonne())+1;

				while(i<j)
				{
					if(Plateau.getCase(c.getLigne(), i).getEstOccupe())
						return false;

					i++;
				}
		}

		//Quatrieme cas : la case est sur la meme colonne mais entre les deux il ya un pion
		else if(c.getColonne()==position.getColonne())
		{
			int i = Math.min(c.getLigne(),position.getLigne())+1;
			int j = Math.max(c.getLigne(),position.getLigne());

			while(i<j)
			{
				if(Plateau.getCase(i, c.getColonne()).getEstOccupe())
					return false;

				i++;
			}
		}

		return true;

	}
	
}
