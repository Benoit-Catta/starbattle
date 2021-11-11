/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import javax.swing.JButton;
import modele.Coord;

/**
 *
 * @author Benoit
 */
public class ButtonCase extends JButton{
    
    private Coord coo;
    
    public ButtonCase(String xy){
        this.coo = new Coord(xy);
    }
    
    public Coord getCoo(){
        return this.coo;
    }
}
