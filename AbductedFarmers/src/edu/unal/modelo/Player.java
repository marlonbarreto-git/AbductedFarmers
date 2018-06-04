package edu.unal.modelo;

/**
 * @author Marlon Andres Barreto Tejada
 * @author Vanesa Palacios
 * @author Valentina Viafara
 */
public class Player extends Character{
    private boolean power;
    private int score;

    public Player(boolean power, int score, float posX, float posY, float size, String imageName) {
        super(posX, posY, size, imageName);
        this.power = false;
        this.score = 0;
    }
    
    public void countScore(){ 
    }
    
    public void attack(){
    }
    
}
