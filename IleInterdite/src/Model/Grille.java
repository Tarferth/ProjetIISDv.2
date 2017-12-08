/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author barrerat
 */
public class Grille {
    Tuile[][] tuiles;
    
    public Grille() {
        tuiles = new Tuile[6][6];
    }
    
    
    
    
    
    
    
    public Tuile getTuile(int x, int y){
        return tuiles[x][y];
    }
}
