package edu.unal.vista;

import edu.unal.modelo.Map;
import javax.swing.JFrame;

/**
 * @author Marlon Andres Barreto Tejada
 * @author Vanesa Palacios
 * @author Valentina Viafara
 */
public class AbductedFarmers extends JFrame{
    
    public AbductedFarmers(){
        initUI();
    }
    
    private void initUI() {
        add(new Map());
        setSize(800, 600);
        setTitle("Abducted Farmers");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }    
                
    public static void main(String[] args) {
        AbductedFarmers ex = new AbductedFarmers();
        ex.setVisible(true);
       
    }


}
