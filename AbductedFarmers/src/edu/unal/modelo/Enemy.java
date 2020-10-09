package edu.unal.modelo;

import java.util.Random;

/**
 * @author Marlon Andres Barreto Tejada
 * @author Vanesa Palacios
 * @author Valentina Viafara
 */
public class Enemy extends Character{

    public Enemy(int posX, int posY, int size, String imageName) {
        super(posX, posY, size, imageName);
    }
    
    public void moveRandom(){
        Random r = new Random();
        int dir = r.nextInt(4);
        switch (dir) {
            case 0 -> move("left");
            case 1 -> move("right");
            case 2 -> move("down");
            case 3 -> move("up");
        }
    }
    
}
