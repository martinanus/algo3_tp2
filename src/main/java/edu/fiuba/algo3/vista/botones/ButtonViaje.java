package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.controlador.BotonDestinoHandler;
import edu.fiuba.algo3.modelo.AlgoThief;
import javafx.scene.control.Button;

public class ButtonViaje extends Button {
    public ButtonViaje(String nombreCiudad, AlgoThief juego) {
        super.setText(nombreCiudad);
        super.setPrefSize(80,50);
        BotonDestinoHandler botonDestinoHandler = new BotonDestinoHandler(nombreCiudad, juego);
        super.setOnAction(botonDestinoHandler);
    }
}
