package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.AlgoThief;
import edu.fiuba.algo3.vista.ContenedorPantallaInicio;
import edu.fiuba.algo3.vista.ContenedorRegistro;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        AlgoThief juego = new AlgoThief();
        
        ContenedorRegistro contenedorRegistro = new ContenedorRegistro(stage, juego);
        Scene sceneRegistro = new Scene(contenedorRegistro, 640, 480);

        ContenedorPantallaInicio contenedorPantallaInicio = new ContenedorPantallaInicio(stage, sceneRegistro);
        Scene sceneInicial = new Scene(contenedorPantallaInicio, 640, 480);

        stage.setScene(sceneInicial);
        stage.setResizable(false);
        stage.show();
    }



    public static void main(String[] args) {
        launch();
    }

}