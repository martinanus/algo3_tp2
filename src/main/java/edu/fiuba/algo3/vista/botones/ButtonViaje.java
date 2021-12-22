package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.controlador.BotonViajeHandler;
import edu.fiuba.algo3.modelo.AlgoThief;
import edu.fiuba.algo3.modelo.Ciudad;
import javafx.scene.control.Button;

public class ButtonViaje extends Button {
    public ButtonViaje(String nombreCiudad, AlgoThief juego) {
        super.setText(nombreCiudad);
        super.setPrefSize(80,50);
        BotonViajeHandler botonViajeHandler = new BotonViajeHandler(nombreCiudad, juego);
        super.setOnAction(botonViajeHandler);
    }
}
