/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controler.AttackControler;
import controler.PlaneteControler;
import controler.PlaneteControler;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import modele.Coord;
import modele.Plateau;
import vue.ButtonCase;
import controler.NextGameControler;
import exception.CreationDeCoinvoieImpossible;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import modele.Joueur;

/**
 *
 * @author Olivier
 */
public class GameFrame extends JFrame{
    
    private Plateau game;
    private int joueurCourant;
    private int nbJoueur;
    private int selectionAttack;
    
    private Coord dep;
    private Coord arr;
    
    private JLabel joueur;
    private JButton next;
    private JButton attack;
    private JTextField nbV;
    private ArrayList<ButtonCase> mesCases;
    
    public GameFrame(int x , int y , int c){
        super();
        game = new Plateau(x, y, c);
        joueurCourant = 1;
        nbJoueur = c;
        mesCases = new ArrayList<>();
        
        JPanel principal = new JPanel(new BorderLayout());
        
        JPanel milieu = new JPanel(new GridLayout(y+1, x+1));
        
        for(int i = 0 ; i <= y;i++){
            for(int v = 0 ; v <= x;v++){
                char mot = (char) ('A' + v);
                ButtonCase bc = new ButtonCase(mot + "" + i);
                Coord maCoo = new Coord(mot + "" + i);
                if (game.isPlanete(maCoo)) {
                    bc.setText(game.getPlaneteAt(maCoo).getEquipe() + "");
                    mesCases.add(bc);
                }else{
                    bc.setEnabled(false);
                }
                bc.addActionListener(new PlaneteControler(game,this));
                milieu.add(bc);
                
                
            } 
        }
        
        JPanel bas = new JPanel(new GridLayout(1, 2));
        
        joueur = new JLabel("joueur : " + joueurCourant);
        next = new JButton("next");
        attack = new JButton("attack");
        nbV = new JTextField();
        
        next.addActionListener(new NextGameControler(game,this));
        
        attack.addActionListener(new AttackControler(game,this));
        
        bas.add(joueur);
        bas.add(next);
        bas.add(attack);
        bas.add(nbV);
        
        principal.add(milieu,BorderLayout.CENTER);
        principal.add(bas,BorderLayout.SOUTH);
        
        this.add(principal);
        
        this.setSize(500,500);
        
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        this.setVisible(true);
    }
    
    public int getJoueurCourant(){
        return this.joueurCourant;
    }
    
    public void setJoueurCourant(int x){
        this.joueurCourant = x;
    }
    
    public int getNbJoueur(){
        return this.nbJoueur;
    }
    
    public void acutaliserJoueur(){
        joueur.setText("joueur : " + joueurCourant);
    }

    public void actualiseCarte() {
        for(ButtonCase bt : mesCases){
            if (bt.isEnabled()) {
                if (!bt.getText().equals(game.getPlaneteAt(bt.getCoo()).getEquipe() + "") ) {
                System.err.println("Planete : " + bt.getCoo().getXY() + " Capturée par : " + game.getPlaneteAt(bt.getCoo()).getEquipe() + "");
                }
            bt.setText(game.getPlaneteAt(bt.getCoo()).getEquipe() + "");
            }
            
        }
    }
    
    public int getAttack(){
        return this.selectionAttack;
    }
    
    public void setSelecAttack(int x){
        this.selectionAttack = x;
    }
    
    public void setDep(Coord co){
        this.dep = co;
    }
    
    public void setArr(Coord co){
        this.arr = co;
    }
    
    public void lancerConvoie(){
        try {
            game.newConvoie(dep, arr, Integer.parseInt(nbV.getText()), new Joueur(joueurCourant));
        } catch (CreationDeCoinvoieImpossible ex) {
            Logger.getLogger(GameFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
