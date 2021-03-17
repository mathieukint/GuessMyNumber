/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guess;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;

/**
 *
 * @author mathi
 */
@Named(value = "aleaBean")
@SessionScoped

public class AleaBean implements Serializable {
    
    private String phrase;
    private int riddle;
    private int user;
    private int Nmin;
    private int Nmax;
    private final int p=50;
    private int Ntrys;

    /**
     * Constructeurs
     */
    public AleaBean() {

        InitValues();
        InitPhrase();
    }
    
    @PostConstruct
    public void InitValues() {
        this.Nmin = (int) (Math.random() * p) ;
        this.Nmax = Nmin+1 + ((int) (Math.random() * p));
        this.Ntrys = (int) (Math.random() * 8);
        this.riddle = (int) ( (Math.random() * (Nmax-Nmin)) + Nmin);
    }
    public void InitPhrase() {
        this.phrase  = "Je pense à un nombre entre " + Nmin + " et " + Nmax + "."
                        + "<br>Vous avez " + Ntrys + " essais pour le trouver !";
    }
    
    /*
    public Restart() {
        
    }
    */
    
    public String compare(){
        
        Ntrys = Ntrys-1;
        
        if(Ntrys>0){
            if(riddle==user){
                this.phrase = "Oh pinaise ! C'est gagné !";
            } else if(riddle<user){
                this.phrase = "Héhé ! C'est plus petit !<br> "
                        + "Il reste " + Ntrys + " essais.";
            } else if(riddle>user) {
                this.phrase = "C'est plus grand ! Nanana !<br>"
                        + "Il reste " + Ntrys + " essais.";
            }
        } else if(Ntrys==0) {
            this.phrase = "Haha ! J'ai gagné ! <br> La réponse était " + riddle + ".";
        } else if(Ntrys<0) {
            this.phrase = "Pas la peine d'insister. J'ai gagné.";
        }
        return phrase;
    }
    
    
    /**
     * Setters et Getters
     * @return 
     */
    public int getNmin() {
        return Nmin;
    }
    
    public int getNmax() {
        return Nmax;
    }
    
    public int getRiddle() {
        return riddle;
    }
    
    public int getNtrys() {
        return Ntrys;
    }
    public void setNtrys(int Ntrys) {
        this.Ntrys = Ntrys;
    }
    
    public String getPhrase() {
        return phrase;
    }
    public void setPhrase(String phrase){
        this.phrase = phrase;
    }
    
    public int getUser() {
        return user;
    }
    public void setUser(int user) {
        this.user = user;
    }
    
}
