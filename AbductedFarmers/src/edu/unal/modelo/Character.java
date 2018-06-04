package edu.unal.modelo;

import static edu.unal.vista.AbductedFarmers.loadImage;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

/**
 * @author Marlon Andres Barreto Tejada
 * @author Vanesa Palacios
 * @author Valentina Viafara
 */
public abstract class Character {
    private float posX,posY,size;
    private int speed;
    private Image skin;

    public Character(float posX, float posY, float size,String imageName) {
        this.posX = posX;
        this.posY = posY;
        this.size = size;
        this.skin = loadImage("res/" + imageName);
    }
    
    public void move(){
        
    }
    
    public void paint(Graphics2D g) {
       
    }
    
}
