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
public class Grille {

    private Tuile[][] tuiles = new Tuile[6][6];

    public Grille(ArrayList<Tuile> tu){
        /* |0.0|0.1|0.2|0.3|0.4|0.5|
           |1.0|1.1|1.2|1.3|1.4|1.5|
           |2.0|2.1|2.2|2.3|2.4|2.5|
           |3.0|3.1|3.2|3.3|3.4|3.5|
           |4.0|4.1|4.2|4.3|4.4|4.5|
           |5.0|5.1|5.2|5.3|5.4|5.5|
         */
        int x = 0;
        for (int j = 0; j < 6; j++){
            for (int i = 0; i < 6; i++){
                if ((i == 0 && j == 0) || (i == 1 && j == 0) || (i == 0 && j == 1) ||     //si la tuile est dans cette liste                            // Coin haut gauche
                        (i == 0 && j == 4) || (i == 0 && j == 5) || (i == 1 & j == 5) ||                                // Coin haut droit
                        (i == 4 && j == 0) || (i == 5 && j == 0) || (i == 5 & j == 1) ||                                // Coin bas gauche
                        (i == 4 && j == 5) || (i == 5 && j == 5) || (i == 5 && j == 4)){                                 //Coin bas droit

                    this.tuiles[j][i] = null;                                              // Alors elle est vide

                }
                else{
                    this.tuiles[j][i] = tu.get(x);          // Sinon
                    tu.get(x).setCol(i);                    // On l'initialise avec i et j
                    tu.get(x).setLig(j);
                    x++;                                    // Puis on incrémente
                }

            }
        }
    }

    public Tuile[][] getGrille(){
        return tuiles;
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
            if (coordonnees[0] != 0 && !tuiles[coordonnees[0]-1][coordonnees[1]].estInondee()){
                tuilesAdjacentes.add(tuiles[coordonnees[0]-1][coordonnees[1]]);
            }
            if (coordonnees[0] != 5 && !tuiles[coordonnees[0]+1][coordonnees[1]].estInondee()){
                tuilesAdjacentes.add(tuiles[coordonnees[0]+1][coordonnees[1]]);
            }
            if (coordonnees[1] != 0 && !tuiles[coordonnees[0]][coordonnees[1]-1].estInondee()){
                tuilesAdjacentes.add(tuiles[coordonnees[0]][coordonnees[1]-1]);
            }
            if (coordonnees[1] != 5 && !tuiles[coordonnees[0]][coordonnees[1]+1].estInondee()){
                tuilesAdjacentes.add(tuiles[coordonnees[0]][coordonnees[1]+1]);
            }
        }

        if (message == Messages.DEPLACER) {
            if (coordonnees[0] != 0 && tuiles[coordonnees[0] - 1][coordonnees[1]].aSombre()) {
                tuilesAdjacentes.add(tuiles[coordonnees[0] - 1][coordonnees[1]]);
            }
            if (coordonnees[0] != 5 && tuiles[coordonnees[0] + 1][coordonnees[1]].aSombre()) {
                tuilesAdjacentes.add(tuiles[coordonnees[0] + 1][coordonnees[1]]);
            }
            if (coordonnees[1] != 0 && tuiles[coordonnees[0]][coordonnees[1] - 1].aSombre()) {
                tuilesAdjacentes.add(tuiles[coordonnees[0]][coordonnees[1] - 1]);
            }
            if (coordonnees[1] != 5 && tuiles[coordonnees[0]][coordonnees[1] + 1].aSombre()) {
                tuilesAdjacentes.add(tuiles[coordonnees[0]][coordonnees[1] + 1]);
            }
            if (tu.estInondee()) {
                tuilesAdjacentes.add(tu);
            }

        }

        return tuilesAdjacentes;
    }
    
    
    
    
    
    
    public ArrayList<Tuile> getTuiles(){
        ArrayList<Tuile> tu = new ArrayList();
        for (int j = 0; j < 6; j++){
            for (int i = 0; i < 6; i++){
                if (this.tuiles[j][i] != null){
                    tu.add(tuiles[j][i]);
                }
            }
        }

        return tu;
    }

    public Tuile[][] getTuile(){
        return tuiles;
    }
}
