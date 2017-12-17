package Model;

import Utils.Utils.Pion;

public class Ingenieur extends Aventurier {

    public Ingenieur(String pseudo, Tuile tuile){
        super(pseudo, tuile);
        setPion(Pion.ROUGE);
    }
}
