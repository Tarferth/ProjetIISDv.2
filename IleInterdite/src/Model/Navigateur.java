package Model;

import Utils.Utils.Pion;

public class Navigateur extends Aventurier {

    public Navigateur(String pseudo, Tuile tuile){
        super(pseudo, tuile);
        setPion(Pion.JAUNE);
    }
}
