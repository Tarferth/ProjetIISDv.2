/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.*;

/**
 *
 * @author barrerat
 */
public class Tuile {
    
    private ArrayList<Aventurier> aventuriers = new ArrayList();
    private int col;
    private int lig;
    private int etat;
    private NomTuile nom;
    
    public Tuile(NomTuile nom, int etat){
       setNom(nom);
       this.etat = etat;
    }
    
    // Etats de la tuile
    
    public boolean estSeche(){
        return etat == 0;
    }
    
    public boolean estInondee(){
        return etat == 1;
    }
    
    public boolean aSombre(){
        return etat == 2;
    }
    
    // Gestion des etats
    
    public void innonder(){
        if (etat == 0){                                                         // Si la case est Seche
            etat++;                                                             // Alors on passe l'état à "estInnondee"
        }
        else{                                                                   // Dans les autres cas on affiche un message d'erreur 
            System.out.println("Impossible d'innonder cette case"); // Pour la mise au point seulement
        }
        
    }
    
    public void assecher(){
        if (etat == 1){                                                         // Si la case est Innondée
            etat--;                                                             // Alors on passe l'état à "estSeche"
        }
        else{                                                                   // Dans les autres cas on affiche un message d'erreur
            System.out.println("Impossible d'assécher cette case");             // Pour la mise au point seulement
        }
    }

    @Override
    public String toString(){
        return nom.toString();
    }
    
    //Getters

    public int getCol(){
        return col;
    }
    
    public int getLig(){
        return lig;
    }

    public NomTuile getNom(){
        return nom;
    }
    

    //Setters
    
    public void setCol(int col){
        this.col = col;
    }

    public void setLig(int lig){
        this.lig = lig;
    }

    public void setNom(NomTuile nom){
        this.nom = nom;
    }

    // Ajout et suppression des aventuriers sur la tuile


    public ArrayList<Aventurier> getAventuriers() {
        return aventuriers;
    }

    public void addAventurier(Aventurier av){
        getAventuriers().add(av);
    }

    public void removeAventurier(Aventurier av){
        getAventuriers().remove(av);
    }



    
    
}
