/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pioche;

import Grille.NomTuile;
import static Grille.NomTuile.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Nans
 */
public class Carte_Inondations {
    
    private ArrayList<Carte> pioche ;
    private ArrayList<Carte> defausse;    
    
    private Carte C1 = new Carte(LE_PONT_DES_ABIMES);
    private Carte C2 = new Carte(LA_PORTE_DE_BRONZE);
    private Carte C3 = new Carte(LA_CAVERNE_DES_OMBRES);
    private Carte C4 = new Carte(LA_PORTE_DE_FER);
    private Carte C5 = new Carte(LA_PORTE_D_OR);
    private Carte C6 = new Carte(LES_FALAISES_DE_L_OUBLI);
    private Carte C7 = new Carte(LE_PALAIS_DE_CORAIL);
    private Carte C8 = new Carte(LA_PORTE_D_ARGENT);
    private Carte C9 = new Carte(LES_DUNES_DE_L_ILLUSION);
    private Carte C10 = new Carte(HELIPORT);
    private Carte C11 = new Carte(LA_PORTE_DE_CUIVRE);
    private Carte C12 = new Carte(LE_JARDIN_DES_HURLEMENTS);
    private Carte C13 = new Carte(LA_FORET_POURPRE);
    private Carte C14 = new Carte(LE_LAGON_PERDU);
    private Carte C15 = new Carte(LE_MARAIS_BRUMEUX);
    private Carte C16 = new Carte(OBSERVATOIRE);
    private Carte C17 = new Carte(LE_ROCHER_FANTOME);
    private Carte C18 = new Carte(LA_CAVERNE_DU_BRASIER);
    private Carte C19 = new Carte(LE_TEMPLE_DU_SOLEIL);
    private Carte C20 = new Carte(LE_TEMPLE_DE_LA_LUNE);
    private Carte C21 = new Carte(LE_PALAIS_DES_MAREES);
    private Carte C22 = new Carte(LE_VAL_DU_CREPUSCULE);
    private Carte C23 = new Carte(LA_TOUR_DU_GUET);
    private Carte C24 = new Carte(LE_JARDIN_DES_MURMURES);

    public Carte_Inondations(){
        
        this.pioche = new ArrayList();
        this.defausse = new ArrayList();
        pioche.add(C1);
        pioche.add(C2);
        pioche.add(C3);
        pioche.add(C4);
        pioche.add(C5);
        pioche.add(C6);
        pioche.add(C7);
        pioche.add(C8);
        pioche.add(C9);
        pioche.add(C10);
        pioche.add(C11);
        pioche.add(C12);
        pioche.add(C13);
        pioche.add(C14);
        pioche.add(C15);
        pioche.add(C16);
        pioche.add(C17);
        pioche.add(C18);
        pioche.add(C19);
        pioche.add(C20);
        pioche.add(C21);
        pioche.add(C22);
        pioche.add(C23);
        pioche.add(C24);
        
        Collections.shuffle(pioche);
    }

    public ArrayList<Carte> getPioche() {
        return pioche;
    }

    public ArrayList<Carte> getDefausse() {
        return defausse;
    }
    
    
    
    public Carte piocheInondations(){
        Carte carte;
        carte = this.getPioche().get(0);
        this.getPioche().remove(0);
        this.getDefausse().add(carte);
        return carte;
    }
    
    public void remiseDefausse(){
        ArrayList<Carte> backup = this.getPioche();
        Collections.shuffle(this.getDefausse());
        this.pioche = this.getDefausse();
        for(Carte c : backup){
            this.getPioche().add(c);
        }
    }
    
}
