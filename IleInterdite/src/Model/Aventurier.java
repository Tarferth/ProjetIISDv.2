package Model;

import java.util.ArrayList;

import Controller.Message;
import Utils.Utils.Pion;

public abstract class Aventurier {

    private int nbActionsMax = 3;
    private Tuile pos;
    private Tuile posPrecedente;
    private Tuile tuile;
    private Pion pion;
    private String pseudo;
    private RôleAventurier typeA;

    public Aventurier(String pseudo, Tuile tuile){
        this.pseudo = pseudo;
        setPos(tuile);
    }


    /* GETTERS */

    public int getNbActionsMax() {
        return nbActionsMax;
    }

    public Pion getPion() {
        return pion;
    }

    public Tuile getPos() {
        return pos;
    }

    public Tuile getPosPrecedente() {
        return posPrecedente;
    }

    /* SETTERS */

    public void setNbActionsMax(int nbActions) {
        this.nbActionsMax = nbActions;
    }

    public void setPion(Pion pion) {
        this.pion = pion;
    }

    public void setPos(Tuile t) {
        posPrecedente = getPos();
        pos = t;
    }


    /* POUR TOUTES LES SOUS-CLASSES */


    public ArrayList getTuilesAccessibles(Grille grille){
        return grille.getTuilesAdjacentes(getPos(), Message.DEPLACER);
    }

    public ArrayList getTuilesAssechables(Grille grille){
        return grille.getTuilesAdjacentes(getPos(), Message.ASSECHER);
    }


}


