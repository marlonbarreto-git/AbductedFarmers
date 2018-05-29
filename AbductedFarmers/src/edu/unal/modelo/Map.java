package edu.unal.modelo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JPanel;

/**
 * @author Marlon Andres Barreto Tejada
 * @author Vanesa Palacios
 * @author Valentina Viafara
 */
public class Map extends JPanel {

    private int[][] mapa;
    private URL url = null;

    public Map() {
        //mapa = cargar("design.txt");
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawScene(g);
    }

    private void drawScene(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
//        for (int i = 0; i < mapa.length; i++) {
//          for (int j = 0; j < mapa[i].length; j++) {
//              if(mapa[i][j] == 0){
//                 g.setColor(Color.white);
//                 g.fillRect(i*30, j*20,30, 30);
//              }else if(mapa[i][j] == 1){
//                 g.setColor(Color.BLACK);
//                 g.fillRect(i*30, j*20,30, 30);
//                 g.setColor(Color.white);
//              }else if(mapa[i][j] == 2){
//                 g.setColor(Color.RED);
//                 g.fillRect(i*30, j*20,30, 30);
//                 g.setColor(Color.white);
//              }
//          }   
//            System.out.println("");
//        }
    }

    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public ArrayList<ArrayList<Integer>> cargar(String ruta) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        File archivo = new File(ruta);
        if(archivo.exists()){
            try {
                Scanner scan = new Scanner(archivo);
                  for (ArrayList<Integer> row : matrix) {
                      for(int i = 0;i < scan.nextLine().length();i++){
                          Integer integer = scan.nextInt();
                          //TODO
                      }
                  }
            } catch (FileNotFoundException ex) {
              return null;  
            }
            
            return matrix;
        }else
             return null;
    }
    
}
