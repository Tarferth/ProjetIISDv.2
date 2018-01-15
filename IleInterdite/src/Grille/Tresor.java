/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grille;

import static Grille.NomTresor.*;
import static Grille.NomTuile.*;

/**
 *
 * @author Nans
 */
public class Tresor {
    private Tuile Sanctuaire1;//premiére tuile ou on peut récupérer le trésor
    private Tuile Sanctuaire2;//seconde tuile ou on peut récupérer le trésore
    private NomTresor nom;
    private boolean recuperer;

    public Tresor(NomTresor nom, Grille grille) {
        this.nom = nom;
        this.recuperer = false;
        this.setSanctuaire(grille);
        System.out.println(nom);
        System.out.println("Sanctuaire 1 :" + this.getSanctuaire1().getNom().toString());
        System.out.println("Sanctuaire 2 :" + this.getSanctuaire2().getNom().toString());
        System.out.println("");
        System.out.println("");
    }

    public Tuile getSanctuaire1() {
        return Sanctuaire1;
    }

    public Tuile getSanctuaire2() {
        return Sanctuaire2;
    }

    public NomTresor getNom() {
        return nom;
    }
    
    
    
    public void setSanctuaire(Grille grille){
        this.setSanctuaire1(grille);
        this.setSanctuaire2(grille);
    }

    //Place les différentes statues sur la grille
    public void setSanctuaire1(Grille grille) {
        String nom = this.getNom().toString();
        Tuile t1 = new Tuile();
        if (nom== CRISTAL.toString()) {
            t1=grille.getTuile(LA_CAVERNE_DES_OMBRES);
            
        } else if (nom== STATUE.toString())   {
            t1=grille.getTuile(LE_JARDIN_DES_HURLEMENTS);
            
        } else if (nom== PIERRE.toString()) {
            t1=grille.getTuile(LE_TEMPLE_DE_LA_LUNE);
            
        } else if (nom== CALICE.toString()) {
            t1=grille.getTuile(LE_PALAIS_DE_CORAIL);
        }
        this.setSanctuaire1(t1);
    }

    //Place les différentes statues sur la grille
    public void setSanctuaire2(Grille grille) {
        String nom=this.getNom().toString();
        Tuile t1 = new Tuile();
        if (nom== CRISTAL.toString()) {
            t1=grille.getTuile(LA_CAVERNE_DU_BRASIER);
        } else if (nom== STATUE.toString())   {
            t1=grille.getTuile(LE_JARDIN_DES_MURMURES);
        } else if (nom== PIERRE.toString()) {
            t1=grille.getTuile(LE_TEMPLE_DU_SOLEIL);
        } else if (nom== CALICE.toString()) {
            t1=grille.getTuile(LE_PALAIS_DES_MAREES);
        }
        this.setSanctuaire2(t1);
    }

    public void setSanctuaire1(Tuile Sanctuaire1) {
        this.Sanctuaire1 = Sanctuaire1;
    }

    public void setSanctuaire2(Tuile Sanctuaire2) {
        this.Sanctuaire2 = Sanctuaire2;
    }
    
    
    public boolean getRecuperable(){
        return !this.getSanctuaire1().aSombre() &&  !this.getSanctuaire2().aSombre() ;
    }

    public boolean isRecuperer() {
        return recuperer;
    }
    
    
    
    
    
}
