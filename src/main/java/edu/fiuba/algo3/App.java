package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.AlgoThief;
import edu.fiuba.algo3.vista.ContenedorPantallaInicio;
import edu.fiuba.algo3.vista.ContenedorRegistro;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;

import java.io.File;
import java.net.URI;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        AlgoThief juego = new AlgoThief();
        
        File dir = new File(System.getProperty("user.dir") + "/musica/principal.mp3");
        URI path = dir.toURI();
        String direccionParaMedia = path.toString();
        Media musica = new Media(direccionParaMedia);
        AudioClip mediaPlayer = new AudioClip(musica.getSource());
        mediaPlayer.setCycleCount(AudioClip.INDEFINITE);
        mediaPlayer.play();
        mediaPlayer.setVolume(3);

        ContenedorRegistro contenedorRegistro = new ContenedorRegistro(stage, juego);
        Scene sceneRegistro = new Scene(contenedorRegistro, 640, 480);

        ContenedorPantallaInicio contenedorPantallaInicio = new ContenedorPantallaInicio(stage, sceneRegistro);
        Scene sceneInicial = new Scene(contenedorPantallaInicio, 640, 480);

        Image icono = new Image("file:"+System.getProperty("user.dir") + "/imgs/icono.jpg");
        stage.getIcons().add(icono);
        stage.setScene(sceneInicial);
        stage.setResizable(false);
        stage.show();
    }



    public static void main(String[] args) {
        launch();
    }

}