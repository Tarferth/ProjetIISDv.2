package Aventurier;

import Aventurier.Aventurier;
import Grille.Tuile;
import Utils.Utils.Pion;

public class Navigateur extends Aventurier {
    
    private final static int nbActionsMax = 4;

    
    public Navigateur(String pseudo, Tuile tuile){
        super(pseudo, tuile);
        setPion(Pion.JAUNE);
    }
}
