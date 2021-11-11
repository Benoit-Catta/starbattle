/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import vue.GameFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modele.Coord;
import modele.Joueur;
import modele.Plateau;
import vue.ButtonCase;

/**
 *
 * @author Benoit
 */
public class PlaneteControler implements ActionListener {
    
    private Plateau game;
    private GameFrame fenetre;

    public PlaneteControler(Plateau game, GameFrame aThis) {
        this.game = game;
        this.fenetre = aThis;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ButtonCase bt = (ButtonCase) e.getSource();
        
        if (fenetre.getAttack() != 0) {
            if (fenetre.getAttack() == 1) {
                fenetre.setDep(bt.getCoo());
                fenetre.setSelecAttack(2);
            }else{
                fenetre.setArr(bt.getCoo());
                fenetre.lancerConvoie();
                fenetre.setSelecAttack(0);
            }
        }else{
            //si la planete apartient au joueur
        if (game.getPlaneteAt(bt.getCoo()).getEquipe() == fenetre.getJoueurCourant()) {
            System.err.println("prod : " + game.getPlaneteAt(bt.getCoo()).getProduction() + " force : " + game.getPlaneteAt(bt.getCoo()).getForce() + " nbVaisseaux : " + game.getPlaneteAt(bt.getCoo()).getNbvaisseaux());
        }else{
            //si la planete est connu du joueur
            if (game.getPlaneteAt(bt.getCoo()).isPlaneteConnu(new Joueur(fenetre.getJoueurCourant()))) {
                System.err.println("prod : " + game.getPlaneteAt(bt.getCoo()).getProduction() + " force : " + game.getPlaneteAt(bt.getCoo()).getForce());
            }else{
                System.err.println("planete inconnu");
            }
        }
        }
        
    }
    
}
