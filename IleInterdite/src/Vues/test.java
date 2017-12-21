package Vues;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Observable;
import javax.swing.*;
import static javax.swing.SwingConstants.CENTER;

import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import Utils.Utils.Pion;
import javafx.scene.layout.Background;

public class test {


    public static void main(String[] args){

            JLabel labelTitre, labelpseudoJ1, labelpseudoJ2, labelpseudoJ3, labelpseudoJ4;
            JRadioButton deuxJoueurs, troisJoueurs, quatreJoueurs;
            HashMap<Integer, JRadioButton> ensembleDesBtnJoueurs;
            JButton btnValider, btnAnnuler;
            ButtonGroup groupeJoueurs;
            JTextField pseudoJoueurs[];

            JPanel mainPanel, panelHaut, panelBas, panelCentre, panelCentreCentre, panelCentreHaut;
            JFrame window;

            /* INITIALISATION DE L'IHM */

            window = new JFrame();
            window.setName("Ile Interdite - Inscription des joueurs");
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setSize(500, 400);
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            window.setLocationRelativeTo(null);
            mainPanel = new JPanel(new BorderLayout());
            window.add(mainPanel);
            window.setResizable(false);

            /* PANEL HAUT */

            panelHaut = new JPanel();
            mainPanel.add(panelHaut, BorderLayout.NORTH);
            labelTitre = new JLabel("INSCRIPTION", SwingConstants.CENTER);
            panelHaut.add(labelTitre);

            /* PANEL CENTRE */

            panelCentre=new JPanel(new GridLayout(3,1,0,20));
            panelCentreHaut=new JPanel(new GridLayout(1,3));
            panelCentreCentre=new JPanel(new GridLayout(4,1));

            //Création de borders pour structurer l'IHM
            TitledBorder borderNombreJoueurs= BorderFactory.createTitledBorder("Nombre de Joueurs");
            panelCentreHaut.setBorder(borderNombreJoueurs);

            TitledBorder borderNomsJoueurs= BorderFactory.createTitledBorder("Pseudo des Joueurs");
            panelCentreCentre.setBorder(borderNomsJoueurs);

            mainPanel.add(panelCentre,BorderLayout.CENTER);
            panelCentre.add(panelCentreHaut);
            panelCentre.add(panelCentreCentre);


            // Gestion des boutons radio

            groupeJoueurs = new ButtonGroup();
            ensembleDesBtnJoueurs = new HashMap<>();

            deuxJoueurs = new JRadioButton("2");
            panelCentreHaut.add(deuxJoueurs);
            ensembleDesBtnJoueurs.put(ensembleDesBtnJoueurs.size(), deuxJoueurs);
            groupeJoueurs.add(deuxJoueurs);

            troisJoueurs = new JRadioButton("3");
            panelCentreHaut.add(troisJoueurs);
            ensembleDesBtnJoueurs.put(ensembleDesBtnJoueurs.size(), troisJoueurs);
            groupeJoueurs.add(troisJoueurs);

            quatreJoueurs = new JRadioButton("4");
            panelCentreHaut.add(quatreJoueurs);
            ensembleDesBtnJoueurs.put(ensembleDesBtnJoueurs.size(), quatreJoueurs);
            groupeJoueurs.add(quatreJoueurs);

            // Gestion des noms des joueurs

            labelpseudoJ1 = new JLabel("Joueur 1");
            labelpseudoJ2 = new JLabel("Joueur 2");
            labelpseudoJ3 = new JLabel("Joueur 3");
            labelpseudoJ4 = new JLabel("Joueur 4");

            pseudoJoueurs = new JTextField[4];
            for(int i = 0; i < 4; i++){
                    pseudoJoueurs[i] = new JTextField();
            }

            panelCentreCentre.add(labelpseudoJ1);
            panelCentreCentre.add(pseudoJoueurs[0]);


            panelCentreCentre.add(labelpseudoJ2);
            panelCentreCentre.add(pseudoJoueurs[1]);

            panelCentreCentre.add(labelpseudoJ3);
            panelCentreCentre.add(pseudoJoueurs[2]);

            panelCentreCentre.add(labelpseudoJ4);
            panelCentreCentre.add(pseudoJoueurs[3]);

            /* PANEL BAS */

            panelBas=new JPanel();
            mainPanel.add(panelBas, BorderLayout.SOUTH);

            btnAnnuler=new JButton("Fermer");
            btnValider=new JButton("Lancer la partie");
            panelBas.add(btnAnnuler);
            panelBas.add(btnValider);

            /* GESTION DES ACTIONS (Actions listeners et mouses listeners) */

            // Désactiver le champ de texte pour le pseudo des joueurs 3 et 4 quand on veut jouer à 2
            deuxJoueurs.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (deuxJoueurs.isSelected()) {
                        pseudoJoueurs[2].setEnabled(false);
                        pseudoJoueurs[3].setEnabled(false);
                    }

                    else{
                        pseudoJoueurs[2].setEnabled(true);
                        pseudoJoueurs[3].setEnabled(true);
                    }
                }
            });

            // Désactiver le champ de texte pour le pseudo du joueur 4 quand on veut jouer à 3
            troisJoueurs.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(troisJoueurs.isSelected()){
                        pseudoJoueurs[3].setEnabled(false);
                        pseudoJoueurs[2].setEnabled(true); // On réactive le champ du joueur 3
                    }
                }


            });

            // Rendre tous les champs précedemment désactivés actifs pour gérer l'erreur de saisie
            quatreJoueurs.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(quatreJoueurs.isSelected()){
                        pseudoJoueurs[2].setEnabled(true);
                        pseudoJoueurs[3].setEnabled(true);
                    }
                }
            });

















            window.setVisible(true);

    }
}
