/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

import Grille.Grille;
import static Utils.Utils.EtatTuile.ASSECHEE;
import static Utils.Utils.EtatTuile.INONDEE;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Nans pc
 */
public class VuePlateau {
    
    private final JFrame window;
    private final JPanel grilletuile;
    
    private HashMap<Integer,JPanel> cases=new HashMap();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

    public VuePlateau(Grille grille) {
        this.window = new JFrame();
        window.setSize(600, 600);
        this.grilletuile = new JPanel(new GridLayout(6, 6));
        window.add(grilletuile);
        for (int i=0; i<36; i++) {
             grilletuile.add(createCellule(i, grille));
        }
        
        
    }
    
        public void updateCellules(Grille grilleListe) {

        //Actualise l'affichage des pions
        for (int i=0; i<36; i++) {
            JPanel panel = cases.get(i);
            if (!(i==0 || i==1 || i==4 || i==5 || i==6 || i==11 || i==24 || i==29|| i==30 || i==31 | i==34 || i==35)){
                

                if (grilleListe.getTuile().get(i).getEtat() == ASSECHEE) {
                        panel.setBackground(Color.DARK_GRAY);
                    } else if (grilleListe.getTuile().get(i).getEtat()== INONDEE) {
                        panel.setBackground(Color.ORANGE);
                    
                    } else {
                        panel.setBackground(Color.BLUE);
                    }
                

                panel.repaint();
            }
        
        }
    }
 
        
    public JPanel createCellule(int i, Grille grilleListe) {        
        //Création des cellules :
        
        //création des cellules vides
        if(i==0 || i==1 || i==4 || i==5 || i==6 || i==11 || i==24 || i==29|| i==30 || i==31 | i==34 || i==35) {   
            JPanel panelCellule = new JPanel();
            panelCellule.setBackground(Color.BLACK);
            panelCellule.setSize(100,100);
            return panelCellule ;
            
        } else {
            //création des cellules tuiles
            
            //Ajout des pions
            JLabel nomCase = new JLabel(grilleListe.getTuile().get(i).getNom().toString(), SwingConstants.CENTER);
            JPanel panelCellule = new JPanel(new BorderLayout());
            panelCellule.setBorder(BorderFactory.createLineBorder(Color.white, 1));
            nomCase.setForeground(new Color(255,255,255));
            panelCellule.add(nomCase);
            
            //Coloration en gris des cellules assechées, en orange des cellules inondées et en bleu des cellules coulées
            if (null != grilleListe.getTuile().get(i).getEtat()) switch (grilleListe.getTuile().get(i).getEtat()) {
                case ASSECHEE:
                    panelCellule.setBackground(Color.DARK_GRAY);
                    break;
                case INONDEE:
                    panelCellule.setBackground(Color.ORANGE);
                    break;
                default:
                    panelCellule.setBackground(Color.BLUE);
                    break;
            }
            panelCellule.setSize(100,100);
            cases.put(i, panelCellule);
            return panelCellule ;
        }
    }

    public void setVisible(boolean b) {
        window.setVisible(b);
    }
    
    
    
}
