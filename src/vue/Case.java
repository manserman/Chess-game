package vue;

import controller.*;
import modele.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import java.lang.Math.*;

public class Case extends JLabel {

	private boolean estOccupe;//true si la case est occupee par une piece false sinon
	private Piece piece;//piece qui occupe la case

	private boolean couleurBool; //case en grise si true et blanc si false
	private Color couleur;
	int tour=0;// tour pour savoir le joueur qui doit bouger le premeir tour appartient toujours au blanc
	

	private int ligne;//De 0 a 6
	private int colonne;//De 0 a 7
	Case courant;


	public Case(boolean couleurBool, int ligne, int colonne)
	{
		super();

		this.estOccupe    = false;// Toutes les cases sont vides à l'initialisation
		this.piece        = null;
		this.couleurBool  = couleurBool;
		this.ligne   	  = ligne;//ligne de la case sur le plateau 0 a 6
		this.colonne 	  = colonne;//colonne de la case sur le plaateau 0 a 7

		if(couleurBool)
			couleur =new Color(247, 220, 111 );
		else
			couleur =	new Color(110, 44, 0);

		setOpaque(true);
		setBackground(couleur);
		setHorizontalAlignment(JLabel.CENTER);
		courant=this;
		Ecouteurs Ecouteur=new Ecouteurs();
		this.addMouseListener(Ecouteur);

		

		
	}
  
	public boolean getEstOccupe(){ return this.estOccupe;}
	public Color getCouleur()    { return this.couleur;  }
	public int getLigne()		 { return this.ligne;    }
	public int getColonne()		 { return this.colonne;  }
	public Piece getPiece()		 { return this.piece;    }
	public void setEstOccupe(boolean estOccupe){ this.estOccupe = estOccupe; }
	public void setPiece(Piece piece)		   { this.piece 	= piece;     }
	class Ecouteurs implements  MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(Plateau.getClick()!=-1)
			try {
				new Deplacement().jouer(courant);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}