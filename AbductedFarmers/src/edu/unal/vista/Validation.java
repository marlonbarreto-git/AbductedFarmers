package edu.unal.vista;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    AbductedFarmers game;

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Tipografia para el titulo de la ventana de Validacion
        Font.loadFont(new FileInputStream("res/AlienPlanet.ttf"), 15);

        //Layout contenedor de los demas, excepto el fondo, que esta en el StackPane
        BorderPane border = new BorderPane();

        VBox pane = new VBox();
        pane.setPadding(new Insets(50));

        //Barra de text donde se introducira el Serial
        TextField text = new TextField();
        text.setFont(new Font("Courier", 20));
        text.setText("Serial de Activacion");
        text.setRotate(2);

        //Titulo de la ventana de Validacion
        Label title = new Label("   Bienvenido a Abducted Farmers\n ");
        title.setTextFill(Color.WHITE);
        title.setFont(new Font("Alien Planet", 40));

        //Boton para Validar la activacion
        Button ok = new Button("Validar");
        ok.setOnAction((event) -> {
            String serial = text.getText();
            if (Validar(serial)) {
                game = new AbductedFarmers();
                game.startGame();
                primaryStage.setIconified(true);
//                //Cancion de fondo
//                URL url = null;
//                try {
//                    url = new URL("file:res/ToyStory.wav");
//                } catch (MalformedURLException ex) {
//                    Logger.getLogger(Validation.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                AudioClip ac = Applet.newAudioClip(url);
//                ac.loop(); //para que el sonido se reproduzca y se repita al finalizar
            }
        });
        ok.setCursor(Cursor.HAND);//Cursor al pasar el mouse sobre el boton
        ok.setEffect(new ImageInput(new Image(new FileInputStream("res/large.png"))));//Icono del Boton que valida la activacion

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

        //Panel para la imagen de Fondo
        StackPane principal = new StackPane();
        principal.getChildren().add(new ImageView(new Image(new FileInputStream("res/backgroung.png"))));
        principal.getChildren().add(border);
        principal.setEffect(new MotionBlur(10, 2));

        //Escena de la ventana de Validacion
        Scene scene = new Scene(principal, 500, 300);

        primaryStage.setTitle("Validacion Abducted Farmers");
        primaryStage.setAlwaysOnTop(true);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setOpacity(0.9);

    }

    public boolean Validar(String serial) {
        boolean activated = false;
        try {
            Scanner scan = new Scanner(new FileInputStream("res/activationCode.txt"));
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

        //Cancion de fondo
        URL url = null;
        try {
            url = new URL("file:res/ToyStory.mp3");
        } catch (MalformedURLException ex) {
            Logger.getLogger(Validation.class.getName()).log(Level.SEVERE, null, ex);
        }
        AudioClip ac = Applet.newAudioClip(url);
        ac.loop(); //para que el sonido se reproduzca y se repita al finalizar

        Application.launch(args);
    }

}
