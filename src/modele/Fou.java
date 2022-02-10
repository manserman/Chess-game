package modele;
import vue.*;
import java.awt.*;
import javax.swing.*;

public class Fou extends Piece
{
	public Fou(boolean couleur)
	{
		super("fou", couleur);
	}
	public boolean moveIsPossible(Case c)
	{
		//Premier cas : la case est occupe par un pion de la meme couleur
		if(commonMoveProperty(c))
			return false;

		// Deuxieme cas: la case n'est pas sur une diagonales
		if(c.getColonne()-position.getColonne() != c.getLigne()-position.getLigne()
		&& c.getColonne()-position.getColonne()	!= position.getLigne()-c.getLigne())
			return false;

		//Quatrieme cas : la case est sur la 1ere diagonale mais entre les deux il ya un pion
		else if(c.getColonne()-position.getColonne()==c.getLigne()-position.getLigne())
		{
			int i = Math.min(c.getLigne(),position.getLigne())+1;
			int j = Math.min(c.getColonne(),position.getColonne())+1;

			int valeurMax = Math.max(c.getLigne(),position.getLigne());

			while (i<valeurMax) 
			{
				if(Plateau.getCase(i, j).getEstOccupe())
					return false;
				i++;
				j++;
			}
		}
		//Cinquieme cas : la case est sur la 2e diagonale mais entre les deux il ya un pion
		else if(c.getColonne()-position.getColonne()==position.getLigne()-c.getLigne())
		{
			int i = Math.min(c.getLigne(),position.getLigne())+1;
			int j = Math.max(c.getColonne(),position.getColonne())-1;

			int valeurMax = Math.max(c.getLigne(),position.getLigne());

			while (i<valeurMax) 
			{
				if(Plateau.getCase(i, j).getEstOccupe())
					return false;
				i++;
				j--;
			}
		}

		return true;
	}

}