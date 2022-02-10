package vue; 
import controller.*;

import java.util.ArrayList;
import modele.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Plateau extends JPanel{

	private static Case[][] echequier;
	private static int click;//Permet la gestion des eveneements souris :vaut 0 si on clique sur la case contenant la piece a deplacer et 1 sinon
	private static Piece pieceAdeplacer;
	private static ArrayList<Piece> noirs=new ArrayList<Piece>();// tableau pour connaitre les pièces noirs restants qui peuvent bouger
	private static ArrayList<Piece> blancs=new ArrayList<Piece>();
	private static ArrayList<Piece> noirs_restant=new ArrayList<Piece>();// tableau pour connaitre les pièces noirs restants qui peuvent bouger
	private static ArrayList<Piece> blancs_restant=new ArrayList<Piece>();// tableau pour connaitre les pièces noirs restants qui peuvent bouger
	private static Case precedent;// case précédemment choisie utile pour le joueur ordinateur
	public Plateau()
	{
		setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		setLayout(new GridLayout(7,8));

        // placement des pions principaux
		blancs_restant.add(0, new Tour(true)); 	blancs_restant.add(1, new Cavalier(true));
		blancs_restant.add(2, new Fou(true));   blancs_restant.add(3, new Roi(true));
		blancs_restant.add(4, new Dame(true));	blancs_restant.add(5, new Fou(true));
		blancs_restant.add(6, new Cavalier(true)); blancs_restant.add(7, new Tour(true));

		noirs_restant.add(0, new Tour(false)); 		noirs_restant.add(1, new Cavalier(false)); 
		noirs_restant.add(2, new Fou(false)); 		noirs_restant.add(3, new Roi(false)); 
		noirs_restant.add(4, new Dame(false)); 		noirs_restant.add(5, new Fou(false)); 
		noirs_restant.add(6, new Cavalier(false));   noirs_restant.add(7, new Tour(false)); 
		// mettre les pions dans les tableaux
		for(int i=8; i<16; i++)
		{
			blancs_restant.add(i, new Pion(true)); 
			noirs_restant.add(i, new Pion(false)); 
		}// au debut le joueur noir a tous ses pions
        noirs=noirs_restant;
        blancs=blancs_restant;
		click			= 0;
		echequier 		= new Case[7][8];
		pieceAdeplacer  = null;
		boolean couleur = true;// le pion blanc commence

		for (int i = 0; i < 7; i++) {
			couleur = !couleur;
			for (int j = 0; j < 8; j++) {
				echequier[i][j] = new Case(couleur, i, j); // ajout des cases à l'échéquier
				this.add(echequier[i][j]); // ajouter au Panel
				couleur = !couleur;
			}
		}
	}
  
	public Case[][] getEchequier()			{ return echequier; 	  }// getters des cases
    public static void setPrecedent(Case cse)
    {precedent=cse;}
	public static Case getCase(int i,int j) { return echequier[i][j]; }// getter d'une case
	public static int getClick()		 	{ return click;      	  }// getter du clic
	public static Piece getPieceADeplacer()	{ return pieceAdeplacer;  }// getter de la pièce à déplacer
	public static Case getPrecedent()
	{
		return precedent;
	}
	
	public static ArrayList<Piece> getnoirs(){  
		ArrayList<Piece> quelque=new ArrayList<Piece>();
		int k=0;
		for(int i=0;i<noirs_restant.size();i++)
		{if(noirs_restant.get(i).canmove())
			{quelque.add(k,noirs_restant.get(i));
		      k++;}
			}
		return quelque;}
	public static void setClick			(int click)				{ Plateau.click = click;     	   	      }
	public static void setPieceADeplacer(Piece pieceAdeplacer)	{ Plateau.pieceAdeplacer = pieceAdeplacer;}

	public static void resetCasesColor()// restaurer les couleurs des cases
	{
		for (int i = 0; i < 7; i++) 
		{
			for (int j = 0; j < 8; j++) 
				echequier[i][j].setBackground(echequier[i][j].getCouleur());
		}

	}
public static void setBlancsRestants(Piece p)// mise à jour des pèces blanches restants sur le plateau
{ int i=0; while(i<noirs_restant.size())
if(blancs_restant.get(i).equals(p))
	blancs_restant.remove(i);
else i++;
	}
public static void setNOirsRestants(Piece p)// mise à jour des pèces noires restants sur le plateau
{int i=0; while(i<noirs_restant.size())
	if(noirs_restant.get(i).equals(p))
	noirs_restant.remove(i);
	else i++;
	}
public static ArrayList<Piece> getNoirRestants()
{return noirs_restant;
	}
public static ArrayList<Piece> getBlancRestants()
{return blancs_restant;
	}
	//place les pieces
	public static void  initialiserPlateau()
	{ 
		Deplacement dep=new Deplacement();
	for (int i=0;i<7;i++)
	 for(int j=0;j<8;j++)
		 if(echequier[i][j].getPiece()!=null)
		dep.enleverPiece(echequier[i][j].getPiece(), echequier[i][j]);
		for(int i=0;i<16;i++)
		{
			if(i<8)
			{
				dep.placerUnePiece(noirs.get(i),getCase(0,i));
				dep.placerUnePiece(blancs.get(i),getCase(6,i));
			}else{
				dep.placerUnePiece(noirs.get(i),getCase(1,i-8));
				dep.placerUnePiece(blancs.get(i),getCase(5,i-8));
			}
		}
     noirs_restant=noirs;
     blancs_restant=blancs;
	}

	
}