package Model;

import Utils.Utils.Pion;


public class Plongeur extends Aventurier {

    public Plongeur(String pseudo, Tuile tuile){
        super(pseudo, tuile);
        setPion(Pion.ORANGE);
    }
}
