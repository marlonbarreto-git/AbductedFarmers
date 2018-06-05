package edu.unal.modelo;

import static edu.unal.vista.AbductedFarmers.loadImage;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * @author Marlon Andres Barreto Tejada
 * @author Vanesa Palacios
 * @author Valentina Viafara
 */
public class Map extends Canvas {

    private int tileSize, xRoot, yRoot;
    private Player player;

    public Map() {
        initMap();
    }

    public void initMap() {
        tileSize = 20;
        xRoot = 50;
        yRoot = 35;
        player = new Player(xRoot, yRoot, 30, "farmer.png");
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D graph = (Graphics2D) g;
        drawObject(g, 0, 0, "backgroundG.png");
        drawObject(g, xRoot, yRoot, "pasto.jpg");
        
        drawObject(g, xRoot + (28 * tileSize), yRoot + (1 * tileSize), "escavadora.png");
        for (int i = 0; i < 5; i++) {
            drawObject(g, xRoot + (26 * tileSize), yRoot + (i * tileSize), "piedra.png");
        }
        for (int i = 0; i < 5; i++) {
            drawObject(g, xRoot + ((34-i) * tileSize), yRoot + (7 * tileSize), "piedra.png");
        }
        for(int i=24;i>=0;i--){
            drawObject(g, xRoot+ (i * tileSize), yRoot+ (0 * tileSize), "arbusto.png");
        }
        drawObject(g, xRoot + (22 * tileSize), yRoot, "choza.png");
        for(int i=23;i>=0;i--){
            drawObject(g, xRoot+ (0 * tileSize), yRoot+ (i * tileSize), "arbusto.png");
        }
        for(int i=0;i<35;i++){
            drawObject(g, xRoot+ (i * tileSize), yRoot+ (23 * tileSize), "arbusto.png");
        }
        for(int i=23;i>=0;i--){
            drawObject(g, xRoot+ (35 * tileSize), yRoot+ (i * tileSize), "arbusto.png");
        }
        drawObject(g, xRoot + (30 * tileSize), yRoot, "casa.png");
        player.paint(graph);
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

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    
    public void drawObject(Graphics g, int x, int y, String objeto) {
        Graphics2D graph = (Graphics2D) g;
        graph.drawImage(loadImage("res/" + objeto), x, y, null);
    }

}
