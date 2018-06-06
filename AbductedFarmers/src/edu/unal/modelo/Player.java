package edu.unal.modelo;

/**
 * @author Marlon Andres Barreto Tejada
 * @author Vanesa Palacios
 * @author Valentina Viafara
 */
public class Player extends Character{

    private boolean power;
    private int score,lives;

    public Player(int posX, int posY, int size, String imageName) {
        super(posX, posY, size, imageName);
        this.power = false;
        this.score = 0;
        this.lives = 1;
    }

    public void countScore() {
    }

    public void attack() {
    }

    public void setScore(int score){
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    @Override
    public boolean move(String dir) {
        cogerMaiz();
        return super.move(dir);
    }
    
    @Override
    protected void cogerMaiz() {
        int x = getTilePosX(),y = getTilePosY();
        if(Map.maize[y][x] == true){
            Map.maize[y][x] = false;
            int tempScore = this.getScore();
            this.setScore(tempScore+50);
        }
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }
    
}
