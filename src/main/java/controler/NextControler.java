/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import vue.GameFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vue.EntrerGame;

/**
 *
 * @author Olivier
 */
public class NextControler implements ActionListener {
    
    private EntrerGame fenetre; 

    public NextControler(EntrerGame aThis) {
        fenetre = aThis;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        GameFrame gamePanel = new GameFrame(fenetre.getX2(), fenetre.getY2(), fenetre.getNbJoueur());
        System.err.println("X : " + fenetre.getX2() + " Y :" +fenetre.getY2());
        fenetre.dispose();
        
        
    }
    
}
