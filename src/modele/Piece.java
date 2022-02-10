package modele;

import vue.*;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public abstract class Piece{

	protected boolean couleur;//true pour blanc, false pour noir
	protected String nom;
	protected ImageIcon icone;
	protected Case position; 
	ArrayList<Case> possible_moves=new ArrayList<Case>();
	public Piece(String nom, boolean couleur)
	{
		if(couleur)
			icone 	  = new ImageIcon("Icones\\Blancs\\"+nom+".gif");
		else
			icone 	  = new ImageIcon("Icones\\Noirs\\"+nom+".gif");

		this.nom 	  = nom;
		this.couleur  = couleur; 
		this.position = null;//pas sur le plateau a la construction
	}  
	/*********
	 * GETTERS
	 ****/
	public String getNom(){ return nom; }
	public boolean getCouleur(){ return couleur; }
	public ImageIcon getIcone(){ return icone; }
	public Case getPosition(){ return position; }

	/********
	 * SETTERS
	 *******/
	public void setNom(String nom){ this.nom = nom; }
	public void setCouleur(boolean couleur){ this.couleur = couleur; }
	public void setIcone(ImageIcon icone){ this.icone = icone; }
	public void setPosition(Case position){ this.position = position; }



	public boolean commonMoveProperty(Case cible)//retourne vrai si la case cible est occupe par un pion de la meme couleur
	{
		if(!cible.getEstOccupe())
			return false;
		
		else if(cible.getPiece().getCouleur()!=this.getCouleur())
			return false;
		else
			return true;
		
	}
	public boolean canmove()
	{   
	int k=0;
	possible_moves=new ArrayList<Case>();
	for (int i = 0; i < 7; i++) {
		for (int j = 0; j < 8; j++)
		{
			if(moveIsPossible(Plateau.getCase(i,j)))
			{   possible_moves.add(Plateau.getCase(i,j));
				
				k++;
			}
		
	}
}
		return (this.getPossible_moves().size()>0);
			
	}

	public abstract boolean moveIsPossible(Case cible);


	public void showPossibleMoves()
	{int k=0;
		possible_moves=new ArrayList<Case>();
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 8; j++)
			{
				if(moveIsPossible(Plateau.getCase(i,j)))
				{   possible_moves.add(Plateau.getCase(i,j));
					Plateau.getCase(i,j).setOpaque(true);
					Plateau.getCase(i,j).setBackground(new Color(142,119,95));
					k++;
				}
			}
		}
	}
	public ArrayList<Case> getPossible_moves(){// ArrayLIst uniquement utile pour l'ordinateur
		return this.possible_moves;
	}
	public boolean equals(Piece p)
	{if(position.getLigne()==p.getPosition().getLigne() && position.getColonne()==p.getPosition().getColonne())
		return true;
		return false;
	}
	
		
}