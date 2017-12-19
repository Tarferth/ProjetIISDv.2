package Model;

import Utils.Utils.Pion;
import java.util.ArrayList;

public class Ingenieur extends Aventurier {

    public Ingenieur(String pseudo, Tuile tuile){
        super(pseudo, tuile);
        setPion(Pion.ROUGE);
    }


    /*Déplacement*/
    @Override
    public ArrayList<Tuile> getTuilesAccessibles(Grille grille){
        ArrayList<Tuile> tuilesAccessibles = grille.getTuilesAdjacentes(getPos(), Messages.DEPLACER);
        tuilesAccessibles.addAll(grille.getTuilesDiagonales(getPos(), Messages.DEPLACER));
        return tuilesAccessibles;
    }

    @Override
    public ArrayList<Tuile> getTuilesAssechables(Grille grille){
        ArrayList<Tuile> tuilesAssechables = grille.getTuilesAdjacentes(getPos(), Messages.ASSECHER);
        tuilesAssechables.addAll(grille.getTuilesDiagonales(getPos(), Messages.ASSECHER));
        return tuilesAssechables;
    }
}

