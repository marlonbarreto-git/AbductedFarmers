package edu.unal.vista;

import edu.unal.modelo.Map;
import static edu.unal.modelo.Map.timer;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
        UI = new JFrame("Abducted Farmers");
        map = new Map();
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
                if(e.getKeyCode() == KeyEvent.VK_SPACE){
                    if(timer.isRunning()){
                        timer.stop();
                    }else
                    timer.start();
                    
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

    public static void main(String[] args) {
        new AbductedFarmers().startGame();
    }

}
