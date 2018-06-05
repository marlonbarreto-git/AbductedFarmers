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
        player = new Player(xRoot + (1 * tileSize), yRoot + (1 * tileSize), 30, "farmer.png");
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
        //Limites de Arbustos
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

        //Arbustos centrales donde estara la nave Alien
        {
            int x1 = 13,
                    x2 = 23,
                    y1 = 8,
                    y2 = 17;

            for (int i = x1; i < x2; i++) {
                if (i == 17 || i == 18 || i == 19) {

                } else {
                    drawObject(g, xRoot + (i * tileSize), yRoot + (y1 * tileSize), "arbusto.png");
                    block[y1][i] = true;
                }

            }
            for (int i = x1; i < x2; i++) {
                drawObject(g, xRoot + (i * tileSize), yRoot + (y2 * tileSize), "arbusto.png");
                block[y2][i] = true;
            }
            for (int i = y1; i <= y2; i++) {
                drawObject(g, xRoot + (x1 * tileSize), yRoot + (i * tileSize), "arbusto.png");
                block[i][x1] = true;
            }
            for (int i = y1; i <= y2; i++) {
                drawObject(g, xRoot + (x2 * tileSize), yRoot + (i * tileSize), "arbusto.png");
                block[i][x2] = true;
            }
        }
        //Laberinto
        for (int i = 3; i < 34; i++) {
            if (i == 17 || i == 18 || i == 19) {

            } else {
                drawObject(g, xRoot + (i * tileSize), yRoot + (21 * tileSize), "arbusto.png");
                block[21][i] = true;
            }
        }

        for (int i = 0; i < 36; i++) {
            if (i > 4 && i < 32) {

            } else {
                drawObject(g, xRoot + (i * tileSize), yRoot + (18 * tileSize), "arbusto.png");
                block[18][i] = true;
            }
        }

        for (int i = 0; i < 36; i++) {
            if (i > 0 && i < 2 || i > 7 && i < 9 || i > 11 && i < 29 || i > 33 && i < 36) {

            } else {
                drawObject(g, xRoot + (i * tileSize), yRoot + (15 * tileSize), "arbusto.png");
                block[15][i] = true;
            }
        }

        for (int i = 0; i < 36; i++) {
            if (i > 0 && i < 3 || i > 6 && i < 30 || i > 33) {

            } else {
                drawObject(g, xRoot + (i * tileSize), yRoot + (12 * tileSize), "arbusto.png");
                block[12][i] = true;
            }
        }
        for (int i = 0; i < 36; i++) {
            if (i > 3 && i < 30 || i > 33) {

            } else {
                drawObject(g, xRoot + (i * tileSize), yRoot + (9 * tileSize), "arbusto.png");
                block[9][i] = true;
            }
        }
        for (int i = 3; i < 6; i++) {
            drawObject(g, xRoot + (i * tileSize), yRoot + (6 * tileSize), "arbusto.png");
            block[6][i] = true;
        }
        for (int i = 13; i < 15; i++) {
            drawObject(g, xRoot + (i * tileSize), yRoot + (6 * tileSize), "arbusto.png");
            block[6][i] = true;
        }
        for (int i = 0; i < 36; i++) {
            if (i > 4 && i < 8 || i > 10 && i < 18) {
                drawObject(g, xRoot + (i * tileSize), yRoot + (3 * tileSize), "arbusto.png");
                block[3][i] = true;
            }
        }
        for (int i = 3; i < 6; i++) {
            drawObject(g, xRoot + (3 * tileSize), yRoot + (i * tileSize), "arbusto.png");
            block[i][3] = true;
        }
        for (int i = 5; i < 9; i++) {
            drawObject(g, xRoot + (7 * tileSize), yRoot + (i * tileSize), "arbusto.png");
            block[i][7] = true;
        }
        for (int i = 15; i < 20; i++) {
            drawObject(g, xRoot + (7 * tileSize), yRoot + (i * tileSize), "arbusto.png");
            block[i][7] = true;
        }
        for (int i = 5; i < 11; i++) {
            drawObject(g, xRoot + (11 * tileSize), yRoot + (i * tileSize), "arbusto.png");
            block[i][11] = true;
        }

        for (int i = 17; i < 22; i++) {
            drawObject(g, xRoot + (11 * tileSize), yRoot + (i * tileSize), "arbusto.png");
            block[i][11] = true;
        }
        for (int i = 5; i < 8; i++) {
            drawObject(g, xRoot + (16 * tileSize), yRoot + (i * tileSize), "arbusto.png");
            block[i][16] = true;
        }
        for (int i = 19; i < 22; i++) {
            drawObject(g, xRoot + (18 * tileSize), yRoot + (i * tileSize), "arbusto.png");
            block[i][18] = true;
        }
        for (int i = 9; i < 19; i++) {
            drawObject(g, xRoot + (26 * tileSize), yRoot + (i * tileSize), "arbusto.png");
            block[i][26] = true;
        }
        for (int i = 16; i < 20; i++) {
            drawObject(g, xRoot + (29 * tileSize), yRoot + (i * tileSize), "arbusto.png");
            block[i][29] = true;
        }

        //Nave espacial
        drawObject(g, xRoot + (16 * tileSize), yRoot + (10 * tileSize), "nave.png");

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

        //Maiz del piso
        for (int j = 0; j < 25; j++) {
            for (int i = 0; i < 36; i++) {
                if (block[j][i] == false) {
                    drawObject(g, xRoot + (i * tileSize), yRoot + (j * tileSize), "maize.png");
                }
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
