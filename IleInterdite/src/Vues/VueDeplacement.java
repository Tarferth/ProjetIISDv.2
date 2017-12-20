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
 private final JButton btnretour;
 private final JButton btnvalider;
 private final JPanel panelBoutons ;
 private final JLabel titre2;
 
public VueDeplacement (String nomJoueur, String NomAventurier, Color couleur){
     
        this.windows = new JFrame();
        windows.setSize(350, 200);
        
        //le titre = nom du joueur 
        windows.setTitle("Déplacement");
        mainPanels = new JPanel(new GridLayout(3,1,1000,0));
        
        this.windows.add(mainPanels);

        mainPanels.setBackground(new Color(230, 230, 230));
        mainPanels.setBorder(BorderFactory.createLineBorder(couleur, 2)) ;
       
        
        

        
        //Titre fenêtre//
        
        titre2 = new JLabel ("Déplacement du joueur:" + nomJoueur);
        
        mainPanels.add(titre2);
        
     //=======================================================================
        
     /*Liste déroulante des déplacements*/
     String[] items = {"Tuile 1","Tuile 2","Tuile 3","Tuile 4","Tuile 5",};
     this.listedep = new JComboBox(items);
     mainPanels.add(listedep);
     
     //=======================================================================
     
     
     //Bouton retour en bas de la fenêtre//
     this.panelBoutons = new JPanel(new GridLayout(2,2));
     this.panelBoutons.setOpaque(false);
     mainPanels.add(this.panelBoutons, BorderLayout.SOUTH);
     
     this.btnretour = new JButton("Retour") ;
     this.btnvalider = new JButton("Valider");
     
     
     
     panelBoutons.add(new JLabel());
     panelBoutons.add(new JLabel());
     panelBoutons.add(btnretour);
     panelBoutons.add(btnvalider);

     
     //=======================================================================
     
     
     this.windows.setVisible(true);
 }



public JButton getBtnretour() {
        return btnretour;
    }
        
     //============================================================================

 public static void main(String [] args) {
        // Instanciation de la fenêtre 
        VueDeplacement vuedep = new VueDeplacement("Manon", "Explorateur",Pion.ROUGE.getCouleur() );
    }
}
