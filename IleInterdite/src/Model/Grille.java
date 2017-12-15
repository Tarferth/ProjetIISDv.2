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
        for (int j = 0; j < 6; j++){
            for (int i = 0; i < 6; i++){
                if ((i == 0 && j == 0) || (i == 1 && j == 0)) || (i == 0 && j == 1) ||                                  // Coin haut gauche
                        (i == 0 && j == 4) || (i == 0 && j == 5) || (i == 1 & j == 5) ||                                // Coin haut droit
                        (i == 4 && j == 0) || (i == 5 && j == 0) || (i == 5 & j == 1) ||                                // Coin bas gauche
                        (i == 4 && j == 5) || (i == 5 && j == 5) || (i == 5 && j = 4)){                                 //Coin bas droit

                    this.tuiles = null;

                }

            }
        }
    }

    
    
    
    
    
    
    
    
    public Tuile getTuile(int x, int y){
        return tuiles[x][y];
    }
}
