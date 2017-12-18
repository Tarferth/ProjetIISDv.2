/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.lang.reflect.Array;
import java.util.*;


/**
 *
 * @author barrerat
 */
public class Grille {

    private Tuile[][] tuiles = new Tuile[6][6];

    public Grille(ArrayList<Tuile> tu){
        /*
               j
          i |0.0|0.1|0.2|0.3|0.4|0.5|    plateau de jeu :         |0.2|0.3|
            |1.0|1.1|1.2|1.3|1.4|1.5|                         |1.1|1.2|1.3|1.4|
            |2.0|2.1|2.2|2.3|2.4|2.5|                     |2.0|2.1|2.2|2.3|2.4|2.5|
            |3.0|3.1|3.2|3.3|3.4|3.5|                     |3.0|3.1|3.2|3.3|3.4|3.5|
            |4.0|4.1|4.2|4.3|4.4|4.5|                         |4.1|4.2|4.3|4.4|
            |5.0|5.1|5.2|5.3|5.4|5.5|                             |5.2|5.3|
         */
        int x = 0;
        for (int i = 0; i < 6; i++){       //Lignes
            for (int j = 0; j < 6; j++){   //Colonnes
                if ((i == 0 && j == 0) || (i == 1 && j == 0) || (i == 0 && j == 1) ||     //si la tuile est dans cette liste                            // Coin haut gauche
                        (i == 0 && j == 4) || (i == 0 && j == 5) || (i == 1 & j == 5) ||                                // Coin haut droit
                        (i == 4 && j == 0) || (i == 5 && j == 0) || (i == 5 & j == 1) ||                                // Coin bas gauche
                        (i == 4 && j == 5) || (i == 5 && j == 5) || (i == 5 && j == 4)){                                 //Coin bas droit

                    tuiles[i][j] = null;                                              // Alors elle est vide

                }
                else{
                    tuiles[i][j] = new Tuile(NomTuile.values()[x], 0);
                    x++;
                }

            }
        }
    }


    /* TUILES ADJACENTES */

    public int[] getCoordonneesTuile(Tuile tuile){
        int[] coordonnees = new int[2];
        for(int i = 0; i < 6 ; i++) { // Ligne
            for (int j = 0; j < 6; j++) { // Colonne
                if (tuile.toString().equals(tuiles[i][j].toString())){
                    coordonnees[0] = i;
                    coordonnees[1] = j;
                }
            }
        }
        return coordonnees;
    }


    
    public ArrayList<Tuile> getTuilesAdjacentes(Tuile tu, Messages message){
        ArrayList<Tuile> tuilesAdjacentes = new ArrayList<>();
        int[] coordonnees = this.getCoordonneesTuile(tu);

        if (message == Messages.ASSECHER){
            if (coordonnees[0] != 0 && tuiles[coordonnees[0] - 1][coordonnees[1]] != null && tuiles[coordonnees[0]-1][coordonnees[1]].estInondee()){  // On vérifie que la tuile en haut est inondée
                tuilesAdjacentes.add(tuiles[coordonnees[0]-1][coordonnees[1]]);                 // Si oui, on l'ajoute à la collection
            }
            if (coordonnees[0] != 5 && tuiles[coordonnees[0] +1][coordonnees[1]] != null && tuiles[coordonnees[0]+1][coordonnees[1]].estInondee()){ // On vérifie que la tuile en bas est inondée
                tuilesAdjacentes.add(tuiles[coordonnees[0]+1][coordonnees[1]]);                // Si oui, on l'ajoute à la collection
            }
            if (coordonnees[1] != 0 && tuiles[coordonnees[0]][coordonnees[1] -1] != null && tuiles[coordonnees[0]][coordonnees[1]-1].estInondee()){ // On vérifie que la tuile à gauche est inondée
                tuilesAdjacentes.add(tuiles[coordonnees[0]][coordonnees[1]-1]);                // Si oui, on l'ajoute à la collection
            }
            if (coordonnees[1] != 5 && tuiles[coordonnees[0]][coordonnees[1] +1] != null && tuiles[coordonnees[0]][coordonnees[1]+1].estInondee()){ // On vérifie que la tuile à droite est inondée
                tuilesAdjacentes.add(tuiles[coordonnees[0]][coordonnees[1]+1]);                // Si oui, on l'ajoute à la collection
            }
            if (tu.estInondee()) {                                                             // Si la tuile tu est inondée
                tuilesAdjacentes.add(tu);                                                      // On l'ajoute également à la collection
            }
        }

        if (message == Messages.DEPLACER){
            if (coordonnees[0] != 0 && tuiles[coordonnees[0] - 1][coordonnees[1]] != null && !tuiles[coordonnees[0]-1][coordonnees[1]].aSombre()){ // On vérifie que la tuile en haut n'a pas sombré
                tuilesAdjacentes.add(tuiles[coordonnees[0] - 1][coordonnees[1]]);               // On l'ajoute à la collection
            }
            if (coordonnees[0] != 5 && tuiles[coordonnees[0] +1][coordonnees[1]] != null && !tuiles[coordonnees[0]+1][coordonnees[1]].aSombre()){ // On vérifie que la tuile en bas n'a pas sombré
                tuilesAdjacentes.add(tuiles[coordonnees[0] + 1][coordonnees[1]]);               // On l'ajoute à la collection
            }
            if (coordonnees[1] != 5 && tuiles[coordonnees[0]][coordonnees[1] -1] != null && !tuiles[coordonnees[0]][coordonnees[1]+1].aSombre()){ // On vérifie que la tuile à gauche n'a pas sombré
                tuilesAdjacentes.add(tuiles[coordonnees[0]][coordonnees[1] - 1]);               // On l'ajoute à la collection
            }
            if (coordonnees[1] != 5 && tuiles[coordonnees[0]][coordonnees[1] +1] != null && !tuiles[coordonnees[0]][coordonnees[1]+1].aSombre()){ // On vérifie que la tuile à droite n'a pas sombré
                tuilesAdjacentes.add(tuiles[coordonnees[0]][coordonnees[1] + 1]);               // On l'ajoute à la collection
            }

        }

        return tuilesAdjacentes;
    }

    public ArrayList<Tuile> getTuilesDiagonales(Tuile tu, Messages message){
        ArrayList<Tuile> tuilesDiagonales = new ArrayList<>();
        int[] coordonnees = this.getCoordonneesTuile(tu);

        if (message == Messages.ASSECHER){
            if (coordonnees[0] != 0 && tuiles[coordonnees[0] - 1][coordonnees[1]-1] != null && tuiles[coordonnees[0] - 1][coordonnees[1]-1].estInondee()){
                tuilesDiagonales.add(tuiles[coordonnees[0] - 1][coordonnees[1]-1]);
            }

            if (coordonnees[0] != 5 && tuiles[coordonnees[0] + 1][coordonnees[1] +1] != null && tuiles[coordonnees[0] +1][coordonnees[1] +1].estInondee()){
                tuilesDiagonales.add(tuiles[coordonnees[0] +1][coordonnees[1] +1]);
            }

            if (coordonnees[1] != 5 && tuiles[coordonnees[0] -1][coordonnees[1] +1] != null && tuiles[coordonnees[0] -1][coordonnees[1] +1].estInondee()){
                tuilesDiagonales.add(tuiles[coordonnees[0] -1][coordonnees[1] +1]);
            }

            if (coordonnees[1] != 0 && tuiles[coordonnees[0] +1][coordonnees[1] -1] != null && tuiles[coordonnees[0] +1][coordonnees[1] -1].estInondee()){
                tuilesDiagonales.add(tuiles[coordonnees[0] +1][coordonnees[1] -1]);
            }

        }

        if (message == Messages.DEPLACER) {
            if (coordonnees[0] != 0 && tuiles[coordonnees[0] - 1][coordonnees[1] - 1] != null && !tuiles[coordonnees[0] - 1][coordonnees[1] - 1].aSombre()) {
                tuilesDiagonales.add(tuiles[coordonnees[0] - 1][coordonnees[1] - 1]);
            }

            if (coordonnees[0] != 5 && tuiles[coordonnees[0] + 1][coordonnees[1] + 1] != null && !tuiles[coordonnees[0] + 1][coordonnees[1] + 1].aSombre()) {
                tuilesDiagonales.add(tuiles[coordonnees[0] + 1][coordonnees[1] + 1]);
            }

            if (coordonnees[1] != 5 && tuiles[coordonnees[0] - 1][coordonnees[1] + 1] != null && !tuiles[coordonnees[0] - 1][coordonnees[1] + 1].aSombre()) {
                tuilesDiagonales.add(tuiles[coordonnees[0] - 1][coordonnees[1] + 1]);
            }

            if (coordonnees[1] != 0 && tuiles[coordonnees[0] + 1][coordonnees[1] - 1] != null && !tuiles[coordonnees[0] + 1][coordonnees[1] - 1].aSombre()) {
                tuilesDiagonales.add(tuiles[coordonnees[0] + 1][coordonnees[1] - 1]);
            }

        }

        return tuilesDiagonales;
    }

    /* RECUPERER TUILES INONDEES ET JOUABLES */


    public ArrayList getTuilesNonCoulees(Tuile tu){
        ArrayList<Tuile> tuilesNonCoulees = new ArrayList<>();

        for(int i = 0; i < tuiles.length; i++){
            for(int j = 0; i < tuiles.length; j++){
                if (tuiles[i][j].estInondee() || tuiles[i][j].estSeche()){
                    tuilesNonCoulees.add(tuiles[i][j]);
                }
            }
        }

        tuilesNonCoulees.remove(tu);
        return tuilesNonCoulees;

    }



    public Tuile[][] getTuiles() {
        return tuiles;
    }
}
