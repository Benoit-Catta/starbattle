/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author Benoit
 */
public class Joueur {
    
    private int equipe;
    
    public Joueur(int x){
        this.equipe = x;
    }
    
    public int getEquipe(){
        return this.equipe;
    }
    
    public void setEquipe(int x){
        this.equipe = x;
    }
   
    
}
