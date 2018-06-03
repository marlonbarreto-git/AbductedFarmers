package edu.unal.vista;

import edu.unal.modelo.Map;
import edu.unal.modelo.Player;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author Marlon Andres Barreto Tejada
 * @author Vanesa Palacios
 * @author Valentina Viafara
 */
public class AbductedFarmers implements KeyListener {

    private Image sprite;
    private boolean left;
    private boolean right;
    private boolean up;
    private boolean down;
    private Map map;
    private Player player;
    private JFrame UI;

    public AbductedFarmers() {
        startGame();
    }

    private void startGame() {
        map = new Map();
        JLabel puntaje = new JLabel("Puntaje : ");
        
        JFrame UI = new JFrame("Abducted Farmers");
        UI.setVisible(true);
        UI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        UI.setSize(800, 600);
        UI.setResizable(false);
        UI.setBackground(Color.BLACK);
        UI.add(map,BorderLayout.CENTER);
        UI.add(puntaje,BorderLayout.SOUTH);
    }

    public static Image loadImage(String imageName) {
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
