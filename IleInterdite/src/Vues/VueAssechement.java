/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

import javax.swing.*;
import java.awt.*;


public class VueAssechement {

        private final JFrame windows;
        private final JPanel mainPanels;

        private final JButton btnretour;
        private final JPanel panelBoutons ;
        public VueAssechement (String nomJoueur, String NomAventurier, Color couleur){

            this.windows = new JFrame();
            windows.setSize(175, 100);
            //le titre = nom du joueur
            windows.setTitle(nomJoueur);
            mainPanels = new JPanel(new BorderLayout());
            this.windows.add(mainPanels);

            mainPanels.setBackground(new Color(230, 230, 230));
            mainPanels.setBorder(BorderFactory.createLineBorder(couleur, 2)) ;


    //Bouton retour en bas de la fenêtre//
     this.panelBoutons = new JPanel(new GridLayout(2,2));
     this.panelBoutons.setOpaque(false);
     mainPanels.add(this.panelBoutons, BorderLayout.SOUTH);

     this.btnretour = new JButton("Retour") ;

    //=======================================================================


     this.windows.setVisible(true);
}



    public JButton getBtnretour() {
        return btnretour;
    }

    //============================================================================


}


