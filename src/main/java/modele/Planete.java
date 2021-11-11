/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.ArrayList;

/**
 *
 * @author Benoit
 */
public class Planete {
    
    private double force;
    private int nbVaisseaux;
    private Coord maCoo;
    private Joueur joueur;
    private int production;
    private ArrayList<Integer> joueurConnu;
    
    public Planete(Coord maCoo, Joueur monJoueur){
        this.force = (Math.random() * (1.5 - 0.33) + 0.33);
        this.nbVaisseaux = (int)(Math.random()*50);
        this.joueur = monJoueur;
        this.maCoo = maCoo;
        this.production = (int) (Math.random() * (20 - 5) + 6);
        this.joueurConnu = new ArrayList<>();
        joueurConnu.add(monJoueur.getEquipe());
    }
    
    public Joueur getJoueur(){
        return this.joueur;
    }
    
    public Coord getMaCoo(){
        return this.maCoo;
    }
    
    public int getNbvaisseaux(){
        return this.nbVaisseaux;
    }
    
    public double getMaForce(){
        return this.force;
    }
    
    public boolean deplacerVaisseaux(int x){
        if(this.nbVaisseaux < x){
            return false;
        }
        this.nbVaisseaux = this.nbVaisseaux - x;
        return true;
    }
    
    public void production(){
        if( joueur.getEquipe() == 0 ){
            this.nbVaisseaux = this.nbVaisseaux + (this.production/4);
        } else {
            this.nbVaisseaux = this.nbVaisseaux + this.production;
        }
        
    }
    
    public int getEquipe(){
        return this.joueur.getEquipe();
    }
    
    public void setEquipe(int x){
        this.joueur.setEquipe(x);
        boolean trouve = false;
        for(int a : joueurConnu){
            if (x == a) {
                trouve = true;
            }
        }
        if (!trouve) {
            joueurConnu.add(x);
        }
    }
    
    public double getForce(){
        return this.force;
    }
    
    public int getProduction(){
        return this.production;
    }
    
    public void setVaisseaux(int x){
        if (x < 0) {
            this.nbVaisseaux = 0;
        }else{
            this.nbVaisseaux = x;
        }
        
    }
     
    public boolean isPlaneteConnu(Joueur j){
        boolean trouve = false;
        for(int c : joueurConnu){
            if (c == j.getEquipe()) {
                return true;
            }
        }
        return false;
    }
    
}
