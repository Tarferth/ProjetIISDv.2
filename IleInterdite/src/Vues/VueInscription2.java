/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.SwingConstants;

/**
 *
 * @author avognonm
 */
public class VueInscription2 {
    
    private final JFrame window;
    private final JPanel mainPanel;
    private final JButton btnJouer;
    private final JButton btnRetour;
    private final JPanel panelbass; 
    private final JPanel panelmid;
    private final JPanel paneltopp;
    private final JPanel paneltop;
    private final JPanel panelwest;
    private final JPanel paneleast;
    private final JRadioButton deuxJoueurs,troisJoueurs,quatreJoueurs;
    private final HashMap ensembleDesBtnJoueurs;
    private ArrayList difficulte;
    
   public VueInscription2 (){
    
        window = new JFrame();
        window.setTitle("Ile Interdite - Inscription des joueurs");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(500, 400);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocationRelativeTo(null);
        mainPanel = new JPanel(new BorderLayout());
        window.add(mainPanel);
        window.setResizable(false);
        
        
        
        
      
        
        
        //Ajout Combobox au paneltop
        paneltopp = new JPanel(new GridLayout(1,3 ));
        paneltop = new JPanel();
        mainPanel.add(paneltopp, BorderLayout.NORTH);
        
        // Gestion des boutons radio
        ButtonGroup groupeJoueurs = new ButtonGroup();
        ensembleDesBtnJoueurs = new HashMap<>();

        deuxJoueurs = new JRadioButton("2");
        paneltop.add(deuxJoueurs);
        ensembleDesBtnJoueurs.put(ensembleDesBtnJoueurs.size(), deuxJoueurs);
        groupeJoueurs.add(deuxJoueurs);

        troisJoueurs = new JRadioButton("3");
        paneltop.add(troisJoueurs);
        ensembleDesBtnJoueurs.put(ensembleDesBtnJoueurs.size(), troisJoueurs);
        groupeJoueurs.add(troisJoueurs);

        quatreJoueurs = new JRadioButton("4");
        paneltop.add(quatreJoueurs);
        ensembleDesBtnJoueurs.put(ensembleDesBtnJoueurs.size(), quatreJoueurs);
        groupeJoueurs.add(quatreJoueurs);

        paneltopp.add(new JLabel("Nombre de joueur : ", SwingConstants.RIGHT));
        paneltopp.add(paneltop);
        paneltopp.add(new JPanel());
        //Ajout JButton au panelmid
        
        panelmid = new JPanel(new GridLayout(1,7));
        mainPanel.add(panelmid, BorderLayout.CENTER);
        panelmid.add(new JButton());
        panelmid.add(new JButton());
        panelmid.add(new JButton());
        panelmid.add(new JButton());
        panelmid.add(new JButton());
        panelmid.add(new JButton());
        panelmid.add(new JButton());
        
        
       

     
        //Affichage des deux boutons
       
        
            
        
        panelwest = new JPanel();
        paneleast = new JPanel();
        mainPanel.add(panelwest, BorderLayout.WEST);
        mainPanel.add(paneleast, BorderLayout.EAST);
        
        
        // Propriétés de JSlider
        
        JSlider slider = new JSlider(JSlider.HORIZONTAL); 
        
        // Affichage des "décorations" (règle sous le slider) 
        slider.setMaximum(4);
        slider.setMinimum(1);
        slider.setMinorTickSpacing(1);  
        slider.setPaintTicks(true); 
        slider.setPaintLabels(true); 
        ArrayList<String> difficulte = new ArrayList<>();
        difficulte.add(0, "Novice");
        difficulte.add(1, "Normal");
        difficulte.add(2, "Elite");
        difficulte.add(3, "Legendaire");
        
        slider.setLabelTable(slider.createStandardLabels(difficulte.size(), 1));
        
        
        panelbass = new JPanel(new GridLayout(2,3,10,10));
        mainPanel.add(panelbass, BorderLayout.SOUTH);
        
        btnRetour=new JButton("Retour");
        btnJouer=new JButton("Jouer");
        panelbass.add(new JLabel("Difficulté : ", SwingConstants.RIGHT));
        panelbass.add(slider);
        panelbass.add(new JLabel());
        panelbass.add(btnRetour);
        panelbass.add(new JLabel());
        panelbass.add(btnJouer);
        
        
        window.setVisible(true);
        
        
    }

    public static void main(String [] args) {
        // Instanciation de la fenêtre
        VueInscription2 vueins2 = new VueInscription2();
    }

}
