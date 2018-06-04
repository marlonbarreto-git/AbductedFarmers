package edu.unal.modelo;

import static edu.unal.vista.AbductedFarmers.loadImage;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * @author Marlon Andres Barreto Tejada
 * @author Vanesa Palacios
 * @author Valentina Viafara
 */
public class Map extends Canvas {

    private int tileSize,xRoot,yRoot;

    public Map() {
        initMap();
    }

    public void initMap(){
        tileSize = 16;
        xRoot = 50;
        yRoot = 35;
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D graph = (Graphics2D) g;
        graph.drawImage(loadImage("res/backgroundG.png"), 0, 0, null);
        graph.drawImage(loadImage("res/pasto.jpg"), xRoot, yRoot, null);
        graph.setColor(Color.RED);
        graph.fillRect(xRoot, yRoot, tileSize, tileSize);
    }

    public int getTileSize() {
        return tileSize;
    }

    public void setTileSize(int tileSize) {
        this.tileSize = tileSize;
    }

    public int getxRoot() {
        return xRoot;
    }

    public void setxRoot(int xRoot) {
        this.xRoot = xRoot;
    }

    public int getyRoot() {
        return yRoot;
    }

    public void setyRoot(int yRoot) {
        this.yRoot = yRoot;
    }

    
    
}
