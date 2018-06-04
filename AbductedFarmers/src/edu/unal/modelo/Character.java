package edu.unal.modelo;

import static edu.unal.vista.AbductedFarmers.loadImage;
import java.awt.Graphics2D;
import java.awt.Image;

/**
 * @author Marlon Andres Barreto Tejada
 * @author Vanesa Palacios
 * @author Valentina Viafara
 */
public abstract class Character {
    private int posX,posY,size;
    private int speed;
    private Image skin;

    public Character(int posX, int posY, int size,String imageName) {
        this.posX = posX;
        this.posY = posY;
        this.size = size;
        this.skin = loadImage("res/" + imageName);
    }
    
    public void move(){
        
    }
    
    public void paint(Graphics2D g) {
        g.drawImage(skin, posX, posY, null);
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    
    
}
