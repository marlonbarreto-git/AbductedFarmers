package edu.unal.vista;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

/**
 * @author Marlon Andres Barreto Tejada
 * @author Vanesa Palacios
 * @author Valentina Viafara
 */
public class Validation extends Application{
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

        Scene scene = new Scene(border, 500, 200);

        primaryStage.setTitle("Validacion Abducted Farmers");
        primaryStage.setAlwaysOnTop(true);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public boolean Validar(String serial){
        return false;
    }
    
}
