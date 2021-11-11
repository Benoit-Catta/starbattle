/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controler.NextControler;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author Benoit
 */
public class EntrerGame extends JFrame{
    
    //1ere fenetre
    private JLabel dimensionTxt;
    private JTextField x;
    private JTextField y;
    private JLabel nbJoueurTxt;
    private JTextField nbJoueurs;
    private JButton next;

    public EntrerGame(){
        
        super("fenetre1");

    
        this.setSize(300,300);
        
        JPanel principal = new JPanel(new GridLayout(6,1));
        
        dimensionTxt = new JLabel("Dimension : ");
        x = new JTextField();
        y = new JTextField();
        nbJoueurTxt = new JLabel("nb joueur  : ");
        nbJoueurs = new JTextField();
        next = new JButton("next");
        
        next.addActionListener(new NextControler(this));
                
        principal.add(dimensionTxt);
        principal.add(x);
        principal.add(y);
        principal.add(nbJoueurTxt);
        principal.add(nbJoueurs);
        principal.add(next);
        
        this.setContentPane(principal);

        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        this.setVisible(true);
  }
    
    public int getX2(){
        return Integer.parseInt(x.getText());
    }
    
    public int getY2(){
        return Integer.parseInt(y.getText());
    }
    
    public int getNbJoueur(){
        return Integer.parseInt(nbJoueurs.getText());
    }
}