/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pioche;

import Grille.NomTuile;

/**
 *
 * @author Nans
 */
public class Carte {
    private String nom;
    
    public Carte(String nomCarte) {
        this.nom = nomCarte;
    }

    public Carte(Utils.Utils.Cartes carte) {
        this.nom=carte.toString();
    }
    
    public Carte(NomTuile carte) {
        this.nom=carte.toString();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }   
    
    
    
}
