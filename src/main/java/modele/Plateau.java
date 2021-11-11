/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import exception.CreationDeCoinvoieImpossible;
import java.util.ArrayList;

/**
 *
 * @author Benoit
 */
public class Plateau {
    
    private ArrayList<Convoie> mesConvoies;
    private ArrayList<Planete> mesPlanetes;
    private int longueur;
    private int largeur;
    
    public Plateau(int x, int y, int nbJoueur){
        this.longueur = x;
        this.largeur = y;
        this.mesPlanetes = new ArrayList<>();
        this.mesConvoies = new ArrayList<>();
        
        int taille = x * y;
        taille = ((taille / 35) + 1) * 6;
        
        for(int i = 1 ; i <= nbJoueur ; i++){
            boolean res = false;
            while(res == false){
                char mot = (char)('A' + ((int)(Math.random() * (longueur+1))));
                int nb = (int)(Math.random() * (largeur+1));
                res = newPlanete(new Planete(new Coord(mot + "" + nb), new Joueur(i)));
            }
        }
        System.err.println("LARGEUR ===" + largeur);
        
        
        for(int i = 0 ; i < taille ; i++){
            boolean res = false;
            while(res == false){
                char mot = (char)('A' + ((int)(Math.random() * (longueur+1))));
                int nb = (int)(Math.random() * (largeur+1));
                res = newPlanete(new Planete(new Coord(mot + "" + nb), new Joueur(0)));
            }
        }
    }
    
    public ArrayList<Coord> getAllCoo(){
        ArrayList<Coord> maListe = new ArrayList<>();
        for(Planete maPlanete : mesPlanetes){
            maListe.add(maPlanete.getMaCoo());
        }
        return maListe;
    }
    
    public boolean newPlanete(Planete planete){
        if(planete.getMaCoo().getX() < 0 || planete.getMaCoo().getX() > longueur){
            return false;
        }
        if(planete.getMaCoo().getY() < 0 || planete.getMaCoo().getY() > largeur){
            return false;
        }
        for(Coord maCoo : getAllCoo()){
            if(maCoo.getXY().equals(planete.getMaCoo().getXY())){
                return false;
            }         
        }
        mesPlanetes.add(planete);
        return true;
    }
    
    public ArrayList<Planete> getAllPlanete(){
        return mesPlanetes;
    }
    
    public boolean isPlanete(Coord maCoo){
        for(Coord maCoo2 : getAllCoo()){
            if(maCoo2.getXY().equals(maCoo.getXY())){
                return true;
            }         
        }
        return false;
    }
    
    public void NextTour(){
        for(Planete maPlanete : mesPlanetes){
            maPlanete.production();
        }
        ArrayList<Convoie> convAsuppr = new ArrayList<>();
        for(Convoie convoie : mesConvoies){
            int res = convoie.nextTurn();
            if (res != 0) {
                convAsuppr.add(convoie);
            }
        }
        for(Convoie convoie : convAsuppr){
            mesConvoies.remove(convoie);
        }
        
    }
    
    public Planete getPlaneteAt(Coord maCoo){
        for(Planete maPlanete : mesPlanetes){
            if(maPlanete.getMaCoo().getXY().equals(maCoo.getXY())){
                return maPlanete;
            }
        }
        return null;
    }
    
    public void newConvoie(Coord dep, Coord ar, int nbV, Joueur jou) throws CreationDeCoinvoieImpossible{
        mesConvoies.add(new Convoie(dep, ar, nbV, jou, this));
    }
    
    public boolean gagner(){
        for(Planete maPlanete : mesPlanetes){
            for(Planete maPlanete2 : mesPlanetes){
                if (maPlanete.getEquipe() != maPlanete2.getEquipe()) {
                    return false;
                }
            
        }
        }
        return true;
    }
    
}

