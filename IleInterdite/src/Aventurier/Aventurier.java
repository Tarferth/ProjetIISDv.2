package Aventurier;

import java.util.ArrayList;

import Controller.Message;
import Grille.Grille;
import Grille.Tuile;
import Pioche.Carte;
import Utils.Utils.Pion;

public abstract class Aventurier {

    private final static int nbActionsMax = 3;
    private Tuile pos;
    private Tuile posPrecedente;
    private Tuile tuile;
    private Pion pion;
    private String pseudo;
    private RôleAventurier typeA;
    private boolean moveSpé;// si le pilote à utilise son pouvoir
    private ArrayList<Carte> main;

    
    public Aventurier(String pseudo, Tuile tuile){
        this.pseudo = pseudo;
        setPos(tuile);
        moveSpé = false;
        main = new ArrayList();
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

    public ArrayList<Carte> getMain() {
        return main;
    }
    
    

    /* POUR TOUTES LES SOUS-CLASSES */


    public ArrayList getTuilesAccessibles(Grille grille){
        return grille.getTuilesAdjacentes(getPos(), Message.DEPLACER);
    }

    public ArrayList getTuilesAssechables(Grille grille){
        return grille.getTuilesAdjacentes(getPos(), Message.ASSECHER);
    }
    
}


