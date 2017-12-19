package Vues;

import java.awt.*;
import java.util.HashMap;
import java.util.Observable;
import javax.swing.*;
import static javax.swing.SwingConstants.CENTER;

import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import Utils.Utils.Pion;


public class ViewInscription extends Observable {

    private JFrame window;

    private JLabel labelTitre, labelpseudoJ1, labelpseudoJ2, labelpseudoJ3, labelpseudoJ4;
    private JRadioButton deuxJoueurs, troisJoueurs, quatreJoueurs;
    private HashMap<Integer, JRadioButton> ensembleDesBtnJoueurs;
    private JButton btnValider, btnAnnuler;

    private JPanel mainPanel, panelHaut, panelBas, panelCentre;


    public ViewInscription(){

        /* INITIALISATION DE L'IHM */

        window = new JFrame();
        window.setName("Ile Interdite - Inscription des joueurs");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(500,700);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocationRelativeTo(null);
        mainPanel = new JPanel(new BorderLayout());
        window.add(this.mainPanel);
        window.setResizable(false);

        /* PANEL HAUT */

        panelHaut = new JPanel();
        mainPanel.add(panelHaut, BorderLayout.NORTH);
        labelTitre = new JLabel("INSCRIPTION", SwingConstants.CENTER);
        panelHaut.add(labelTitre);



    }


}
