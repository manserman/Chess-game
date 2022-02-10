package controller;
import vue.*;
import javax.sound.sampled.*;
import modele.*;
import java.io.InputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;
public class Deplacement  {
	private Joueur j1=new Joueur("Blanc");
	private Joueur j2=new Joueur("Noir");
	private Case cse;
	static Interface int1 = new Interface();
	Jouerblanc tourblanc=new Jouerblanc();
	static Chrono chrono=new Chrono();
public boolean faisPartie(ArrayList<Case> posibles, Case cse)// pour savoir si la case choisie peut �tre atteinte avec le pion choisit
{ for(int i=0;i<posibles.size();i++)
{if (posibles.get(i)==cse)
	return true;
	}
return false;
	}
public void placerUnePiece(Piece p,Case cible)
{
	cible.setPiece(p);
	cible.setIcon(p.getIcone());
	cible.setEstOccupe(true);
	p.setPosition(cible);
}

public void enleverPiece(Piece piece,Case c)
{
	piece.setPosition(null);
	c.setIcon(null);
	c.setEstOccupe(false);
	c.setPiece(null);
}
public void move(Case position,Case cible,Piece p)
{
	if(p.moveIsPossible(cible))
	{
		enleverPiece(p,position);
		placerUnePiece(p,cible);
	}
	
}
public void promouvoir(Piece piece, Piece choisie,Joueur j)
{int i=0;
while(!j.getRestants().get(i).equals(piece))
	i++;
choisie.setPosition(piece.getPosition());
j.remplacer(choisie,i);
piece.getPosition().setPiece(choisie);
piece.getPosition().setIcon(choisie.getIcone());
piece.getPosition().setEstOccupe(true);
j.remplacer(choisie, i);
	}
public void jouer(Case cse) throws InterruptedException {

	 try{this.cse=cse;}catch (Exception e) {
		// TODO: handle exception
	}
	tourblanc.start();

	
}


public static void main(String[] args) {
	
	int1.run();

	
	
}






private class Jouerblanc extends Thread{
	@Override
	public void run() 
	{
		if(Plateau.getClick()==0)
		{
			if(cse.getPiece()!=null && cse.getPiece().getCouleur())
	{ Plateau.setPrecedent(cse);
	Plateau.setPieceADeplacer(cse.getPiece());
	cse.getPiece().showPossibleMoves();
	Plateau.setClick(1);
}
}else {if(faisPartie(Plateau.getPrecedent().getPiece().getPossible_moves(),cse))
{// second clic si la case choisie pour le deplacemnt est un d�placemnt l�gal
if(cse.getPiece()!=null)// case d'une prise pour le joueur blanc autrement dit la case cible ezst vide
{if(cse.getPiece().getNom().equals("roi"))
	{JOptionPane.showMessageDialog(null,"Le joueur Blanc a gagn�","Alert",JOptionPane.WARNING_MESSAGE);
	int1.dispose();
	}
// Doit faire un reset
Plateau.setNOirsRestants(cse.getPiece());
	j1.prise(cse.getPiece());
try {
this.finalize();}
catch(Throwable e) {
	// TODO: handle exception
}
		}
Piece p=Plateau.getPieceADeplacer();
move(Plateau.getPieceADeplacer().getPosition(), cse, p);// d�placement
	chrono.arreter();

Plateau.resetCasesColor();// maj du plateau
Plateau.setClick(-1);// Ajouter ici
if(( cse.getLigne()==0 ) && Plateau.getPieceADeplacer().getNom().equals("pion"))// SI un pion atteint l'autre bord du tableau alors on fait la promotion
{Piece promotion=new Dame(true);// Pi�ce � choisir pour la promotion
String nom=JOptionPane.showInputDialog("Choisir une pi�ce p\n Ecrire Reine pour une reine, CH pour chevallier\n Tour pour tour,Fou pour Fou\n Attention la reine sera automatiquement choisie pour tout autre valeur");
switch (nom)
{ case "Dame":
	promotion=new Dame(true);
	break;
case "CH":
   promotion=new Cavalier(true);
   break;
case "Tour":
	   promotion=new Tour(true);
	   break;
case "Fou":    promotion=new Fou(true);
break;
}
int i=0; while(PiecesDuJeu.blancs_restants!=Plateau.getPieceADeplacer()))
i++;
PiecesDuJeu.blancs_restants.add(i,promotion);
	}
	
new Jouernoir().start();	
}
else if(cse.getPiece()!=null && cse.getPiece().getCouleur() )// Changement de pion
		{  
			Plateau.resetCasesColor();
			Plateau.setPrecedent(cse);
			Plateau.setPieceADeplacer(cse.getPiece());
			cse.getPiece().showPossibleMoves();
			
		}
	
}
			
}
}
private class Jouernoir extends Thread{// thread pour les d�placements du joueur noir
	@Override
	public void run()
	{tourblanc.stop();
	
		try {
			Thread.sleep(2000);// on attend 10 secondes
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	ArrayList<Piece> pieces=Plateau.getnoirs();//les pi�ces noires restants sur le plateau etg qui peuvent bouger
	if(pieces.size()>0)// s'il reste plus d'une pi�ce
	{int index=new Random().nextInt()%pieces.size();// choix du pion � d�placer
	index=java.lang.Math.abs(index);
	boolean so=true;
	while(so)
	{
		{if(pieces.get(index)==null)// s'il n'y a aucune pi�ce � l'index index
		{so=true;
		index=new Random().nextInt()%15;
		index=java.lang.Math.abs(index);}
		else so=false;
		}
	}
	
    Plateau.setPieceADeplacer(pieces.get(index));// on notifie au plateau la pi�ce � d�placer
	Case depart=Plateau.getPieceADeplacer().getPosition();
	int col=depart.getColonne();
	int ligne=depart.getLigne();
	Case cible=pieces.get(index).getPossible_moves().get(java.lang.Math.abs(new Random().nextInt()%pieces.get(index).getPossible_moves().size()));//choix de a case cible
	if(cible.getPiece()!=null)// case d'une prise pour le joueur noir autrement dit la case cible est occup�e par une pi�ce blanche
	{if(cse.getPiece().getNom().equals("roi"))
		{JOptionPane.showMessageDialog(null,"L'ordinateur a gagn�","Alert",JOptionPane.WARNING_MESSAGE);  
		int1.dispose();}  
		j2.prise(cse.getPiece());
		Plateau.setBlancsRestants(cse.getPiece());
		j1.enleverRestant(cse.getPiece());
		
	}
	move(Plateau.getPieceADeplacer().getPosition(),cible,Plateau.getPieceADeplacer() );// d�placement
	if(( Plateau.getPieceADeplacer().getPosition().getLigne()==6) && Plateau.getPieceADeplacer().getNom().equals("pion"))// SI un pion atteint l'autre bord du tableau alors on fait la promotion
	{Piece promotion=new Dame(true);// Pi�ce � choisir pour la promotion
	int inx=java.lang.Math.abs(new Random().nextInt()%4);
	switch (inx)
	{ case 0:
		promotion=new Dame(false);
		break;
	case 1:
	   promotion=new Cavalier(false);
	   break;
	case 2:
		   promotion=new Tour(false);
		   break;
	case 3:    promotion=new Fou(false);
	break;
	}
	int i=0; while(PiecesDuJeu.noirs_restants!=Plateau.getPieceADeplacer()))
		i++;
PiecesDuJeu.blancs_restants.add(i,promotion););
		}
	Plateau.setClick(0);
	// Nouveau
	chrono=new Chrono();
	chrono.run();
	}

}
}

//Nouveau




private static class Chrono extends Thread{
	private TimerTask tache=new TimerTask()
	{int time=59;

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
			int1.setTimer("Temps de jeu restant: "+time+" secondes");
			time--;
			if(time==0)
			{JOptionPane.showMessageDialog(null,"L'ordinateur a gagn�","Alert",JOptionPane.WARNING_MESSAGE); 
				cancel();
				int1.dispose();
				
			}
		}
		};
	public void run()
	{Timer chrono= new Timer();
	chrono.schedule(tache, 1000,1000);
		
	}
public void arreter()
{tache.cancel();
int1.setTimer("Temps de jeu restant:");

	}

}
}

