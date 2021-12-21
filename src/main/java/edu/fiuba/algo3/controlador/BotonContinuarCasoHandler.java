package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.AlgoThief;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BotonContinuarCasoHandler implements EventHandler<ActionEvent> {

    private Scene miScene;
    private Stage miStage;

    public BotonContinuarCasoHandler(Button botonContinuar, Scene sceneCiudad, Stage stage) {
        this.miScene = sceneCiudad;
        this.miStage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        miStage.setScene(miScene);
        miStage.setTitle("Juego - Pantalla Ciudad");
    }
}
