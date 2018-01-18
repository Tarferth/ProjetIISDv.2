/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

import Controller.Message;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author avognonm
 */
public class VueEcranTitre  extends Vue {
    
    private JFrame window;
    private JPanel mainPanel;
    private JButton quitter;
    private JButton jouer;
    private JLabel jeu;
    private JPanel panelJoue;
    private JPanel panelQuitte;
    
    public VueEcranTitre(){
    
        this.window = new JFrame();
        window.setSize(600, 650);
        window.setResizable(false);
        window.setLocation(150,350);
        //le titre = Déplacement//
        window.setTitle("Ile Interdite");
        
        mainPanel = new JPanel(new GridLayout(3,1));
        window.add(mainPanel);
        
        panelJoue = new JPanel( new GridLayout(3,3));
        panelQuitte = new JPanel( new GridLayout(3,3));

        quitter = new JButton("QUITTER");
        jouer = new JButton("JOUER");
        jeu = new JLabel("L'Ile Interdite", SwingConstants.CENTER);
        
        jeu.setFont( new Font("Serif", Font.BOLD, 30));
        
        mainPanel.add(jeu);
        mainPanel.add(panelJoue);
        
        panelJoue.add(new JLabel());
        panelJoue.add(new JLabel());
        panelJoue.add(new JLabel());
        panelJoue.add(new JLabel());
        panelJoue.add(jouer);
        panelJoue.add(new JLabel());
        panelJoue.add(new JLabel());
        panelJoue.add(new JLabel());       
        panelJoue.add(new JLabel());

        
        mainPanel.add(panelQuitte);
        
        panelQuitte.add(new JLabel());
        panelQuitte.add(new JLabel());
        panelQuitte.add(new JLabel());
        panelQuitte.add(new JLabel());
        panelQuitte.add(quitter);
        panelQuitte.add(new JLabel());
        panelQuitte.add(new JLabel());
        panelQuitte.add(new JLabel());       
        panelQuitte.add(new JLabel());
        
        jouer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(Message.LANCERINSCRIPTION);
                clearChanged();
            }
        });

        quitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(Message.ANNULER);
                clearChanged();
            }
        });
        
    
        
}
    
    
      public static void main(String [] args) {
        // Instanciation de la fenêtre
        VueEcranTitre vuetitre = new VueEcranTitre();
    }

    @Override
    public void setVisible(Boolean b) {
        window.setVisible(b);
    }

    
    
    
}
