package modele;
import modele.*;
import vue.*;
import controller.*;
import java.util.ArrayList;
public class Joueur {
private String nom;
private ArrayList<Piece> captures;// pièces capturées
private ArrayList<Piece> restants;// Pièces restants
public Joueur(String nom)
{this.nom=nom;
if(this.nom.equals("Blanc"))
restants=Plateau.getBlancRestants();
else restants=Plateau.getNoirRestants();
captures= new ArrayList<Piece>();
	}
public void prise(Piece p)
{captures.add(p);}


public ArrayList<Piece> getCaptures()
{return this.captures;
	}
public ArrayList<Piece> getRestants()
{return this.restants;
	}
public void enleverRestant(Piece p)
{for(Piece pe:restants)
{if(pe.getPosition().getLigne()==p.getPosition().getLigne() && pe.getPosition().getColonne()==p.getPosition().getColonne())
	restants.remove(pe);
break;// sortir de la boucle
	}
	
	}

public void remplacer(Piece p,int i) {
restants.add(i, p);	
}

}
