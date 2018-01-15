/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grille;

/**
 *
 * @author Nans
 */
public enum NomTresor {
    CRISTAL("Le Cristal ardent"), 
    STATUE("La Statue du zéphir"),
    PIERRE("La Pierre sacrée"),
    CALICE("Le Calice de l'onde");

    String libelle;

    NomTresor(String libelle) {
        this.libelle = libelle ;
    }

    @Override
    public String toString() {
        return this.libelle;
    }
    
}
