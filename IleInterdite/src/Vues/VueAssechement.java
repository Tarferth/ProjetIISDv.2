/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

import Utils.Utils;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.*;


public class VueAssechement {

        private final JFrame windows;
        private final JPanel mainPanels;
        private final JButton btnRetour;
        private final JButton btnAssecher;
        private final JPanel panelBoutons ;
        private final JLabel nomj;
        private final JComboBox listeass;

        public VueAssechement (String nomJoueur, String NomAventurier, Color couleur){

            this.windows = new JFrame();
            windows.setSize(350, 200);
            //le titre = nom du joueur
            windows.setTitle("Assèchement");
            mainPanels = new JPanel(new GridLayout(3,1));
            this.windows.add(mainPanels);

            mainPanels.setBackground(new Color(230, 230, 230));
            mainPanels.setBorder(BorderFactory.createLineBorder(couleur, 2)) ;


           


            
            //Nom Joueur//
        nomj = new JLabel ("Assèchement du joueur : " + nomJoueur);
        
        mainPanels.add(nomj);
        
          /*Liste déroulante des assèchements*/
     String[] items = {"Tuile 1","Tuile 2","Tuile 3","Tuile 4","Tuile 5",};
     this.listeass = new JComboBox(items);
     mainPanels.add(listeass);
     
      // SUD : les boutons
             //Bouton retour en bas de la fenêtre//
     this.panelBoutons = new JPanel(new GridLayout(2,2));
     this.panelBoutons.setOpaque(false);
     mainPanels.add(this.panelBoutons, BorderLayout.SOUTH);
     
     this.btnRetour = new JButton("Retour") ;
     this.btnAssecher = new JButton("Assècher");
     
     
     
     panelBoutons.add(new JLabel());
     panelBoutons.add(new JLabel());
     panelBoutons.add(btnRetour);
     panelBoutons.add(btnAssecher);
            
            this.windows.setVisible(true);
}
    public JButton getBtnRetour() {
        return btnRetour;
    }

    public JButton getBtnAssecher() {
        return btnAssecher;
    }



    public static void main(String [] args) {
        // Instanciation de la fenêtre
        VueAssechement vueass = new VueAssechement ("Manon", "Explorateur", Utils.Pion.ROUGE.getCouleur() );
    }
    //============================================================================


}


