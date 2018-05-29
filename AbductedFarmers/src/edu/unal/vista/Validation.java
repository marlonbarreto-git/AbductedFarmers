package edu.unal.vista;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

/**
 * @author Marlon Andres Barreto Tejada
 * @author Vanesa Palacios
 * @author Valentina Viafara
 */
public class Validation extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Font.loadFont(new FileInputStream("resources/AlienPlanet.ttf"), 15);

        BorderPane border = new BorderPane();

        VBox pane = new VBox();
        pane.setPadding(new Insets(50));

        TextField text = new TextField();
        text.setFont(new Font("Courier", 10));
        text.setText("Serial de Activacion");
        text.setRotate(2);

        Label title = new Label("   Bienvenido a Abducted Farmers\n ");
        title.setTextFill(Color.WHITE);
        title.setFont(new Font("Alien Planet", 40));

        Button ok = new Button("Validar");
        ok.setOnAction((event) -> {
            String serial = text.getText();
            if(Validar(serial)){
                AbductedFarmers game = new AbductedFarmers();
                game.setVisible(true);
                primaryStage.setOpacity(0);
            }
        });
        ok.setCursor(Cursor.HAND);
        ok.setEffect(new ImageInput(new Image(new FileInputStream("resources/large.png"))));

        pane.setAlignment(Pos.TOP_CENTER);
        pane.getChildren().add(text);
        pane.getChildren().add(new Label(" "));
        pane.getChildren().add(new Label(" "));
        HBox hh = new HBox();
        hh.getChildren().add(
                new Label("                                "));
        hh.getChildren().add(ok);
        pane.getChildren().add(hh);

        border.setCenter(pane);
        border.setTop(title);

        StackPane principal = new StackPane();
        principal.getChildren().add(new ImageView(new Image(new FileInputStream("resources/backgroung.png"))));
        principal.getChildren().add(border);

        Scene scene = new Scene(principal, 500, 300);

        primaryStage.setTitle("Validacion Abducted Farmers");
        primaryStage.setAlwaysOnTop(true);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public boolean Validar(String serial) {
        boolean activated = false;
        try {
            Scanner scan = new Scanner(new FileInputStream("resources/activationCode.txt"));
            while (scan.hasNext()) {
                if (scan.nextLine().equals(serial)) {
                    activated = true;
                    break;
                }
            }
        } catch (FileNotFoundException ex) {

        }
        return activated;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
