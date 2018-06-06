package edu.unal.modelo;

import static edu.unal.vista.AbductedFarmers.loadImage;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;

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
    public static boolean[][] maize;
    private ArrayList<Enemy> enemys;
    public static Timer timer;
    public static int maxScore;

    public Map() {
        initMap();
    }

    public void initMap() {
        maxScore = 24400;
        tileSize = 20;
        xRoot = 50;
        yRoot = 35;
        numTilesX = 720 / tileSize;
        numTilesY = 500 / tileSize;
        player = new Player(xRoot + (32 * tileSize), yRoot + (5 * tileSize), 30, "farmer.png");
        player.setScore(24300);
        enemys = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            enemys.add(new Enemy(xRoot + ((14 + i) * tileSize), yRoot + ((9 + i) * tileSize), 30, "enemy1.png"));
        }
        maize = new boolean[numTilesY][numTilesX];
        block = new boolean[numTilesY][numTilesX];
        for (int i = 0; i < numTilesY; i++) {
            for (int j = 0; j < numTilesX; j++) {
                block[i][j] = false;
                maize[i][j] = true;
            }
        }
        timer = new Timer(120, (e) -> {
            this.repaint();

            for (Enemy ene : enemys) {
                if (player.getTilePosX() == ene.getTilePosX() && player.getTilePosY() == ene.getTilePosY()) {
                    int live = player.getLives() - 1;
                    player.setLives(live);
                    player.setPosX(xRoot + (32 * tileSize));
                    player.setPosY(yRoot + (5 * tileSize));
                    timer.stop();
                }
            }
        });

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D graph = (Graphics2D) g;

        if (player.getScore() == maxScore) {
            //Fondo del Juego
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, 800, 600);
            Random ran = new Random();
            for (int j = 0; j < 600 / 20; j++) {
                for (int i = 0; i < 800 / 20; i++) {
                    Color color = new Color(ran.nextInt());
                    g.setColor(color);
                    char random = (char) ran.nextInt(9000);
                    g.setFont(new Font("Courier", 0, 20));
                    g.drawString("" + random, i * 20, j * 20);
                }
            }
            g.setColor(Color.WHITE);
            g.setFont(new Font("Courier", 3, 150));
            g.drawString("GAME OVER", xRoot - 50, yRoot + 250);
            g.drawString("WINNER", xRoot, yRoot + 400);

        } else if (player.getLives() <= 0) {
            //Fondo del Juego
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, 800, 600);
            Random ran = new Random();
            for (int j = 0; j < 600 / 20; j++) {
                for (int i = 0; i < 800 / 20; i++) {
                    Color color = new Color(ran.nextInt());
                    g.setColor(color);
                    char random = (char) ran.nextInt(9000);
                    g.setFont(new Font("Courier", 3, 20));
                    g.drawString("" + random, i * 20, j * 20);
                }
            }
            g.setColor(Color.WHITE);
            g.setFont(new Font("Courier", 0, 150));
            g.drawString("GAME OVER", xRoot - 50, yRoot + 250);
            g.drawString("LOSER!!!", xRoot, yRoot + 400);

        } else {

            //Fondo del Juego
            drawObject(g, 0, 0, "backgroundG.png");
            //Pasto del Juego
            drawObject(g, xRoot, yRoot, "pasto.jpg");
            //Escavadora del Granjero
            drawObject(g, xRoot + (28 * tileSize), yRoot + (1 * tileSize), "escavadora.png");
            for (int j = 1; j < 3; j++) {
                for (int i = 28; i < 30; i++) {
                    block[j][i] = true;
                    maize[j][i] = false;
                }
            }
            //Cerca de piedras alrededor de la casa
            for (int i = 0; i < 5; i++) {
                drawPiedra(g, 26, i);
            }
            for (int i = 0; i < 5; i++) {
                drawPiedra(g, 34 - i, 7);
            }

            //Limites de Arbustos
            drawLimites(g);

            //Arbustos centrales donde estara la nave Alien
            drawArbustosCentrales(g);

            //Laberinto
            drawLaberinto(g);

            //Nave espacial
            drawObject(g, xRoot + (16 * tileSize), yRoot + (10 * tileSize), "nave.png");

            //Choza del Granjero
            drawChoza(g);

            //Casa del Granjero
            drawCasa(g);

            //Maiz del piso
            drawMaiz(g);

            //Puntaje del Jugador
            g.setColor(Color.WHITE);
            g.setFont(new Font("Courier", 0, 15));
            g.drawString("Score: " + player.getScore(), xRoot, yRoot + 530);

            //Vidas
            g.drawString("Lives: ", xRoot + 500, yRoot + 530);
            for (int i = 0; i < player.getLives(); i++) {
                drawObject(g, xRoot + 550 + (i * 32), yRoot + 510, "live.png");
            }

            player.paint(graph);
            enemys.forEach((e) -> {
                e.paint(graph);
                e.moveRandom();
            });
        }
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

    private void drawPiedra(Graphics g, int x, int y) {
        drawObject(g, xRoot + (x * tileSize), yRoot + (y * tileSize), "piedra.png");
        block[y][x] = true;
        maize[y][x] = false;
    }

    private void drawLimites(Graphics g) {
        for (int i = 24; i >= 0; i--) {
            drawObject(g, xRoot + (i * tileSize), yRoot + (0 * tileSize), "arbusto.png");
            block[0][i] = true;
            maize[0][i] = false;
        }
        for (int i = 23; i >= 0; i--) {
            drawObject(g, xRoot + (0 * tileSize), yRoot + (i * tileSize), "arbusto.png");
            block[i][0] = true;
            maize[i][0] = false;
        }
        for (int i = 0; i < 35; i++) {
            drawObject(g, xRoot + (i * tileSize), yRoot + (23 * tileSize), "arbusto.png");
            block[23][i] = true;
            maize[23][i] = false;
        }
        for (int i = 23; i >= 0; i--) {
            drawObject(g, xRoot + (35 * tileSize), yRoot + (i * tileSize), "arbusto.png");
            block[i][35] = true;
            maize[i][35] = false;
        }
    }

    private void drawArbustosCentrales(Graphics g) {
        int x1 = 13,
                x2 = 23,
                y1 = 8,
                y2 = 17;

        for (int i = x1; i < x2; i++) {
            if (i == 17 || i == 18 || i == 19) {

            } else {
                drawObject(g, xRoot + (i * tileSize), yRoot + (y1 * tileSize), "arbusto.png");
                block[y1][i] = true;
                maize[y1][i] = false;
            }

        }
        for (int i = x1; i < x2; i++) {
            drawObject(g, xRoot + (i * tileSize), yRoot + (y2 * tileSize), "arbusto.png");
            block[y2][i] = true;
            maize[y2][i] = false;
        }
        for (int i = y1; i <= y2; i++) {
            drawObject(g, xRoot + (x1 * tileSize), yRoot + (i * tileSize), "arbusto.png");
            block[i][x1] = true;
            maize[i][x1] = false;
        }
        for (int i = y1; i <= y2; i++) {
            drawObject(g, xRoot + (x2 * tileSize), yRoot + (i * tileSize), "arbusto.png");
            block[i][x2] = true;
            maize[i][x2] = false;
        }
    }

    private void drawLaberinto(Graphics g) {
        for (int i = 3; i < 34; i++) {
            if (i == 17 || i == 18 || i == 19) {

            } else {
                drawObject(g, xRoot + (i * tileSize), yRoot + (21 * tileSize), "arbusto.png");
                block[21][i] = true;
                maize[21][i] = false;
            }
        }

        for (int i = 0; i < 36; i++) {
            if (i > 4 && i < 32) {

            } else {
                drawObject(g, xRoot + (i * tileSize), yRoot + (18 * tileSize), "arbusto.png");
                block[18][i] = true;
                maize[18][i] = false;
            }
        }

        for (int i = 0; i < 36; i++) {
            if (i > 0 && i < 2 || i > 7 && i < 9 || i > 11 && i < 29 || i > 33 && i < 36) {

            } else {
                drawObject(g, xRoot + (i * tileSize), yRoot + (15 * tileSize), "arbusto.png");
                block[15][i] = true;
                maize[15][i] = false;
            }
        }

        for (int i = 0; i < 36; i++) {
            if (i > 0 && i < 3 || i > 6 && i < 30 || i > 33) {

            } else {
                drawObject(g, xRoot + (i * tileSize), yRoot + (12 * tileSize), "arbusto.png");
                block[12][i] = true;
                maize[12][i] = false;
            }
        }
        for (int i = 0; i < 36; i++) {
            if (i > 3 && i < 30 || i > 33) {

            } else {
                drawObject(g, xRoot + (i * tileSize), yRoot + (9 * tileSize), "arbusto.png");
                block[9][i] = true;
                maize[9][i] = false;
            }
        }
        for (int i = 3; i < 6; i++) {
            drawObject(g, xRoot + (i * tileSize), yRoot + (6 * tileSize), "arbusto.png");
            block[6][i] = true;
            maize[6][i] = false;
        }
        for (int i = 13; i < 15; i++) {
            drawObject(g, xRoot + (i * tileSize), yRoot + (6 * tileSize), "arbusto.png");
            block[6][i] = true;
            maize[6][i] = false;
        }
        for (int i = 0; i < 36; i++) {
            if (i > 4 && i < 8 || i > 10 && i < 18) {
                drawObject(g, xRoot + (i * tileSize), yRoot + (3 * tileSize), "arbusto.png");
                block[3][i] = true;
                maize[3][i] = false;
            }
        }
        for (int i = 3; i < 6; i++) {
            drawObject(g, xRoot + (3 * tileSize), yRoot + (i * tileSize), "arbusto.png");
            block[i][3] = true;
            maize[i][3] = false;
        }
        for (int i = 5; i < 9; i++) {
            drawObject(g, xRoot + (7 * tileSize), yRoot + (i * tileSize), "arbusto.png");
            block[i][7] = true;
            maize[i][7] = false;
        }
        for (int i = 15; i < 20; i++) {
            drawObject(g, xRoot + (7 * tileSize), yRoot + (i * tileSize), "arbusto.png");
            block[i][7] = true;
            maize[i][7] = false;
        }
        for (int i = 5; i < 11; i++) {
            drawObject(g, xRoot + (11 * tileSize), yRoot + (i * tileSize), "arbusto.png");
            block[i][11] = true;
            maize[i][11] = false;
        }

        for (int i = 17; i < 22; i++) {
            drawObject(g, xRoot + (11 * tileSize), yRoot + (i * tileSize), "arbusto.png");
            block[i][11] = true;
            maize[i][11] = false;
        }
        for (int i = 5; i < 8; i++) {
            drawObject(g, xRoot + (16 * tileSize), yRoot + (i * tileSize), "arbusto.png");
            block[i][16] = true;
            maize[i][16] = false;
        }
        for (int i = 19; i < 22; i++) {
            drawObject(g, xRoot + (18 * tileSize), yRoot + (i * tileSize), "arbusto.png");
            block[i][18] = true;
            maize[i][18] = false;
        }
        for (int i = 9; i < 19; i++) {
            drawObject(g, xRoot + (26 * tileSize), yRoot + (i * tileSize), "arbusto.png");
            block[i][26] = true;
            maize[i][26] = false;
        }
        for (int i = 16; i < 20; i++) {
            drawObject(g, xRoot + (29 * tileSize), yRoot + (i * tileSize), "arbusto.png");
            block[i][29] = true;
            maize[i][29] = false;
        }
    }

    private void drawChoza(Graphics g) {
        drawObject(g, xRoot + (22 * tileSize), yRoot + (0 * tileSize), "choza.png");
        for (int j = 0; j < 3; j++) {
            for (int i = 22; i < 26; i++) {
                block[j][i] = true;
                maize[j][i] = false;
            }
        }
    }

    private void drawCasa(Graphics g) {
        drawObject(g, xRoot + (30 * tileSize), yRoot, "casa.png");
        for (int j = 0; j < 4; j++) {
            for (int i = 30; i < 35; i++) {
                block[j][i] = true;
                maize[j][i] = false;
            }
        }
    }

    private void drawMaiz(Graphics g) {
        for (int i = 9; i < 17; i++) {
            for (int j = 14; j < 23; j++) {
                maize[i][j] = false;
            }
        }
        for (int j = 0; j < 24; j++) {
            for (int i = 0; i < 36; i++) {
                if (maize[j][i] == true) {
                    drawObject(g, xRoot + (i * tileSize), yRoot + (j * tileSize), "maize.png");
                }
            }
        }
    }

}
