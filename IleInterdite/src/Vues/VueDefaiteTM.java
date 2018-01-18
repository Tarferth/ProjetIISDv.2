/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author avognonm
 */
public class VueDefaiteTM extends Vue  {
    
    private JFrame window;
    private JPanel mainPanel;
    private JPanel panelBas;
    private JPanel panelMid;
    private JButton btnrejouer;
    private JLabel deftm;
    
    
    
    public VueDefaiteTM(){
        window = new JFrame();
        window.setTitle("Ile Interdite - Défaite");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(900, 400);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocationRelativeTo(null);
        mainPanel = new JPanel(new BorderLayout());
        window.add(mainPanel);
        window.setResizable(false);
        
        
        panelMid = new JPanel(new GridLayout(1,1));
        mainPanel.add(panelMid);
        
        deftm = new JLabel("Défaite ! Le marqueur de niveau à atteint la tête de mort !", SwingConstants.CENTER);
        panelMid.add(deftm);
        deftm.setFont(new Font("Serif", Font.BOLD, 28));
        panelMid.setBackground(Color.yellow);
        
        btnrejouer = new JButton("Rejouer !");
        
        panelBas = new JPanel(new GridLayout(1,3,10,10));
        mainPanel.add(panelBas, BorderLayout.SOUTH);
        
        panelBas.add(new JPanel());
        panelBas.add(btnrejouer);
        panelBas.add(new JPanel());
        
        
    
    }
    
    
    
    
    
    public static void main(String [] args) {
        // Instanciation de la fenêtre
        VueDefaiteTM vueTm = new VueDefaiteTM();
    }

    @Override
    public void setVisible(Boolean b) {
        window.setVisible(b);
    }
    
}