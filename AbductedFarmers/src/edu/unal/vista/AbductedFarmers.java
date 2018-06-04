package edu.unal.vista;

import edu.unal.modelo.Map;
import edu.unal.modelo.Player;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author Marlon Andres Barreto Tejada
 * @author Vanesa Palacios
 * @author Valentina Viafara
 */
public class AbductedFarmers {

    private boolean left, right, up, down;
    private Map map;
    private Player player;
    private JFrame UI;

    public AbductedFarmers() {
        startGame();
    }

    private void startGame() {
        JFrame UI = new JFrame("Abducted Farmers");

        map = new Map();

        JLabel puntajeLabel = new JLabel("Puntaje :");
        Font puntajeFont = new Font("Courier", 0, 25);
        puntajeLabel.setForeground(Color.BLACK);
        puntajeLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        puntajeLabel.setFont(puntajeFont);
        UI.add(puntajeLabel, BorderLayout.SOUTH);

        UI.add(map, BorderLayout.CENTER);
        UI.setVisible(true);
        UI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        UI.setSize(800, 630);
        UI.setResizable(false);
        
        gameLoop();
    }

    public static Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }

    public void gameLoop() {

    }

    public static void main(String[] args) {
        new AbductedFarmers();
    }

}
