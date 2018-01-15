/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pioche;

import static Utils.Utils.Cartes.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Nans
 */
public class TreasureCard{
    
    private ArrayList<Carte> pick ;
    private ArrayList<Carte> discarding;
    
    private Carte cristal1= new Carte(CRISTAL);
    private Carte cristal2= new Carte(CRISTAL);
    private Carte cristal3= new Carte(CRISTAL);
    private Carte cristal4= new Carte(CRISTAL);
    private Carte cristal5= new Carte(CRISTAL);

    private Carte statue1= new Carte(STATUE);
    private Carte statue2= new Carte(STATUE);
    private Carte statue3= new Carte(STATUE);
    private Carte statue4= new Carte(STATUE);
    private Carte statue5= new Carte(STATUE);

    private Carte pierre1= new Carte(PIERRE);
    private Carte pierre2= new Carte(PIERRE);
    private Carte pierre3= new Carte(PIERRE);
    private Carte pierre4= new Carte(PIERRE);
    private Carte pierre5= new Carte(PIERRE);

    private Carte calice1= new Carte(CALICE);
    private Carte calice2= new Carte(CALICE);
    private Carte calice3= new Carte(CALICE);
    private Carte calice4= new Carte(CALICE);
    private Carte calice5= new Carte(CALICE);

    private Carte eaux1= new Carte(EAUX);
    private Carte eaux2= new Carte(EAUX);

    private Carte Sac1= new Carte(SABLE);
    private Carte Sac2= new Carte(SABLE);
    
    private Carte Helicoptere1= new Carte(HELICOPTERE);
    private Carte Helicoptere2= new Carte(HELICOPTERE);
    private Carte Helicoptere3= new Carte(HELICOPTERE);

    public TreasureCard() {
        this.pick = new ArrayList();
        this.discarding = new ArrayList();
    }
    
    public void initPioche(){
        pick.add(cristal1);
        pick.add(cristal2);
        pick.add(cristal3);
        pick.add(cristal4);
        pick.add(cristal5);

        pick.add(statue1);
        pick.add(statue2);
        pick.add(statue3);
        pick.add(statue4);
        pick.add(statue5);

        pick.add(pierre1);
        pick.add(pierre2);
        pick.add(pierre3);
        pick.add(pierre4);
        pick.add(pierre5);

        pick.add(calice1);
        pick.add(calice2);
        pick.add(calice3);
        pick.add(calice4);
        pick.add(calice5);

        pick.add(eaux1);
        pick.add(eaux2);

        pick.add(Sac1);
        pick.add(Sac2); 
    }

    public ArrayList<Carte> getPick() {
        return pick;
    }

    public ArrayList<Carte> getDiscarding() {
        return discarding;
    }
    
    
    
    public Carte piocheCarte(){
        Carte carte;
        carte = this.getPick().get(0);
        this.getPick().remove(0);
        return carte;
    }
    
    public void defausseCarte(Carte carte){
        this.getDiscarding().add(carte);
    }
    
    public void remiseDefausse(){
        Collections.shuffle(this.getDiscarding());
        for(Carte c : this.getDiscarding()){
            this.getPick().add(c);
        }
        
        this.discarding = new ArrayList();
    }

    
    
    
}
