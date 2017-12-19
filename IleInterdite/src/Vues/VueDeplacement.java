/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

import Model.Aventurier;
import Model.Grille;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.border.MatteBorder;
import Utils.Utils.Pion;
import javax.swing.JComboBox;

/**
 *
 * @author avognonm
 */
public class VueDeplacement {
    
 private final JFrame windows;
 private final JPanel mainPanels;
 private final JComboBox listedep;
 private final JButton retour;
 private final JPanel panelBoutons ;
public VueDeplacement (String nomJoueur, String NomAventurier, Color couleur){
     
        this.windows = new JFrame();
        windows.setSize(175, 100);
        //le titre = nom du joueur 
        windows.setTitle(nomJoueur);
        mainPanels = new JPanel(new BorderLayout());
        this.windows.add(mainPanels);

        mainPanels.setBackground(new Color(230, 230, 230));
        mainPanels.setBorder(BorderFactory.createLineBorder(couleur, 2)) ;
     
     //=======================================================================
        
     /*Liste déroulante des déplacements*/
     String[] items = {"Tuile 1","Tuile 2","Tuile 3","Tuile 4","Tuile 5",};
     this.listedep = new JComboBox(items);
     
     
     //=======================================================================
     
     
     //Bouton retour en bas de la fenêtre//
     this.panelBoutons = new JPanel(new GridLayout(2,2));
     this.panelBoutons.setOpaque(false);
     mainPanels.add(this.panelBoutons, BorderLayout.SOUTH);

     this.retour = new JButton("Retour") ;
        
     //=======================================================================
     
     
     
    
        
 }
}


