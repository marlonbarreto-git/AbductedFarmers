package edu.unal.modelo;

import edu.unal.vista.AbductedFarmers;
import static edu.unal.vista.AbductedFarmers.loadImage;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Marlon Andres Barreto Tejada
 * @author Vanesa Palacios
 * @author Valentina Viafara
 */
public class Map extends JPanel {

    private int[][] mapa;

    public Map() {

    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.drawImage(loadImage("res/pasto.jpg"), 50, 25, this);
        
    }

    public ArrayList<ArrayList<Integer>> cargar(String ruta) {
        return null;
    }


}
