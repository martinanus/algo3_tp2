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
    private VBox cuadroAccion;
    private AlgoThief juego;

    public BotonViajarHandler(Button botonVer, VBox cuadroAccion, Label reloj, AlgoThief juego) {

        this.cuadroAccion = cuadroAccion;
        this.juego = juego;
        this.reloj = reloj;
    }

    @Override
    public void handle(ActionEvent event) {
        cuadroAccion.getChildren().clear();
        String nombreCiudad;

        for(Ciudad ciudad: juego.mostrarCiudadesDestino()){
            Button botonViaje = new ButtonViaje();
            nombreCiudad = ciudad.getNombre();
            botonViaje.setText(nombreCiudad);
            botonViaje.setPrefSize(80,50);
            BotonDestinoHandler botonDestinoHandler = new BotonDestinoHandler(nombreCiudad, juego, reloj);
            botonViaje.setOnAction(botonDestinoHandler);

            cuadroAccion.getChildren().add(botonViaje);
        }






    }
}
