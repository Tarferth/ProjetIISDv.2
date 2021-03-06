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
        posPrecedente= null;
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
        pos.addAventurier(this);
        if(posPrecedente != null)posPrecedente.removeAventurier(this);
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
    
    //realise l'échange de carte
    public void echangeCarte(Aventurier a,Carte c){
        this.remove(c);
        a.getMain().add(c);
        
    }
    
    public void afficheMain(){
        System.out.println("Vous avez "+this.getMain().size() + "en main");
        for(Carte c: main){
            System.out.print(main.indexOf(c)+1+" :");
            c.afficheCarte();
        }
    }

    public void remove(Carte c) {
        this.getMain().remove(c);
    }
    
    public void add(Carte c){
        this.getMain().add(c);
    }
        
}


