package Aventurier;

import java.util.ArrayList;

import Controller.Message;
import Grille.Grille;
import Grille.Tuile;
import Utils.Utils.Pion;

public abstract class Aventurier {

    private int nbActionsMax = 3;
    private Tuile pos;
    private Tuile posPrecedente;
    private Tuile tuile;
    private Pion pion;
    private String pseudo;
    private RôleAventurier typeA;
    private boolean moveSpé;// si le pilote à utilise son pouvoir

    
    public Aventurier(String pseudo, Tuile tuile){
        this.pseudo = pseudo;
        setPos(tuile);
        moveSpé = false;
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

    public RôleAventurier getTypeA() {
        return typeA;
    }
    
    public boolean getMoveSpé() {
        return moveSpé;
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

    public void setMoveSpé(boolean moveSpé) {
        this.moveSpé = moveSpé;
        System.out.println("move spé =" + moveSpé);
    }

    /* POUR TOUTES LES SOUS-CLASSES */


    public ArrayList getTuilesAccessibles(Grille grille){
        return grille.getTuilesAdjacentes(getPos(), Message.DEPLACER);
    }

    public ArrayList getTuilesAssechables(Grille grille){
        return grille.getTuilesAdjacentes(getPos(), Message.ASSECHER);
    }


}


