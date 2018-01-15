package Aventurier;

import Aventurier.Aventurier;
import Grille.Grille;
import Grille.Tuile;
import static Controller.Message.DEPLACER;
import static Utils.Utils.EtatTuile.*;
import Utils.Utils.Pion;
import java.util.ArrayList;


public class Plongeur extends Aventurier {

    public Plongeur(String pseudo, Tuile tuile){
        super(pseudo, tuile);
        setPion(Pion.ORANGE);
    }
    
    @Override
    public ArrayList getTuilesAccessibles(Grille grille){
        
        Tuile tuileL;
        ArrayList<Tuile> tuilesPossibles = super.getTuilesAccessibles(grille);
        
        ArrayList<Tuile> tuilesTrav = new ArrayList();
        tuilesTrav.add(getPos());
        
        for (int i = 0; i < tuilesTrav.size(); i++) {
            tuileL = tuilesTrav.get(i);
            
            for (Tuile tuile : grille.getTuilesAdjacentes(tuileL)) {
                
                if (tuile.getEtat()!= COULEE && !tuilesPossibles.contains(tuile))
                    tuilesPossibles.add(tuile);
                
                if (tuile.getEtat()!= ASSECHEE && !tuilesTrav.contains(tuile))
                    tuilesTrav.add(tuile);
            }
        }
        
        tuilesPossibles.remove(getPos());
        return tuilesPossibles;
    
    }
}
