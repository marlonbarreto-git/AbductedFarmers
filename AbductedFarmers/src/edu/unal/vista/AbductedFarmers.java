package edu.unal.vista;

import edu.unal.modelo.Map;
import edu.unal.modelo.Player;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import javax.swing.ImageIcon;

/**
 * @author Marlon Andres Barreto Tejada
 * @author Vanesa Palacios
 * @author Valentina Viafara
 */
public class AbductedFarmers implements KeyListener {

    private Image sprite;
    /**
     * The buffered strategy used for accelerated rendering
     */
    private BufferStrategy strategy;

    /**
     * True if the left key is currently pressed
     */
    private boolean left;
    /**
     * True if the right key is currently pressed
     */
    private boolean right;
    /**
     * True if the up key is currently pressed
     */
    private boolean up;
    /**
     * True if the down key is currently pressed
     */
    private boolean down;

    /**
     * The map our player will wander round
     */
    private Map map;
    /**
     * The player entity that will be controlled with cursors
     */
    private Player player;

    public AbductedFarmers() {
        startGame();
    }

    private void startGame() {
        Frame UI = new Frame("Abducted Farmers");
        UI.add(new Map());
        UI.setSize(800, 600);
        UI.setResizable(false);
        UI.setLocationRelativeTo(null);
        UI.setLayout(null);
        UI.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        UI.setVisible(true);
        gameLoop();
    }

    protected Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }

    public void gameLoop() {
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    
    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            left = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            right = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            down = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            up = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.println("Algo");
            left = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            right = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            down = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            up = false;
        }
    }

    public static void main(String[] args) {
        new AbductedFarmers();
    }
    
}
