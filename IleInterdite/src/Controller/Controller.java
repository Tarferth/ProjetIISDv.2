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
import static Aventurier.RôleAventurier.pilote;
import Utils.Parameters;
import Utils.Utils;
import Utils.Utils.*;
import Vues.*;


import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ThreadLocalRandom;
import static Controller.Message.ANNULER;
import Grille.NomTresor;
import static Grille.NomTresor.*;
import static Grille.NomTuile.HELIPORT;
import Grille.Tresor;
import Pioche.Carte;
import Pioche.Carte_Inondations;
import Pioche.Carte_Tresor;
import static Utils.Utils.Cartes.CRISTAL;
import static Utils.Utils.Cartes.EAUX;
import static Utils.Utils.Cartes.HELICOPTERE;
import static Utils.Utils.Cartes.SABLE;
import static Utils.Utils.EtatTuile.*;
import java.util.Collections;
import java.util.Scanner;


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
    private Tresor cristal = new Tresor(NomTresor.CRISTAL,grille);
    private int nivEau = 0;
    private boolean partiePerdue = false;
    
    private VuePlateau vueAvTest = new VuePlateau(grille);

    
    public Controller(){
        if (Parameters.LOGS) System.out.println("Début du jeu");

        //Création des vues
        VueEcranTitre vueEcranTitre = new VueEcranTitre();
        VueInscription vueInscription = new VueInscription();
        VueDeplacement vueDeplacement = new VueDeplacement();
        VueAssechement vueAssechement = new VueAssechement();
        VueVictoire vueVictoire = new VueVictoire();
        VueDefaiteHP vueDefaiteHp = new VueDefaiteHP();
        VueDefaiteTM vueDefaiteTm = new VueDefaiteTM();
        VueDefaiteTR vueDefaiteTr = new VueDefaiteTR();
        VueDefaiteTS vueDefaiteTs = new VueDefaiteTS();
        //Abonnement

        addView(vueInscription);
        addView(vueDeplacement);
        addView(vueAssechement);
        addView(vueVictoire);
        addView(vueDefaiteHp);
        addView(vueDefaiteTm);
        addView(vueDefaiteTr);
        addView(vueDefaiteTs);
        addView(vueEcranTitre);
        vueEcranTitre.setVisible(true);


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
            nivEau = -1;
            piocheInondation();
            nivEau = 0;
            int jCourantBU = joueurCourant;//sauvegarde le joueur courant avant de donner 2 carte à chaque joueur
            for(int i =0; i<aventuriers.size();i++){
                joueurCourant = i;
                 piocheTresorInit();
            }
            joueurCourant = jCourantBU;
            
        for (int i =0; i < vuesAventurier.size(); i++){
            vuesAventurier.get(i).setVisible(true);
            activerBtn(joueurCourant%aventuriers.size());
            
        }
        
        pierre.setRecuperer(true);
        calice.setRecuperer(true);
        statue.setRecuperer(true);
        vueAvTest.setVisible(true);

    }

    @Override
    public void update(Observable o, Object arg){
        /* INSCRIPTION JOUEURS */
        if(arg == Message.LANCERINSCRIPTION){
            vues.get(8).setVisible(false);
            vues.get(0).setVisible(true);
        }
        
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
                vuesAventurier.get(joueurCourant%aventuriers.size()).setLabel(getJoueurCourant().getPos().toString());
                activerBtn(joueurCourant%aventuriers.size());
            }
        }else if(arg == Message.ANNULER){
            ((Vue) o).setVisible(false);
        }

        // Vue Assèchement

        if(arg == Message.ASSECHER){
            vues.get(2).setTuilesAss(getJoueurCourant().getTuilesAssechables(this.grille),getJoueurCourant());
            vues.get(2).setVisible(true);
        }

        if(arg == Message.VALIDERASSECHEMENT){
            if(((Vue) o).getTuileSelectionnee() == null){
                JOptionPane erreur = new JOptionPane();
                erreur.showMessageDialog(null, "Aucune tuile n'a été sélectionnée/Ne peut être asséchée", "Erreur", JOptionPane.ERROR_MESSAGE);
            }

            else if(((Vue) o).getTuileSelectionnee() != null){
                getGrille().getTuile(((Vue) o).getTuileSelectionnee()).setEtat(ASSECHEE);
                if(getJoueurCourant().getClass() == Ingenieur.class && getGrille().getTuile(((Vue) o).getTuileSelectionneeIng())!=null){
                    getGrille().getTuile(((Vue) o).getTuileSelectionneeIng()).setEtat(ASSECHEE);
                }
                vues.get(2).setVisible(false);
                vueAvTest.updateCellules(grille);
                nbActions++;
            }
        }else if(arg == Message.ANNULER){
            ((Vue) o).setVisible(false);
        }

        if(arg == Message.FINTOUR){
            finTour = true;
        }
      
        if(arg == Message.ECHANGECARTE){
            int i =1;
            for(int j = 0; j<aventuriers.size();j++){
                    if(aventuriers.get(j)!= getJoueurCourant()){
                        System.out.println(i+" : "+aventuriers.get(j).getTypeA().toString());
                        System.out.println();
                        i++;
                    }
            }
            
            System.out.println("0 : Retour");
            Scanner sc = new Scanner(System.in);
            int nb = sc.nextInt();
            if(nb ==0){
                arg = ANNULER;
            }else{
                getJoueurCourant().afficheMain();
                System.out.println("0 : Retour");
                Scanner sc2 = new Scanner(System.in);
                int nb2 = sc2.nextInt();
                getJoueurCourant().echangeCarte(getJoueurCourant().getPos().getAventuriers().get(nb-1),getJoueurCourant().getMain().get(nb2-1));
            }
            nbActions++; 
        }
        
        if(arg == Message.UTILISECARTE){
            System.out.println("Utiliser une carte");
            int i =1;
            ArrayList<Carte> carte = new ArrayList();
            for(Carte c: getJoueurCourant().getMain()){
                if(c.getNom() == HELICOPTERE.toString() || c.getNom() == SABLE.toString()){
                    System.out.println(i+" : "+c.getNom());
                    i++;
                    carte.add(c);
                }
            }
            
            System.out.println("0 : Retour");
            Scanner sc = new Scanner(System.in);
            int nb = sc.nextInt();
            
            if(nb ==0){
                arg = ANNULER;
            }else{
                nbActions++;
                getJoueurCourant().remove(carte.get(nb));
                piocheTresor.defausseCarte(carte.get(nb));
                if(carte.get(nb).getNom() == HELICOPTERE.toString()){
                    vues.get(1).setTuilesDispo(((Pilote) getJoueurCourant()).getTuilesAccessibles(this.grille));
                    vues.get(1).setVisible(true);
                }else if(carte.get(nb).getNom() == SABLE.toString()){
                    vues.get(2).setTuilesAss(getJoueurCourant().getTuilesAssechables(this.grille),getJoueurCourant());
                    vues.get(2).setVisible(true);
                }
            }
        }
        
        if(arg == Message.RECUPTRE){
            recupTresor();
            System.out.println(getJoueurCourant().getPos().getTresor().toString()+" recuper");
            desactiverBtn(joueurCourant%aventuriers.size());
            activerBtn(joueurCourant%aventuriers.size());
            nbActions++;
        }
        
        if(arg == Message.DEFAUSSE){
            getJoueurCourant().afficheMain();
            System.out.println("0 : Retour");
            Scanner sc = new Scanner(System.in);
            int nb = sc.nextInt();
            if(nb == 0){
                arg= ANNULER;
            }else{
                piocheTresor.defausseCarte(getJoueurCourant().getMain().get(nb-1));
                getJoueurCourant().getMain().remove(nb-1);                
            }
        }
        
       
        
        /*Depalcement obligatoires*/
        if ( arg == Message.DEPLACEROBLIG){
            for(Aventurier a :sontSombre()){
                    vues.get(1).setTuilesDispo(a.getTuilesAccessibles(this.grille));
                    vues.get(1).setVisible(true);
                    
            }
        }
        
        /*Defausse obligatoir*/
        
        if ( arg == Message.DEFAUSSEOBLIG){
            getJoueurCourant().afficheMain();
            System.out.println("Vous aver plus de 5 carte en main defauser vous :");
            Scanner sc = new Scanner(System.in);
            int nb = sc.nextInt();
            
                piocheTresor.defausseCarte(getJoueurCourant().getMain().get(nb-1));
                getJoueurCourant().getMain().remove(nb-1);                
            
        }        
                

        /* GESTION DU TOUR DE JEU */



        if(inscriptionFini){
            if(getJoueurCourant().getNbActionsMax() == nbActions){
                finTour = true;
                for(Aventurier a : aventuriers){
                    desactiverBtn(aventuriers.indexOf(a));
                }
            }

            if(finTour){
                desactiverBtn(joueurCourant%aventuriers.size());
                getJoueurCourant().setMoveSpé(false);
                if(!JoueurInnonder()){
                piocheTresor();
                piocheInondation();
                }
//                if(JoueurInnonder()){
//                    arg = Message.DEPLACEROBLIG;
//                }else{
                    if(getJoueurCourant().getMain().size()>5){
                        arg = Message.DEFAUSSEOBLIG;
                    }
               
                    if(!this.victoire() && !defaite()){  
                        
                        joueurCourant++;
                        nbActions = 0;
                        finTour = false;
                        activerBtn(joueurCourant%aventuriers.size());
                        System.out.println("");
                        System.out.println(getJoueurCourant().getClass().toString());;
                        System.out.println("");
                        getJoueurCourant().afficheMain();
                        System.out.println("");
                        System.out.println("");
                    }else {
                        for (int i =0; i < vuesAventurier.size(); i++){
                            vuesAventurier.get(i).setVisible(false);
                            desactiverBtn(joueurCourant%aventuriers.size());
                        }
                        if (defaite()){


                            if(verifInnodations()){
                                 vues.get(7).setVisible(true);
                            }else if(tresNonRecuperable()){
                                 vues.get(6).setVisible(true);
                            }else if(heliporSombre()){
                                 vues.get(4).setVisible(true);
                            }else{
                                 vues.get(5).setVisible(true);
                            }
                        }else if(victoire()){
                            vues.get(3).setVisible(true);
//                        }
                    }
                }
            }
        }
    }

    public void deplacer(Aventurier joueur){
        joueur.setPos(getJoueurCourant().getPos());
    }

    public void desactiverBtn(int vue){
        vuesAventurier.get(joueurCourant%aventuriers.size()).setLabel(getJoueurCourant().getPos().toString());
        
        vuesAventurier.get(joueurCourant%aventuriers.size()).getBtnAssecher().setEnabled(false);
        vuesAventurier.get(joueurCourant%aventuriers.size()).getBtnBouger().setEnabled(false);
        vuesAventurier.get(joueurCourant%aventuriers.size()).getBtnTerminerTour().setEnabled(false);
        vuesAventurier.get(joueurCourant%aventuriers.size()).getBtnEchangeCarte().setEnabled(false);
        
        vuesAventurier.get(joueurCourant%aventuriers.size()).getBtnRecupTre().setEnabled(false);
        vuesAventurier.get(joueurCourant%aventuriers.size()).getBtnUtiliserCarte().setEnabled(false);
        vuesAventurier.get(joueurCourant%aventuriers.size()).getBtnDefausseCarte().setEnabled(false);
        
    }

    public void activerBtn(int vue){
        vuesAventurier.get(joueurCourant%aventuriers.size()).setLabel(getJoueurCourant().getPos().toString());
        vuesAventurier.get(joueurCourant%aventuriers.size()).getBtnAssecher().setEnabled(true);
        vuesAventurier.get(joueurCourant%aventuriers.size()).getBtnBouger().setEnabled(true);
        vuesAventurier.get(joueurCourant%aventuriers.size()).getBtnTerminerTour().setEnabled(true);
        
        if(aventuriers.get(joueurCourant%aventuriers.size()).getPos().getAventuriers().size()>=2){
            
            vuesAventurier.get(joueurCourant%aventuriers.size()).getBtnEchangeCarte().setEnabled(true);
        }
        if(recupTresorPossible()){
            vuesAventurier.get(joueurCourant%aventuriers.size()).getBtnRecupTre().setEnabled(true);
        }
        if(mainContient()){
            vuesAventurier.get(joueurCourant%aventuriers.size()).getBtnUtiliserCarte().setEnabled(true);
        }
        if(aventuriers.get(joueurCourant%aventuriers.size()).getMain().size()>0){
            vuesAventurier.get(joueurCourant%aventuriers.size()).getBtnDefausseCarte().setEnabled(true);
        }
        if(aventuriers.get(joueurCourant%aventuriers.size()).getMain().size()>0){
            vuesAventurier.get(joueurCourant%aventuriers.size()).getBtnDefausseCarte().setEnabled(true);
        }
    }
    
    public void activerBtnOblig(int vue){
        desactiverBtn(vue);
        vuesAventurier.get(joueurCourant%aventuriers.size()).getBtnBouger().setEnabled(true);
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
                piocheTresor.defausseCarte(carte);
                piocheInondations.remiseDefausse();
                System.out.println("");
                System.out.println("Monté de eaux");
                System.out.println("");
            }else{
                getJoueurCourant().getMain().add(carte);
            }
        }
    }
    public void piocheTresorInit(){
        for(int i=0;i<2;i++){
            Carte carte = piocheTresor.piocheCarte();
             if(carte.getNom().toString() == EAUX.toString()){
                piocheTresor.getPioche().add(carte);
                Collections.shuffle(piocheTresor.getPioche());
            }else{
                getJoueurCourant().getMain().add(carte);
            }
        }
    }
    
    public void piocheInondation(){
        int nbLoop =2;
        if(nivEau<0){
            nbLoop =6;
        }else if(nivEau<2){
            
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
        
        vueAvTest.updateCellules(grille);
    }
    
    public boolean nbCarteTres(Tresor tresor){//verifie si le joueur à 4 carte qui correspondent au trésor
        int nb=0;
        for(Carte c :getJoueurCourant().getMain()){
                if(c.getNom().toString() == tresor.getNom().toString()){
                    nb++;
                }
        }
        return nb>=4;
    }
    
    public void recupTresor(){//recupere le tresor si le joueur se situe sur un des sanctuaires lié au trésor et si le joueuer à 4 carte correspondant au trésor
        
        if((getJoueurCourant().getPos() == calice.getSanctuaire1() || getJoueurCourant().getPos() == calice.getSanctuaire2()) && nbCarteTres(calice)){
            calice.setRecuperer(true);
        }else if((getJoueurCourant().getPos() == pierre.getSanctuaire1() || getJoueurCourant().getPos() == pierre.getSanctuaire2()) && nbCarteTres(pierre)){
            pierre.setRecuperer(true);
        }else if((getJoueurCourant().getPos() == statue.getSanctuaire1() || getJoueurCourant().getPos() == statue.getSanctuaire2()) && nbCarteTres(statue)){
            statue.setRecuperer(true);
        }else if((getJoueurCourant().getPos() == cristal.getSanctuaire1() || getJoueurCourant().getPos() == cristal.getSanctuaire2()) && nbCarteTres(cristal)){
            cristal.setRecuperer(true);
        }
    }
    
    public boolean recupTresorPossible(){//retourne vrai si le joueur se situe sur un des sanctuaires lié au trésor et si le joueuer à 4 carte correspondant au trésor
        
        if((getJoueurCourant().getPos() == calice.getSanctuaire1() || getJoueurCourant().getPos() == calice.getSanctuaire2()) && nbCarteTres(calice)){
            return true;
        }else if((getJoueurCourant().getPos() == pierre.getSanctuaire1() || getJoueurCourant().getPos() == pierre.getSanctuaire2()) && nbCarteTres(pierre)){
            return true;
        }else if((getJoueurCourant().getPos() == statue.getSanctuaire1() || getJoueurCourant().getPos() == statue.getSanctuaire2()) && nbCarteTres(statue)){
            return true;
        }else if((getJoueurCourant().getPos() == cristal.getSanctuaire1() || getJoueurCourant().getPos() == cristal.getSanctuaire2()) && nbCarteTres(cristal)){
            return true;
        }else{
            return false;
        }
    }
      
    public boolean verifInnodations(){
        boolean fin = false;
        for(Aventurier a :aventuriers){
            if(a.getPos().aSombre() && a.getTuilesAccessibles(grille).isEmpty() ){
                    fin=true;               
            }
        }
        return fin;
    }
    
    public boolean JoueurInnonder(){
        boolean fin = false;
        for(Aventurier a :aventuriers){
            if(a.getPos().aSombre()){
                    fin=true;               
            }
        }
        return fin;
    }
    
    public boolean tresNonRecuperable(){
        return !calice.getRecuperable() || !statue.getRecuperable() || !pierre.getRecuperable() || !cristal.getRecuperable();
    }
    
    public boolean heliporSombre(){
        return grille.getTuile(HELIPORT).aSombre();
    }
    
    public boolean mortNivEau(){
        return nivEau>=9;
    }
    
    public boolean defaite(){
        return verifInnodations() || tresNonRecuperable() || heliporSombre() || mortNivEau();
    }

    public boolean mainContient(){
        boolean boolRet = false;
        for(Carte c :aventuriers.get(joueurCourant%aventuriers.size()).getMain()){
            if(c.getNom()== HELICOPTERE.toString() || c.getNom() == SABLE.toString()){
                boolRet = true;
            }
        }
        return boolRet;
    }
    /* GETTERS ET SETTERS */


    private Grille getGrille(){
        return this.grille;
    }

    public Aventurier getJoueurCourant(){
        return aventuriers.get(joueurCourant%aventuriers.size());
    }
    
    public ArrayList<Aventurier> sontSombre(){
        ArrayList<Aventurier> listret = new ArrayList();
        for(int i=0;i<aventuriers.size();i++){
            if(aventuriers.get(i).getPos().aSombre()){
                listret.add(aventuriers.get(i));
            }
        }
        
        return listret;
    }




    
}

