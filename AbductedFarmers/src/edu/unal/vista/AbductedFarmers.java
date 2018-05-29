package edu.unal.vista;

import edu.unal.modelo.Map;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
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
    
}
