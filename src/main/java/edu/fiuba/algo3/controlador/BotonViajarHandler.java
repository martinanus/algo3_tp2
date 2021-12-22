package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.AlgoThief;
import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.vista.botones.ButtonViaje;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class BotonViajarHandler implements EventHandler<ActionEvent> {
    private Label reloj;
    private Button miBoton;
    private VBox cuadroAccion;
    private AlgoThief juego;

    public BotonViajarHandler(Button botonVer, VBox cuadroAccion, Label reloj, AlgoThief juego) {
        miBoton = botonVer;
        this.cuadroAccion = cuadroAccion;
        this.juego = juego;
        this.reloj = reloj;
    }

    @Override
    public void handle(ActionEvent event) {
        cuadroAccion.getChildren().clear();

        for(Ciudad ciudad: juego.mostrarCiudadesDestino()){
            Button botonViaje = new ButtonViaje(ciudad.getNombre(), reloj, juego);
            cuadroAccion.getChildren().add(botonViaje);
        }

    }
}
