/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

import Controller.Message;
import Aventurier.Aventurier;
import Grille.Grille;
import Grille.NomTuile;
import static Grille.NomTuile.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;

import static javax.swing.SwingConstants.CENTER;
import javax.swing.border.MatteBorder;
import Utils.Utils.Pion;
import com.sun.java.swing.plaf.windows.resources.windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author avognonm
 */
public class VueDeplacement extends Vue {

    private final JFrame windows;
    private final JPanel mainPanels;
    private final JComboBox<Object> listeDep;
    private final JButton btnRetour;
    private final JButton btnSeDeplacer;
    private final JPanel panelBoutons ;

    public VueDeplacement (){

        this.windows = new JFrame();
        windows.setSize(480, 200);
        windows.setLocation(1030,500);
        windows.setResizable(false);
        //le titre = Déplacement//
        windows.setTitle("Déplacement");
        mainPanels = new JPanel(new GridLayout(3,1,1000,0));

        this.windows.add(mainPanels);

        mainPanels.setBackground(new Color(230, 230, 230));






        //=======================================================================

        /*Liste déroulante des déplacements*/
        this.listeDep = new JComboBox<>();
        mainPanels.add(listeDep);

        //=======================================================================


        //Bouton retour en bas de la fenêtre//
        this.panelBoutons = new JPanel(new GridLayout(2,2));
        this.panelBoutons.setOpaque(false);
        mainPanels.add(this.panelBoutons, BorderLayout.SOUTH);

        this.btnRetour = new JButton("Retour") ;
        this.btnSeDeplacer = new JButton("Se déplacer");



        panelBoutons.add(new JLabel());
        panelBoutons.add(new JLabel());
        panelBoutons.add(btnRetour);
        panelBoutons.add(btnSeDeplacer);


        //=======================================================================
        /* Action Listeners
         */

        btnSeDeplacer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(Message.VALIDERDEPLACEMENT);
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



    public JButton getBtnretour() {
        return btnRetour;
    }

    @Override
    public void setTuilesDispo(ArrayList<String> tu){
        listeDep.setModel(new DefaultComboBoxModel<>(tu.toArray()));
    }

    @Override
    public NomTuile getTuileSelectionnee(){
        NomTuile tuileTrouvee = null;
        int i  = 0;
        while(tuileTrouvee == null && i < NomTuile.values().length){
            if(NomTuile.values()[i] != null && NomTuile.values()[i].toString().equals(listeDep.getSelectedItem().toString())){
                tuileTrouvee = NomTuile.values()[i];
            }
            i++;
        }
        return tuileTrouvee;
    }

    //============================================================================

    @Override
    public void setVisible(Boolean b) {
        windows.setVisible(b);
    }



}


