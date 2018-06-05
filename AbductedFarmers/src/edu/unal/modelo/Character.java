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

    private int posX, posY, size;
    private int speed;
    private Image skin;

    public Character(int posX, int posY, int size, String imageName) {
        this.posX = posX;
        this.posY = posY;
        this.size = size;
        this.skin = loadImage("res/" + imageName);
    }

    public boolean move(String dir) {
        int tempX = (posX - Map.getxRoot()) / Map.getTileSize(),
                tempY = (posY - Map.getyRoot()) / Map.getTileSize();
        if (dir.equals("left") && tempX - 1 >= 0 && !Map.isBlock(tempX - 1, tempY)) {
            posX -= Map.getTileSize();
            return true;
        }
        if (dir.equals("right") && tempX + 1 < 36 && !Map.isBlock(tempX + 1, tempY)) {
            posX += Map.getTileSize();
            return true;
        }
        if (dir.equals("down") && tempY + 1 < 25 && !Map.isBlock(tempX, tempY + 1)) {
            posY += Map.getTileSize();
            return true;
        }
        if (dir.equals("up") && tempY - 1 >= 0 && !Map.isBlock(tempX, tempY - 1)) {
            posY -= Map.getTileSize();
            return true;
        }
        return false;
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

    public boolean moveValidation() {
        return false;
    }
    
    public void getImageDimensions() {
        width = skin.getWidth(null);
        height = skin.getHeight(null);
    }
    
     public Rectangle getBounds() {
         return new Rectangle(posX, posY, width, height);
     }
}
