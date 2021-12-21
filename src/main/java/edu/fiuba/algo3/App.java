package edu.fiuba.algo3;

import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.modelo.AlgoThief;
import edu.fiuba.algo3.modelo.Policia;
import edu.fiuba.algo3.vista.SceneCiudad;
import edu.fiuba.algo3.vista.SceneInicial;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        AlgoThief juego = new AlgoThief();

        SceneCiudad sceneParaCiudad = new SceneCiudad();
        Scene sceneCiudad = new Scene(sceneParaCiudad.crearSceneCiudad(juego), 640, 480);

        SceneInicial inicial = new SceneInicial();
        Scene sceneInicial = new Scene(inicial.crearSceneInicial(sceneCiudad, stage, juego), 640, 480);

        stage.setScene(sceneInicial);
        stage.setResizable(false);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}