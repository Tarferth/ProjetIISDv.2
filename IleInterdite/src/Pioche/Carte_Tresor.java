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
public class Carte_Tresor{
    
    private ArrayList<Carte> pioche ;
    private ArrayList<Carte> defausse;
    
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

    public Carte_Tresor() {
        this.pioche = new ArrayList();
        this.defausse = new ArrayList();
    }
    
    public void initPioche(){
        pioche.add(cristal1);
        pioche.add(cristal2);
        pioche.add(cristal3);
        pioche.add(cristal4);
        pioche.add(cristal5);

        pioche.add(statue1);
        pioche.add(statue2);
        pioche.add(statue3);
        pioche.add(statue4);
        pioche.add(statue5);

        pioche.add(pierre1);
        pioche.add(pierre2);
        pioche.add(pierre3);
        pioche.add(pierre4);
        pioche.add(pierre5);

        pioche.add(calice1);
        pioche.add(calice2);
        pioche.add(calice3);
        pioche.add(calice4);
        pioche.add(calice5);

        pioche.add(eaux1);
        pioche.add(eaux2);

        pioche.add(Sac1);
        pioche.add(Sac2); 
    }

    public ArrayList<Carte> getPioche() {
        return pioche;
    }

    public ArrayList<Carte> getDefausse() {
        return defausse;
    }
    
    
    
    public Carte piocheCarte(){
        Carte carte;
        carte = this.getPioche().get(0);
        this.getPioche().remove(0);
        if(this.getPioche().size() == 0){
            this.remiseDefausse();
        }
        return carte;
    }
    
    public void defausseCarte(Carte carte){
        this.getDefausse().add(carte);
    }
    
    public void remiseDefausse(){
        Collections.shuffle(this.getDefausse());
        for(Carte c : this.getDefausse()){
            this.getPioche().add(c);
        }
        
        this.defausse = new ArrayList();
    }

    
    
    
}
