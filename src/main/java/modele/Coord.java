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
public class Coord {
    
    private char x;
    private int y;
    
    public Coord(String xy){
        this.x = xy.charAt(0);
        this.y = Integer.parseInt(xy.substring(1));
    }
    
    public char getAlphaX(){
        return this.x;
    }
    
    public int getX(){
        return (this.x - 'A');
    }
    
    public  int getY(){
        return this.y;
    }
    
    public String getXY(){
        return (this.x + "" + this.y);
    }
}
