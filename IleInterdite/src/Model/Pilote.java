package Model;

import Utils.Utils.Pion;

public class Pilote extends Aventurier {

    public Pilote(String pseudo, Tuile tuile){
        super(pseudo, tuile);
        setPion(Pion.BLEU);
    }
}
