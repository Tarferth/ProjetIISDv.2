/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

import Controller.Message;
import Model.NomTuile;
import static Model.NomTuile.LA_CAVERNE_DES_OMBRES;
import static Model.NomTuile.LA_PORTE_DE_BRONZE;
import static Model.NomTuile.LA_PORTE_DE_FER;
import static Model.NomTuile.LA_PORTE_D_OR;
import static Model.NomTuile.LE_PONT_DES_ABIMES;
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
        NomTuile tuileTrouvee = null;
        int i  = 0;
        while(tuileTrouvee == null && i < NomTuile.values().length){
            if(NomTuile.values()[i] != null && NomTuile.values()[i].toString().equals(listeAss.getSelectedItem().toString())){
                tuileTrouvee = NomTuile.values()[i];
            }
            i++;
        }
        return tuileTrouvee;
    }

    @Override
    public void setTuilesAss(ArrayList<String> tu){
        listeAss.setModel(new DefaultComboBoxModel<>(tu.toArray()));
    }
    //============================================================================


}
