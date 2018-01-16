/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Grille.Grille;
import Grille.NomTuile;
import Aventurier.Navigateur;
import Aventurier.Ingenieur;
import Aventurier.Plongeur;
import Aventurier.Explorateur;
import Aventurier.Pilote;
import Aventurier.Messager;
import Aventurier.Aventurier;
import Utils.Parameters;
import Utils.Utils;
import Utils.Utils.*;
import Vues.*;
import javafx.scene.paint.Color;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ThreadLocalRandom;
import static Aventurier.RôleAventurier.pilote;
import static Grille.NomTresor.*;
import static Grille.NomTuile.HELIPORT;
import Grille.Tresor;
import Pioche.Carte;
import Pioche.Carte_Inondations;
import Pioche.Carte_Tresor;
import static Utils.Utils.Cartes.EAUX;
import static Utils.Utils.Cartes.HELICOPTERE;
import static Utils.Utils.EtatTuile.*;


/**
 *
 * @author barrerat
 */
public class Controller implements Observer {

    private int joueurCourant = 0;
    private int nbActions = 0;
    private boolean finTour = false;
    private int tour;
    private boolean finTourPlateau = false;
    private boolean inscriptionFini = false;
    private ArrayList<VueAventurier> vuesAventurier = new ArrayList<>();
    private ArrayList<Aventurier>aventuriers = new ArrayList<>();
    private ArrayList<Vue>vues = new ArrayList<>();
    Grille grille = new Grille();
    private Carte_Tresor piocheTresor = new  Carte_Tresor();
    private Carte_Inondations piocheInondations = new Carte_Inondations();
    private Tresor calice = new Tresor(CALICE,grille);
    private Tresor pierre = new Tresor(PIERRE,grille);
    private Tresor statue = new Tresor(STATUE,grille);
    private Tresor cristal = new Tresor(CRISTAL,grille);
    private int nivEau = 0;
    private boolean partiePerdue = false;


    public Controller(){
        if (Parameters.LOGS) System.out.println("Début du jeu");

        getGrille().getTuiles()[2][2].setEtat(COULEE);
        getGrille().getTuiles()[3][2].setEtat(COULEE);
        getGrille().getTuiles()[4][2].setEtat(COULEE);
        getGrille().getTuiles()[3][4].setEtat(COULEE);
        getGrille().getTuiles()[0][3].setEtat(INONDEE);
        getGrille().getTuiles()[3][1].setEtat(INONDEE);
        getGrille().getTuiles()[3][3].setEtat(INONDEE);
        getGrille().getTuiles()[3][5].setEtat(INONDEE);
        getGrille().getTuiles()[5][3].setEtat(INONDEE);


        //Création des vues
        VueInscription vueInscription = new VueInscription();
        VueDeplacement vueDeplacement = new VueDeplacement();
        VueAssechement vueAssechement = new VueAssechement();

        //Abonnement

        addView(vueInscription);
        addView(vueDeplacement);
        addView(vueAssechement);


        vueInscription.setVisible(true);


    }

    public void addView(Vue vue){
        vue.abonner(this);
        vues.add(vue);
    }

    public void addViewAventurier(VueAventurier vue){
        vue.abonner(this);
        vuesAventurier.add(vue);
    }

    public void lancerPartie(){
        for (int i =0; i < vuesAventurier.size(); i++){
            vuesAventurier.get(i).setVisible(true);
            activerBtn(joueurCourant%aventuriers.size());
        }
    }

    @Override
    public void update(Observable o, Object arg){
        /* INSCRIPTION JOUEURS */

        if (arg == Message.LANCERPARTIE){

            //On crée les aventuriers

            ArrayList<String> pseudosJoueurs = ((VueInscription)o).getPseudosJoueurs();

            ArrayList<String> typeAventuriers = new ArrayList<>();
            typeAventuriers.addAll(Arrays.asList("Messager", "Ingénieur", "Navigateur", "Pilote", "Explorateur","Plongeur")); // Plongeur pas encore géré

            //Attribution des types d'aventurier au hasard

            for(int i = 0; i < pseudosJoueurs.size(); i++){
                int randomAventurier = ThreadLocalRandom.current().nextInt(0,6-i);


                switch(typeAventuriers.get(randomAventurier)){
                    case "Messager":
                        Aventurier messager = new Messager(pseudosJoueurs.get(i),this.getGrille().getTuile(NomTuile.LA_PORTE_D_ARGENT));
                        aventuriers.add(messager);

                        VueAventurier vueAventurier = new VueAventurier(pseudosJoueurs.get(i), "Messager", Pion.VIOLET.getCouleur(), aventuriers.size()-1);
                        addViewAventurier(vueAventurier);
                        break;
                    case "Ingénieur":
                        Aventurier ingenieur = new Ingenieur(pseudosJoueurs.get(i),this.getGrille().getTuile(NomTuile.LA_PORTE_DE_BRONZE));
                        aventuriers.add(ingenieur);

                        VueAventurier vueAventurier2 = new VueAventurier(pseudosJoueurs.get(i), "Ingénieur", Pion.ROUGE.getCouleur(), aventuriers.size()-1);
                        addViewAventurier(vueAventurier2);
                        break;
                    case "Navigateur":
                        Aventurier navigateur = new Navigateur(pseudosJoueurs.get(i),this.getGrille().getTuile(NomTuile.LA_PORTE_D_OR));
                        aventuriers.add(navigateur);

                        VueAventurier vueAventurier3 = new VueAventurier(pseudosJoueurs.get(i), "Navigateur", Pion.JAUNE.getCouleur(), aventuriers.size()-1);
                        addViewAventurier(vueAventurier3);
                        break;
                    case "Pilote":
                        Aventurier pilote = new Pilote(pseudosJoueurs.get(i),this.getGrille().getTuile(NomTuile.HELIPORT));
                        aventuriers.add(pilote);

                        VueAventurier vueAventurier4 = new VueAventurier(pseudosJoueurs.get(i), "Pilote", Pion.BLEU.getCouleur(), aventuriers.size()-1);
                        addViewAventurier(vueAventurier4);
                        break;
                    case "Explorateur":
                        Aventurier explorateur = new Explorateur(pseudosJoueurs.get(i),this.getGrille().getTuile(NomTuile.LA_PORTE_DE_CUIVRE));
                        aventuriers.add(explorateur);

                        VueAventurier vueAventurier5 = new VueAventurier(pseudosJoueurs.get(i), "Explorateur", Pion.VERT.getCouleur(), aventuriers.size()-1);
                        addViewAventurier(vueAventurier5);
                        break;
                        
                    case "Plongeur":
                        Aventurier plongeur = new Plongeur(pseudosJoueurs.get(i),this.getGrille().getTuile(NomTuile.LA_PORTE_DE_FER));
                        aventuriers.add(plongeur);

                        VueAventurier vueAventurier6 = new VueAventurier(pseudosJoueurs.get(i), "plongeur", Pion.ORANGE.getCouleur(), aventuriers.size()-1);
                        addViewAventurier(vueAventurier6);
                        break;
                }

                typeAventuriers.remove(typeAventuriers.get(randomAventurier)); //Pour éviter les doublons
            }

            ((VueInscription) o).setVisible(false);
            inscriptionFini = true;
            lancerPartie();
        }

        /* ACTIONS DES AVENTURIERS */


        if(arg == Message.DEPLACER){
            vues.get(1).setTuilesDispo(getJoueurCourant().getTuilesAccessibles(this.grille));
            vues.get(1).setVisible(true);

        }

        //Vue déplacement

        if(arg == Message.VALIDERDEPLACEMENT){
            if(((Vue) o).getTuileSelectionnee() == null){
                JOptionPane erreur = new JOptionPane();
                erreur.showMessageDialog(null, "Aucune tuile n'a été sélectionnée.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }

            else if(((Vue) o).getTuileSelectionnee() != null){
                getJoueurCourant().setPos(getGrille().getTuile(((Vue) o).getTuileSelectionnee()));
                if(getJoueurCourant().getClass() == Pilote.class){
                    getJoueurCourant().setMoveSpé(true);
                    if(getJoueurCourant().getTuilesAccessibles(grille).contains(getJoueurCourant().getPosPrecedente())){
                        getJoueurCourant().setMoveSpé(false);
                    }
                }
                vues.get(1).setVisible(false);
                nbActions++;
            }
        }else if(arg == Message.ANNULER){
            ((Vue) o).setVisible(false);
        }

        // Vue Assèchement

        if(arg == Message.ASSECHER){
            vues.get(2).setTuilesAss(getJoueurCourant().getTuilesAssechables(this.grille));
            vues.get(2).setVisible(true);
        }

        if(arg == Message.VALIDERASSECHEMENT){
            if(((Vue) o).getTuileSelectionnee() == null){
                JOptionPane erreur = new JOptionPane();
                erreur.showMessageDialog(null, "Aucune tuile n'a été sélectionnée/Ne peut être asséchée", "Erreur", JOptionPane.ERROR_MESSAGE);
            }

            else if(((Vue) o).getTuileSelectionnee() != null){
                getGrille().getTuile(((Vue) o).getTuileSelectionnee()).setEtat(ASSECHEE);
                vues.get(2).setVisible(false);
                if(getJoueurCourant().getClass() == Ingenieur.class){
                    
                }
                nbActions++;
            }
        }else if(arg == Message.ANNULER){
            ((Vue) o).setVisible(false);
        }

        if(arg == Message.FINTOUR){
            finTour = true;
        }

        if (arg == Message.AUTREACTION) {
            Utils.afficherInformation("Fonctionnalité non disponible");
        }


        /* GESTION DU TOUR DE JEU */



        if(inscriptionFini){
            if(getJoueurCourant().getNbActionsMax() == nbActions){
                finTour = true;
            }

            if(finTour){
                desactiverBtn(joueurCourant%aventuriers.size());
                getJoueurCourant().setMoveSpé(false);
                piocheTresor();
                
                
                if(!this.victoire()){  
                    joueurCourant++;
                    nbActions = 0;
                    finTour = false;
                    activerBtn(joueurCourant%aventuriers.size());
                }else{
                    
                }
            }
        }


    }

    public void deplacer(Aventurier joueur){
        joueur.setPos(getJoueurCourant().getPos());
    }

    public void desactiverBtn(int vue){
        vuesAventurier.get(joueurCourant%aventuriers.size()).getBtnAssecher().setEnabled(false);
        vuesAventurier.get(joueurCourant%aventuriers.size()).getBtnAutreAction().setEnabled(false);
        vuesAventurier.get(joueurCourant%aventuriers.size()).getBtnBouger().setEnabled(false);
        vuesAventurier.get(joueurCourant%aventuriers.size()).getBtnTerminerTour().setEnabled(false);
    }

    public void activerBtn(int vue){
        vuesAventurier.get(joueurCourant%aventuriers.size()).getBtnAssecher().setEnabled(true);
        vuesAventurier.get(joueurCourant%aventuriers.size()).getBtnAutreAction().setEnabled(true);
        vuesAventurier.get(joueurCourant%aventuriers.size()).getBtnBouger().setEnabled(true);
        vuesAventurier.get(joueurCourant%aventuriers.size()).getBtnTerminerTour().setEnabled(true);
    }

    public boolean tresorsRecup(){//verifie si tout les trésors ont été récupere
        return calice.isRecuperer() &&  pierre.isRecuperer() && statue.isRecuperer() && cristal.isRecuperer();
    }
    
    public boolean positionHeliport(){//verifier si tout les joueurs sont sur l'héliport
        boolean position =true;
        for(Aventurier a : aventuriers){
            position = position && ( a.getPos().getNom() == HELIPORT  );
        }
        
        return position;
    }
    
    public boolean possedeHelico(){//verifie si les joueur possede au moins un hélioptére dans leur main
        boolean helico = false;
        for(Aventurier a : aventuriers){
            for(Carte c : a.getMain()){
                if(c.getNom()== HELICOPTERE.toString()){
                    helico = true;
                }
            }
        }
        return helico;
    }
    
    public boolean victoire(){// verifie si les condition de victoire sont rempli
        return this.tresorsRecup() && this.positionHeliport() && possedeHelico(); 
    }
        
    public void piocheTresor(){
        for(int i=0;i<2;i++){
            Carte carte = piocheTresor.piocheCarte();
             if(carte.getNom().toString() == EAUX.toString()){
                nivEau++;
                piocheTresor.getDefausse().add(carte);
            }else{
                getJoueurCourant().getMain().add(carte);
            }
        }
    }
    
    public void piocheInondation(){
        int nbLoop =2;
        if(nivEau<2){
            
        }else if(nivEau<5){
            nbLoop =3;
        }else if(nivEau<7){
            nbLoop = 4;
        }else if(nivEau<9){
            nbLoop = 5;
        }
        
        for(int i=0;i<nbLoop; i++){
            int j =0;
            Carte carte = piocheInondations.piocheInondations();
            NomTuile[] nomTs = NomTuile.values();
            for(NomTuile nomT: nomTs){
                if(grille.getTuile(nomT).getNom().toString() == carte.getNom()){
                    grille.getTuile(nomT).monterDesEaux();
                    if(grille.getTuile(nomT).aSombre()){
                        piocheInondations.remove(carte);
                    }
                }
            }
            
        }
    }

    /* GETTERS ET SETTERS */


    private Grille getGrille(){
        return this.grille;
    }

    public Aventurier getJoueurCourant(){
        return aventuriers.get(joueurCourant%aventuriers.size());
    }




    
}

