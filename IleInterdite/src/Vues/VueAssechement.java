/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

import Aventurier.Aventurier;
import Aventurier.Ingenieur;
import Controller.Message;
import Grille.NomTuile;
import static Grille.NomTuile.LA_CAVERNE_DES_OMBRES;
import static Grille.NomTuile.LA_PORTE_DE_BRONZE;
import static Grille.NomTuile.LA_PORTE_DE_FER;
import static Grille.NomTuile.LA_PORTE_D_OR;
import static Grille.NomTuile.LE_PONT_DES_ABIMES;
import Utils.Utils;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class VueAssechement extends Vue {

    private final JFrame windows;
    private final JPanel mainPanels;
    private final JButton btnRetour;
    private final JButton btnAssecher;
    private final JPanel panelBoutons ;
    private final JComboBox<Object> listeAss;
    private final JComboBox<Object> listeAssIng;

    public VueAssechement (){

        this.windows = new JFrame();
        windows.setSize(480, 200);
        windows.setLocation(1030,280);
        //le titre = nom du joueur
        windows.setTitle("Assèchement");
        mainPanels = new JPanel(new GridLayout(3,1));
        this.windows.add(mainPanels);

        mainPanels.setBackground(new Color(230, 230, 230));





        /*Liste déroulante des assèchements*/
        this.listeAss = new JComboBox<>();
        mainPanels.add(listeAss);
        this.listeAssIng = new JComboBox<>();
        mainPanels.add(listeAssIng);

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
        windows.setResizable(false);

        /* ACTION LISTENERS */
        btnAssecher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(Message.VALIDERASSECHEMENT);
                clearChanged();
            }
        });

        btnRetour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(Message.ANNULER);
                clearChanged();
            }
        });

    }
    public JButton getBtnRetour() {
        return btnRetour;
    }

    public JButton getBtnAssecher() {
        return btnAssecher;
    }




    public static void main(String [] args) {
        // Instanciation de la fenêtre
        VueAssechement vueass = new VueAssechement();
    }

    @Override
    public void setVisible(Boolean b) {
        windows.setVisible(b);
    }

    @Override
    public NomTuile getTuileSelectionnee(){
        if(listeAss.getSelectedItem() != null) {
            NomTuile nomTuileTrouvee = null;
            int i = 0;
            while (nomTuileTrouvee == null && i < NomTuile.values().length) {
                if (NomTuile.values()[i].toString().equals(listeAss.getSelectedItem().toString())) {
                    nomTuileTrouvee = NomTuile.values()[i];
                }
                i++;
            }
            return nomTuileTrouvee;
        } else {
            return null;
        }
    }
    
    public NomTuile getTuileSelectionneeIng(){
  
            NomTuile nomTuileTrouvee = null;
            int i = 0;
            while (nomTuileTrouvee == null && i < NomTuile.values().length) {
                if (NomTuile.values()[i].toString().equals(listeAssIng.getSelectedItem().toString())) {
                    nomTuileTrouvee = NomTuile.values()[i];
                }
                i++;
            }
            return nomTuileTrouvee;
        
    }



    @Override
    public void setTuilesAss(ArrayList<String> tu,Aventurier a){
        listeAss.setModel(new DefaultComboBoxModel<>(tu.toArray()));
        if(a.getClass() == Ingenieur.class){
            listeAssIng.setModel(new DefaultComboBoxModel<>(tu.toArray()));
            listeAssIng.setVisible(true);
        }else{
            listeAssIng.setVisible(false);
        }
    }
    //============================================================================


}
