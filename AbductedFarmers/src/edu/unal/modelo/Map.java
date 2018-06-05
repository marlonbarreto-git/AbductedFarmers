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

    private static int tileSize;
    private int numTilesX;
    private int numTilesY;
    private static int xRoot, yRoot;
    private Player player;
    private static boolean[][] block;

    public Map() {
        initMap();
    }

    public void initMap() {
        tileSize = 20;
        xRoot = 50;
        yRoot = 35;
        numTilesX = 720 / tileSize;
        numTilesY = 500 / tileSize;
        player = new Player(xRoot + (2 * tileSize), yRoot + (2 * tileSize), 30, "farmer.png");
        block = new boolean[numTilesY][numTilesX];
        for (int i = 0; i < numTilesY; i++) {
            for (int j = 0; j < numTilesX; j++) {
                block[i][j] = false;
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D graph = (Graphics2D) g;
        //Fondo del Juego
        drawObject(g, 0, 0, "backgroundG.png");
        //Pasto del Juego
        drawObject(g, xRoot, yRoot, "pasto.jpg");
        //Escavadora del Granjero
        drawObject(g, xRoot + (28 * tileSize), yRoot + (1 * tileSize), "escavadora.png");
        for (int j = 1; j < 3; j++) {
            for (int i = 28; i < 30; i++) {
                block[j][i] = true;
            }
        }
        //Cerca de piedras alrededor de la casa
        for (int i = 0; i < 5; i++) {
            drawObject(g, xRoot + (26 * tileSize), yRoot + (i * tileSize), "piedra.png");
            block[i][26] = true;
        }
        for (int i = 0; i < 5; i++) {
            drawObject(g, xRoot + ((34 - i) * tileSize), yRoot + (7 * tileSize), "piedra.png");
            block[7][34 - i] = true;
        }
        //Cerca de Arbustos
        for (int i = 24; i >= 0; i--) {
            drawObject(g, xRoot + (i * tileSize), yRoot + (0 * tileSize), "arbusto.png");
            block[0][i] = true;
        }
        for (int i = 23; i >= 0; i--) {
            drawObject(g, xRoot + (0 * tileSize), yRoot + (i * tileSize), "arbusto.png");
            block[i][0] = true;
        }
        for (int i = 0; i < 35; i++) {
            drawObject(g, xRoot + (i * tileSize), yRoot + (23 * tileSize), "arbusto.png");
            block[23][i] = true;
        }
        for (int i = 23; i >= 0; i--) {
            drawObject(g, xRoot + (35 * tileSize), yRoot + (i * tileSize), "arbusto.png");
            block[i][35] = true;
        }
        //Choza del Granjero
        drawObject(g, xRoot + (22 * tileSize), yRoot + (0 * tileSize), "choza.png");
        for (int j = 0; j < 3; j++) {
            for (int i = 22; i < 26; i++) {
                block[j][i] = true;
            }
        }
        //Casa del Granjero
        drawObject(g, xRoot + (30 * tileSize), yRoot, "casa.png");
        for (int j = 0; j < 4; j++) {
            for (int i = 30; i < 35; i++) {
                block[j][i] = true;
            }
        }

        player.paint(graph);
    }

    public static int getTileSize() {
        return tileSize;
    }

    public static void setTileSize(int tileSize) {
        Map.tileSize = tileSize;
    }

    public static int getxRoot() {
        return xRoot;
    }

    public static void setxRoot(int xRoot) {
        Map.xRoot = xRoot;
    }

    public static int getyRoot() {
        return yRoot;
    }

    public static void setyRoot(int yRoot) {
        Map.yRoot = yRoot;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public static boolean isBlock(int x, int y) {
        return block[y][x];
    }

    public void drawObject(Graphics g, int x, int y, String objeto) {
        Graphics2D graph = (Graphics2D) g;
        graph.drawImage(loadImage("res/" + objeto), x, y, null);
    }

}
