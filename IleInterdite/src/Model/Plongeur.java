package Model;

import static Controller.Message.DEPLACER;
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
                
                if (!tuile.aSombre() && !tuilesPossibles.contains(tuile))
                    tuilesPossibles.add(tuile);
                
                if (!tuile.estSeche() && !tuilesTrav.contains(tuile))
                    tuilesTrav.add(tuile);
            }
        }
        
        tuilesPossibles.remove(getPos());
        return tuilesPossibles;
    
    }
}
