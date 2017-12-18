package Model;

import Utils.Utils.Pion;

import java.util.ArrayList;

public class Pilote extends Aventurier {

    public Pilote(String pseudo, Tuile tuile){
        super(pseudo, tuile);
        setPion(Pion.BLEU);
    }

    @Override
    public ArrayList getTuilesAccessibles(Grille grille){
        return grille.getTuilesNonCoulees(getPos());
    }
}
