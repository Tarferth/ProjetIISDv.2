/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
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
    private static final String NOUVEAU_JEU     = "nouvellePartie";
    private static final String QUITTER         = "quitter";
    private static final String DEFFAUSSER      = "défausser";
    private static final String INVOQUER       = "invoquer";
    private static final String DONNER         = "donnerCarte";
    private static final String UTILISER_CARTE     = "utiliserCarte";
    private static final String PAUSE        = "pause";
    
//    private BoardPanel gamePane;
    private JPanel     eastPane;
    private JPanel     westPane;
    private JPanel     actionCommands;
    
    // player info
    private JPanel                                   paneDroit;
//    private ArrayList<PlayerInfo>                    pawns;
//    private HashMap<AdventurerType, PlayerInventory> inventories;
    
    // Decks
//    private DeckComponent treasureDeck;
//    private DeckComponent floodDeck;
//    private JPanel        decksPane;
//
//    private WaterRise floodCursor;
    
    // Inventory
    private JPanel north;
    private JPanel south;
    
    // actions
    private JButton BtnFinDeTour;
    private JButton BtnDeplacer;
    private JButton BtnAssecher;
    private JButton BtnCapacite;
    private JButton DeffausserCartes;
    private JButton invoque;
    private JButton DonnerCartes;
    private JButton UtiliserCarte;
    private JButton pause;
    // message
    private JTextPane msg;
    private JPanel    msgs;
    private JLabel    action;
    
private ActionListener listObs;
      private void initComponents() {
        setLayout(new BorderLayout());
        eastPane = new JPanel(new BorderLayout());
        westPane = new JPanel(new BorderLayout());
        north = new JPanel(new BorderLayout());
        south = new JPanel(new BorderLayout());
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
        invoque = new JButton("Invoquer un trésor");
        DonnerCartes = new JButton("Donner une carte");
        UtiliserCarte = new JButton("Utiliser une carte");
        pause = new JButton("Pause");
        
        msg = new JTextPane();
        action = new JLabel("", SwingConstants.CENTER);
        msgs = new JPanel(new GridLayout(2, 1));
        msg.setEditable(false);
        SimpleAttributeSet attribs = new SimpleAttributeSet();
        StyleConstants.setAlignment(attribs, StyleConstants.ALIGN_CENTER);
        msg.setParagraphAttributes(attribs, true);
        
//        floodCursor = new WaterRise();
        
        add(eastPane, BorderLayout.EAST);
        add(westPane, BorderLayout.WEST);
        add(north, BorderLayout.NORTH);
        add(south, BorderLayout.SOUTH);
        
        south.add(pause, BorderLayout.CENTER);
        north.add(msgs, BorderLayout.CENTER);
        msgs.add(action);
        msgs.add(msg);
        
        BtnFinDeTour.setActionCommand(FIN_TOUR);
        BtnDeplacer.setActionCommand(DEPLACEMENT);
        BtnAssecher.setActionCommand(ASSECHEMENT);
        BtnCapacite.setActionCommand(UTILISATION_CAPACITE);
        DeffausserCartes.setActionCommand(DEFFAUSSER);
        invoque.setActionCommand(INVOQUER);
        DonnerCartes.setActionCommand(DONNER);
        UtiliserCarte.setActionCommand(UTILISER_CARTE);
        
        eastPane.add(paneDroit, BorderLayout.CENTER);
        GridBagConstraints constraints = new GridBagConstraints();
        paneDroit.add(actionCommands, constraints);
        constraints.gridy = 1;
        constraints.fill = GridBagConstraints.BOTH;
//        paneDroit.add(floodCursor, constraints);
        actionCommands.add(BtnFinDeTour);
        actionCommands.add(BtnDeplacer);
        actionCommands.add(BtnAssecher);
        actionCommands.add(BtnCapacite);
        actionCommands.add(DeffausserCartes);
        actionCommands.add(DonnerCartes);
        actionCommands.add(UtiliserCarte);
        actionCommands.add(invoque);
        // for (Component c : actionCommands.getComponents()) {
        // if (c != null) {
        // c.setFont(new Font(c.getFont().getFontName(), c.getFont().getStyle(),
        // (int) (c.getFont().getSize() * 0.7)));
        // }
        // } 
      }
    
}
