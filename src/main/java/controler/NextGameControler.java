/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modele.Plateau;
import vue.GameFrame;

/**
 *
 * @author Olivier
 */
public class NextGameControler implements ActionListener {
    
    private Plateau game;
    private GameFrame fenetre;

    public NextGameControler(Plateau game, GameFrame aThis) {
        this.game = game;
        this.fenetre = aThis;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (fenetre.getJoueurCourant() == fenetre.getNbJoueur()) {
            game.NextTour();
            fenetre.actualiseCarte();
            fenetre.setJoueurCourant(1);
            fenetre.acutaliserJoueur();
        }else{
            fenetre.setJoueurCourant(fenetre.getJoueurCourant()+1);
            fenetre.acutaliserJoueur();
        }
    }
    
}
