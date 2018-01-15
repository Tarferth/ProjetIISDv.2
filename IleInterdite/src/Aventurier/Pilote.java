package Aventurier;

import Aventurier.Aventurier;
import Grille.Grille;
import Grille.Tuile;
import Utils.Utils.Pion;

import java.util.ArrayList;

public class Pilote extends Aventurier {

    public Pilote(String pseudo, Tuile tuile){
        super(pseudo, tuile);
        setPion(Pion.BLEU);
    }
    
    
    public ArrayList getTuilesAdj(Grille grille){
            return super.getTuilesAccessibles(grille);    
    }
    

    @Override
    public ArrayList getTuilesAccessibles(Grille grille){
        if(this.getMoveSpé() == false ){
            return grille.getTuilesNonCoulees(getPos());
        }else{
            return super.getTuilesAccessibles(grille);
        }
    
    }
        
}
