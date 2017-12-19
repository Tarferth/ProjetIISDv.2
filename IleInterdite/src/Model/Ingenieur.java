package Model;

import Utils.Utils.Pion;
import java.util.ArrayList;

public class Ingenieur extends Aventurier {

    public Ingenieur(String pseudo, Tuile tuile){
        super(pseudo, tuile);
        setPion(Pion.ROUGE);
    }

}

