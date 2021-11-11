/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import exception.CreationDeCoinvoieImpossible;

/**
 *
 * @author Benoit
 */
public class Convoie {
    
    private int temps;
    private double puissance;
    private int nbVaisseaux;
    private Coord arrive;
    private Joueur joueur;
    private Plateau plateau;
    
    public Convoie(Coord depart, Coord arrive, int nbVaisseaux, Joueur joueur, Plateau plateau) throws CreationDeCoinvoieImpossible{
        if( plateau.isPlanete(depart) == false || plateau.isPlanete(arrive) == false ){
            throw new CreationDeCoinvoieImpossible();
        }
        if(plateau.getPlaneteAt(depart).getEquipe() != joueur.getEquipe()){
            throw new CreationDeCoinvoieImpossible();
        }
        if(plateau.getPlaneteAt(depart).deplacerVaisseaux(nbVaisseaux) == false){
            throw new CreationDeCoinvoieImpossible();
        }
        this.nbVaisseaux = nbVaisseaux;
        this.puissance = plateau.getPlaneteAt(depart).getForce()*nbVaisseaux;
        this.joueur = joueur;
        this.arrive = arrive;
        int a = depart.getX() - arrive.getX();
        if(a < 0){
            a = -a;
        }
        int b = depart.getY() - arrive.getY();
        if(b < 0){
            b = -b;
        }
        this.temps = (int) Math.sqrt((a*a)+(b*b));
        this.plateau = plateau;
                
    }
    
    public int nextTurn(){
        this.temps--;
        if( this.temps <= 0 ){
            if(joueur.getEquipe() == plateau.getPlaneteAt(arrive).getEquipe()){
                int vaisseaux = plateau.getPlaneteAt(arrive).getNbvaisseaux();
                plateau.getPlaneteAt(arrive).setVaisseaux(vaisseaux+nbVaisseaux);
                //troupes recues;
                System.out.println("troupes recues");
                return 1;
            } else {
                double force = plateau.getPlaneteAt(arrive).getMaForce();
                int vaisseaux = plateau.getPlaneteAt(arrive).getNbvaisseaux();
                int vaisseauxArrive = (int) (puissance / force);
                if(vaisseauxArrive > vaisseaux){
                    plateau.getPlaneteAt(arrive).setVaisseaux(vaisseauxArrive - vaisseaux);
                    plateau.getPlaneteAt(arrive).setEquipe(joueur.getEquipe());
                    //capture effectuée
                    System.out.println("capture effectuée");
                    return 2;
                } else {
                    plateau.getPlaneteAt(arrive).setVaisseaux(vaisseaux - vaisseauxArrive);
                    //capture ratée
                    System.out.println("capture ratée");
                    return 3;
                }       
            }
        } else {
            return 0;
        }
    }
    
}
