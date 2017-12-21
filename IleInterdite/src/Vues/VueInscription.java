package Vues;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import javax.swing.*;

import javax.swing.border.TitledBorder;

import Controller.Message;


public class VueInscription extends Vue {

    private JFrame window;

    private JLabel labelTitre, labelpseudoJ1, labelpseudoJ2, labelpseudoJ3, labelpseudoJ4;
    private JRadioButton deuxJoueurs, troisJoueurs, quatreJoueurs;
    private HashMap<Integer, JRadioButton> ensembleDesBtnJoueurs;
    private JButton btnValider, btnAnnuler;
    ButtonGroup groupeJoueurs;

    private JPanel mainPanel, panelHaut, panelBas, panelCentre, panelCentreHaut, panelCentreCentre;
    private JTextField pseudoJoueurs[];


    public VueInscription(){

        /* INITIALISATION DE L'IHM */

        window = new JFrame();
        window.setTitle("Ile Interdite - Inscription des joueurs");
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

        //Récupérer message deux joueurs

        deuxJoueurs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(Message.DEUXJOUEURS);
                clearChanged();
            }
        });

        //Trois joueurs

        troisJoueurs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(Message.TROISJOUEURS);
            }
        });

        //Quatre joueurs

        quatreJoueurs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(Message.QUATREJOUEURS);
                clearChanged();
            }
        });


        //Bouton Annuler

        btnAnnuler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(Message.ANNULER);
                clearChanged();
            }
        });

        //Bouton valider

        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // On récupère le nombre de joueurs selon le choix de l'utilisateur
                int nbJoueurs;
                if (deuxJoueurs.isSelected()){
                    nbJoueurs = 2;
                }else if (troisJoueurs.isSelected()){
                    nbJoueurs = 3;
                }else {
                    nbJoueurs = 4;
                }

                // On vérifie que le nb de noms correspond au nb de joueurs
                int nbJoueursInscrits = 0;
                String pseudoAventuriers[] = new String[nbJoueurs];
                for(int i = 0; i < nbJoueurs; i++){
                    if(! pseudoJoueurs[i].getText().equals("")){
                        System.out.println("Inscription du joueur n°" + i);
                        nbJoueursInscrits++;
                        pseudoAventuriers[i] = pseudoJoueurs[i].getText();
                    }
                }

                // Au cas où il manque un ou plusieurs noms d'aventurier

                if(nbJoueurs != nbJoueursInscrits){
                    JOptionPane erreur = new JOptionPane();
                    erreur.showMessageDialog(null, "Il manque un ou des pseudos de Joueur", "Erreur", JOptionPane.ERROR_MESSAGE);
                } if( !deuxJoueurs.isSelected() && !troisJoueurs.isSelected() && !quatreJoueurs.isSelected()){
                    JOptionPane erreur = new JOptionPane();
                    erreur.showMessageDialog(null, "Veuillez sélectionner un nombre de joueurs", "Erreur", JOptionPane.ERROR_MESSAGE);
                }

                else{ //Si il n'en manque pas, on peut lancer la partie
                    setChanged();
                    notifyObservers(Message.LANCERPARTIE);
                    clearChanged();
                }
            }
        });



    }

    @Override
    public void setVisible(Boolean b) {
        window.setVisible(b);
    }

    public ArrayList<String> getPseudosJoueurs() {
        ArrayList<String> pseudos = new ArrayList<>();
        if (pseudoJoueurs[0].isEnabled()) pseudos.add(pseudoJoueurs[0].getText());
        if (pseudoJoueurs[1].isEnabled()) pseudos.add(pseudoJoueurs[1].getText());
        if (pseudoJoueurs[2].isEnabled()) pseudos.add(pseudoJoueurs[2].getText());
        if (pseudoJoueurs[3].isEnabled()) pseudos.add(pseudoJoueurs[3].getText());
        return pseudos;
    }

}
