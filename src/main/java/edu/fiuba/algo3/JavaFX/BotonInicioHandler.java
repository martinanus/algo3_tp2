package edu.fiuba.algo3.JavaFX;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.stage.Stage;

public class BotonInicioHandler implements EventHandler<ActionEvent> {

    private Button miBoton;
    private Scene miScene;
    private Stage miStage;

    public BotonInicioHandler(Button botonInicio, Scene sceneCiudad, Stage stage) {
        this.miBoton = botonInicio;
        this.miScene = sceneCiudad;
        this.miStage = stage;
    }


    @Override
    public void handle(ActionEvent actionEvent) {

        String textoClickeado = "Iniciando...!";

        System.out.println(textoClickeado);
        this.miBoton.setText(textoClickeado);

        miStage.setScene(miScene);
        miStage.setTitle("Juego - Pantalla Ciudad");
    }
}

