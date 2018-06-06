package edu.unal.vista;

import edu.unal.modelo.Map;
import static edu.unal.modelo.Map.timer;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 * @author Marlon Andres Barreto Tejada
 * @author Vanesa Palacios
 * @author Valentina Viafara
 */
public class AbductedFarmers {

    private Map map;
    private JFrame UI;

    public AbductedFarmers() {
        try {
            UI = new JFrame("Abducted Farmers");
            map = new Map();
        } catch (IOException ex) {
            Logger.getLogger(AbductedFarmers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void startGame() {
        map.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int x = map.getPlayer().getPosX(),
                        y = map.getPlayer().getPosY();
                if (e.getKeyCode() == KeyEvent.VK_S) {

                    JFrame puntajes = new JFrame("Scores");

                    JPanel puntos = new JPanel();
                    puntos.setLayout(new GridLayout(10, 1));
                    puntos.setBackground(Color.BLACK);
                    Scanner scan;
                    try {
                        scan = new Scanner(new FileInputStream("res/Scores.txt"));
                        String temp;
                        while (scan.hasNext()) {
                            temp = scan.nextLine();
                            JLabel label = new JLabel();
                            label.setText(temp);
                            label.setForeground(Color.WHITE);
                            label.setFont(new Font("Courier", 0, 20));
                            puntos.add(label);
                        }
                        scan.close();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(AbductedFarmers.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    puntajes.add(puntos, BorderLayout.CENTER);
                    puntajes.setSize(300, 500);
                    puntajes.setVisible(true);
                    puntajes.setResizable(true);

                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    if (timer.isRunning()) {
                        timer.stop();
                    } else {
                        timer.start();
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    map.getPlayer().move("left");
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    map.getPlayer().move("right");
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    map.getPlayer().move("down");
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    map.getPlayer().move("up");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        UI.add(map, BorderLayout.CENTER);
        UI.setVisible(true);
        UI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        UI.setSize(800, 600);
        UI.setResizable(false);
    }

    public static Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }
}
