package Vues;

import Grille.NomTuile;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public abstract class Vue extends Observable {


    public Vue(){}
    public void abonner(Observer observateur){ this.addObserver(observateur);}
    public abstract void setVisible(Boolean b);

    public void setTuilesDispo(ArrayList<String> tu){};
    public NomTuile getTuileSelectionnee(){return null;}

    public void setTuilesAss(ArrayList<String> tu){};
}
