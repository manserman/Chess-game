package vue;

import modele.*;
import javax.swing.border.EtchedBorder;
import controller.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Interface extends JFrame {


	private JPanel panelControle = new JPanel(); // panel du haut
	private Plateau panelGrille = new Plateau(); // panel du bas ( grille )
   private  JToolBar toolbar=new JToolBar();
   private  JPanel promotion=new JPanel();// panel du bas
   private JButton reset=new JButton("Reset");
   private JButton reprendre=new JButton("Reprendre");
   private static JLabel lab=new JLabel();
	private JButton startButton = new JButton("START");

	private boolean jeuInitialise;

	public Interface() 
	{

		super("Jeu d'echecs");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000,800);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		try {
			jeuInitialise = false;
			JPanel panelPrincipal = (JPanel)getContentPane();

			startButton.addActionListener(new Ecouteur());
		    toolbar.add(startButton);
            toolbar.add(reset);
            toolbar.add(reprendre);
			panelGrille.setBounds(5, 65, 600, 490);
			panelControle.add(toolbar, null);
		    promotion.setBounds(5,570,300,50);
			promotion.setLocation(5, 560);
		    lab.setBackground(new Color(255,255,255));
		    lab.setSize(200, 30);
		    lab.setVisible(true);
		    lab.setText("Temps de jeu restant=00 secondes");
			panelPrincipal.add(panelGrille, null);
			panelPrincipal.add(panelControle, null);
			
			panelControle.add(lab,null);	

		} catch (Exception e) {
			e.printStackTrace();
		}

		this.setVisible(true);
	}
	public JPanel getPanelControl() { return panelControle; }
	public JPanel getPanelGrille()  { return panelGrille; 	 }
	public JButton getStartButton()  { return startButton;   }
	public boolean getJeuInitialise(){ return jeuInitialise; }

	public void setJeuInitialise(boolean jeuInitialise){ this.jeuInitialise = jeuInitialise; }

    public void setTimer(String time)
    {
    	lab.setText(time);
    }
	public void run()
	{ 
		while(true)
			repaint(); 
	}
private class Ecouteur implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
			panelGrille.initialiserPlateau();
			
		
	}
	
}

}
