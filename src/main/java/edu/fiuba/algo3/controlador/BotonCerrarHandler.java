package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BotonCerrarHandler implements EventHandler<ActionEvent> {

    private Stage mistage;

    public BotonCerrarHandler( Stage stage) {
        this.mistage = stage;
    }


    @Override
    public void handle(ActionEvent actionEvent) {

        System.out.println( "Cerraste el juego!!");
        mistage.close();

    }
}
