package Aventurier;

import Aventurier.Aventurier;
import Grille.Tuile;
import Utils.Utils.Pion;

public class Messager extends Aventurier {

    public Messager(String pseudo, Tuile tuile){
        super(pseudo, tuile);
        setPion(Pion.VIOLET);
    }
    
}



