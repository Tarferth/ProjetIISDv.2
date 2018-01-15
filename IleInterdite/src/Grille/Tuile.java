/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grille;

import Aventurier.Aventurier;
import Utils.Utils.EtatTuile;
import static Utils.Utils.EtatTuile.*;
import java.util.*;

/**
 *
 * @author barrerat
 */
public class Tuile {
    
    private ArrayList<Aventurier> aventuriers = new ArrayList();
    private int col;
    private int lig;
    private EtatTuile etat;
    private NomTuile nom;
    
    public Tuile(NomTuile nom, EtatTuile etat){
       setNom(nom);
       this.etat = etat;
    }

    public Tuile(){

    };
    
    // Etats de la tuile
    
    public boolean estSeche(){
        return etat == ASSECHEE;
    }
    
    public boolean estInondee(){
        return etat == INONDEE;
    }
    
    public boolean aSombre(){
        return etat == COULEE;
    }
    
    // Gestion des etats
    


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
    
    public EtatTuile getEtat() {
        return etat;
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

    public void setEtat(EtatTuile etat){
        this.etat = etat;
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
