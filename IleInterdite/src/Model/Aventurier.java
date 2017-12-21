package Model;

import java.util.ArrayList;

import Controller.Message;
import Utils.Utils.Pion;

public abstract class Aventurier {

    private int nbActions = 0;
    private Tuile pos;
    private Tuile posPrecedente;
    private Tuile tuile;
    private Pion pion;
    private String pseudo;
    private RôleAventurier typeA;

    public Aventurier(String pseudo, Tuile tuile){
        this.pseudo = pseudo;
        this.tuile = tuile;
    }


    /* GETTERS */

    public int getNbActions() {
        return nbActions;
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

    public void setNbActions(int nbActions) {
        this.nbActions = nbActions;
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


