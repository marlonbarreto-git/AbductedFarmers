package edu.unal.vista;


import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * @author Marlon Andres Barreto Tejada
 * @author Vanesa Palacios
 * @author Valentina Viafara
 */
public class AbductedFarmers extends Application{
    
    public static void main(String[] args) throws FileNotFoundException {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane border = new BorderPane();
        
        VBox pane = new VBox();
        pane.setPadding(new Insets(50));        
        
        Label title = new Label("Bienvenido a Abducted Farmers\n ");
        title.setFont(new Font("Consolas", 25));
        
        Button ok = new Button("Validar"); 
        ok.setMaxWidth(Double.MAX_VALUE);
        
        pane.setAlignment(Pos.TOP_CENTER);
        pane.getChildren().add(title);        
        pane.getChildren().add(new TextField());
        pane.getChildren().add(ok);
        border.setCenter(pane);
        
        border.setTop(new Label(""));
        border.setBottom(new Label(""));
        border.setRight(new Label("   "));
        border.setLeft(new Label("   "));
        
        Scene scene = new Scene(border,500,200);
        
        primaryStage.setTitle("Validacion Abducted Farmers");
        primaryStage.setAlwaysOnTop(true);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
