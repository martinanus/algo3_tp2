package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.AlgoThief;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


public class BotonDestinoHandler implements EventHandler<ActionEvent> {

    private Label reloj;
    private AlgoThief juego;
    private String nombreCiudad;


    public BotonDestinoHandler(String nombreCiudad, AlgoThief juego, Label reloj) {
        this.nombreCiudad = nombreCiudad;
        this.juego = juego;
        this.reloj = reloj;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        juego.viajar(nombreCiudad);
        reloj.setText(juego.mostrarReloj());
    }
}
