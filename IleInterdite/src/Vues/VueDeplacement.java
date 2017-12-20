/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

import Model.Aventurier;
import Model.Grille;
import Model.NomTuile;
import static Model.NomTuile.*;
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
import com.sun.java.swing.plaf.windows.resources.windows;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author avognonm
 */
public class VueDeplacement {
    
 private final JFrame windows;
 private final JPanel mainPanels;
 private final JComboBox listedep;
 private final JButton btnretour;
 private final JButton btnsedeplacer;
 private final JPanel panelBoutons ;
 private final JLabel titre2;
 
public VueDeplacement (String nomJoueur, String NomAventurier, Color couleur, NomTuile NomTuile){
     
        this.windows = new JFrame();
        windows.setSize(480, 200);
        windows.setLocation(1030,500);
        windows.setResizable(false);
        //le titre = Déplacement//
        windows.setTitle("Déplacement");
        mainPanels = new JPanel(new GridLayout(3,1,1000,0));
        
        this.windows.add(mainPanels);

        mainPanels.setBackground(new Color(230, 230, 230));
        mainPanels.setBorder(BorderFactory.createLineBorder(couleur, 2)) ;
       
        
        

        
        //Titre fenêtre//
        
        titre2 = new JLabel ("| Déplacement du joueur : " + nomJoueur + " | " + "Position : " + NomTuile + " | ");
        
        mainPanels.add(titre2);
        
     //=======================================================================
        
     /*Liste déroulante des déplacements*/
    ArrayList<NomTuile> nomTuiles = new ArrayList<>(); //Doit être dans le contrôleur//
    nomTuiles.add(LE_PONT_DES_ABIMES);                 //On doit pouvoir add avec getTuilesAccessibles//
    nomTuiles.add(LA_PORTE_DE_BRONZE);
    nomTuiles.add(LA_CAVERNE_DES_OMBRES);     
    nomTuiles.add(LA_PORTE_DE_FER);
    nomTuiles.add(LA_PORTE_D_OR);
    this.listedep = new JComboBox(nomTuiles.toArray());
    mainPanels.add(listedep);
     
     //=======================================================================
     
     
     //Bouton retour en bas de la fenêtre//
     this.panelBoutons = new JPanel(new GridLayout(2,2));
     this.panelBoutons.setOpaque(false);
     mainPanels.add(this.panelBoutons, BorderLayout.SOUTH);
     
     this.btnretour = new JButton("Retour") ;
     this.btnsedeplacer = new JButton("Se déplacer");
     
     
     
     panelBoutons.add(new JLabel());
     panelBoutons.add(new JLabel());
     panelBoutons.add(btnretour);
     panelBoutons.add(btnsedeplacer);

     
     //=======================================================================
     
     
     this.windows.setVisible(true);
 }



public JButton getBtnretour() {
        return btnretour;
    }
        
     //============================================================================

 public static void main(String [] args) {
        // Instanciation de la fenêtre 
        VueDeplacement vuedep = new VueDeplacement("Manon", "Explorateur",Pion.BLEU.getCouleur(), LA_PORTE_DE_BRONZE);
    }
}
