package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.AlgoThief;
import edu.fiuba.algo3.vista.ContenedorCaso;
import edu.fiuba.algo3.vista.ContenedorCiudad;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonNuevoCasoHandler implements EventHandler<ActionEvent> {

    private AlgoThief juego;
    private Stage stage;

    public BotonNuevoCasoHandler(Stage stage, AlgoThief juego) {
        this.stage = stage;
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent event) {
        juego.generarPartida();
        ContenedorCaso contenedorCaso = new ContenedorCaso(stage, juego);
        Scene sceneCaso = new Scene(contenedorCaso, 640, 480);
        stage.setScene(sceneCaso);


    }
}
