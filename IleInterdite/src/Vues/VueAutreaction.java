/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

import Utils.Utils;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author avognonm
 */
public class VueAutreaction {
    
 private final JFrame windows;
 private final JPanel mainPanels;
 private final JButton btnretour;
 private final JButton btnsedeplacer;
 private final JButton btndonnertresor;
 private final JButton btnrecuptresor;
 private final JPanel panelBoutons ;
 private final JLabel titre2;
 private final JLabel titre3;
 
public VueAutreaction (String nomJoueur, String NomAventurier, Color couleur){
     
        this.windows = new JFrame();
        windows.setSize(500, 300);
        
        //le titre = Déplacement//
        windows.setTitle("Autres Action");
        mainPanels = new JPanel(new GridLayout(3,1,1000,0));
        
        this.windows.add(mainPanels);

        mainPanels.setBackground(new Color(230, 230, 230));
        mainPanels.setBorder(BorderFactory.createLineBorder(couleur, 2)) ;
       
        
        

        
        //Titre fenêtre//
        
        titre2 = new JLabel ("Autres actions du joueur : " + nomJoueur);
        
        mainPanels.add(titre2);
        
     //=======================================================================
        
     /*Liste déroulante des déplacements*/
     titre3 = new JLabel ("Les autres actions ne sont pas encore disponibles pour le moment");
     mainPanels.add(titre3);
     
     //=======================================================================
     
     
     //Bouton retour en bas de la fenêtre//
     this.panelBoutons = new JPanel(new GridLayout(2,2));
     this.panelBoutons.setOpaque(false);
     mainPanels.add(this.panelBoutons, BorderLayout.SOUTH);
     
     this.btnretour = new JButton("Retour") ;
     this.btnsedeplacer = new JButton("Se déplacer");
     this.btndonnertresor = new JButton("Donner trésor");
     this.btnrecuptresor = new JButton("Prendre trésor");
     
     
     panelBoutons.add(btndonnertresor);
     panelBoutons.add(btnrecuptresor);
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
        VueAutreaction vueaa = new VueAutreaction("Manon", "Explorateur",Utils.Pion.ROUGE.getCouleur() );
    }
}
