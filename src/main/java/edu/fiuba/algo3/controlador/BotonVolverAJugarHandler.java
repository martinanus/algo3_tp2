package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.AlgoThief;
import edu.fiuba.algo3.vista.ContenedorCiudad;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonVolverAJugarHandler implements EventHandler<ActionEvent> {

    private AlgoThief juego;
    private Stage stage;

    public BotonVolverAJugarHandler(Stage stage, AlgoThief juego) {
        this.stage = stage;
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent event) {
        juego.generarPartida();
        ContenedorCiudad contenedorCiudad = new ContenedorCiudad(juego, stage);
        Scene sceneCiudad = new Scene(contenedorCiudad, 640, 480);
        stage.setScene(sceneCiudad);


    }
}
