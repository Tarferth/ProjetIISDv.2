package Model;

public abstract class Aventurier {

    private int nbActions = 0;
    Tuile pos;
    Tuile posPrecedente;



    public int getNbActions() {
        return nbActions;
    }

    public void setNbActions(int nbActions) {
        this.nbActions = nbActions;
    }

    //Gérer la position de l'aventurier

    public Tuile getPos() {
        return pos;
    }

    public Tuile getPosPrecedente() {
        return posPrecedente;
    }

    public void setPos(Tuile t) {
        posPrecedente = getPos();
        pos = t;
    }

    //Gestion des actions

    public void seDeplacer(Tuile t) {
        getPos().removeAventurier(this);
        t.addAventurier(this);
        setPos(t):
        setNbActions(getNbActions(+1));

    }
}
