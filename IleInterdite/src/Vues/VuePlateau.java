/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

import Grille.Grille;
import Grille.Tuile;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/**
 *
 * @author moreasim
 */
public class VuePlateau extends JPanel {

    
    private static final String FIN_TOUR     = "finTour";
    private static final String DEPLACEMENT         = "déplacement";
    private static final String ASSECHEMENT     = "asséchement";
    private static final String UTILISATION_CAPACITE = "capacite";
    private static final String DEFFAUSSER      = "défausser";
    private static final String INVOQUER       = "invoquer";
    private static final String DONNER         = "donnerCarte";
    private static final String UTILISER_CARTE     = "utiliserCarte";
    
//    private BoardPanel gamePane;
    private JPanel     eastPane;
    private JPanel     westPane;
    private JPanel     actionCommands;
    
    // player info
    private JPanel                                   paneDroit;

    

    
    // Inventory
    private JPanel north;
    private JPanel south;
    
    // actions
    private JButton BtnFinDeTour;
    private JButton BtnDeplacer;
    private JButton BtnAssecher;
    private JButton BtnCapacite;
    private JButton DeffausserCartes;
    private JButton invoquerTresor;
    private JButton DonnerCartes;
    private JButton UtiliserCarte;
    private JPanel tresor;
    
    // message
    private JTextPane msg;
    private JPanel    msgs;
    private JLabel    action;
    
    //Grille 
    private ActionListener listObs;
    private JPanel centre;
    private JPanel grille;

      private void initComponents() {
          
        setLayout(new BorderLayout());
        eastPane = new JPanel(new BorderLayout());
        westPane = new JPanel(new BorderLayout());
        north = new JPanel(new BorderLayout());
        south = new JPanel(new BorderLayout());
        centre = new JPanel(new BorderLayout());
        grille = new JPanel(new GridLayout(6, 6));
        actionCommands = new JPanel(new GridLayout(8, 1));
        
        paneDroit = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        paneDroit.setLayout(layout);
        layout.rowHeights = new int[2];
        double[] weight = { 0.1, 0.8 };
        layout.rowWeights = weight;
        
        BtnFinDeTour = new JButton("Fin de tour");
        BtnDeplacer = new JButton("Se déplacer");
        BtnAssecher = new JButton("Assécher un endroit");
        BtnCapacite = new JButton("Utiliser sa capacité");
        DeffausserCartes = new JButton("Défausser une carte");
        invoquerTresor = new JButton("Invoquer un trésor");
        DonnerCartes = new JButton("Donner une carte");
        UtiliserCarte = new JButton("Utiliser une carte");
        tresor = new JPanel(new BorderLayout());
        
        msg = new JTextPane();
        action = new JLabel("", SwingConstants.CENTER);
        msgs = new JPanel(new GridLayout(2, 1));
        msg.setEditable(false);
        SimpleAttributeSet attribs = new SimpleAttributeSet();
        StyleConstants.setAlignment(attribs, StyleConstants.ALIGN_CENTER);
        msg.setParagraphAttributes(attribs, true);
        
        //Init borderLayout
        add(eastPane, BorderLayout.EAST);
        add(westPane, BorderLayout.WEST);
        add(north, BorderLayout.NORTH);
        add(south, BorderLayout.SOUTH);
        add(centre,BorderLayout.CENTER);
        
        //Panel Trésor
        south.add(tresor, BorderLayout.CENTER);
        
        //init console historique
        north.add(msgs, BorderLayout.CENTER);  
        msgs.add(action);
        msgs.add(msg);
        
        //init actionCommand
        BtnFinDeTour.setActionCommand(FIN_TOUR);
        BtnDeplacer.setActionCommand(DEPLACEMENT);
        BtnAssecher.setActionCommand(ASSECHEMENT);
        BtnCapacite.setActionCommand(UTILISATION_CAPACITE);
        DeffausserCartes.setActionCommand(DEFFAUSSER);
        invoquerTresor.setActionCommand(INVOQUER);
        DonnerCartes.setActionCommand(DONNER);
        UtiliserCarte.setActionCommand(UTILISER_CARTE);
        
        //Actions possibles
        eastPane.add(paneDroit, BorderLayout.CENTER);
        GridBagConstraints constraints = new GridBagConstraints();
        paneDroit.add(actionCommands, constraints);
        constraints.gridy = 1;
        constraints.fill = GridBagConstraints.BOTH;
        actionCommands.add(BtnFinDeTour);
        actionCommands.add(BtnDeplacer);
        actionCommands.add(BtnAssecher);
        actionCommands.add(BtnCapacite);
        actionCommands.add(DeffausserCartes);
        actionCommands.add(DonnerCartes);
        actionCommands.add(UtiliserCarte);
        actionCommands.add(invoquerTresor);
        
        //Panel Centre
        //Grille 
        centre.add(grille,BorderLayout.CENTER);
//        initGrille();
        
      }
      
      public void initGrille(Grille grilleT){
  
         for(Tuile t : grilleT.getTuiles()){
             grille.add(new JButton(t.getNom().toString()));
             
         }
         
         


      }
      
      
      
      public static void main(String [] args) {
        // Instanciation de la fenêtre
       
    }
}
