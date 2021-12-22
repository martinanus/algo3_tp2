package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.controlador.BotonDestinoHandler;
import edu.fiuba.algo3.modelo.AlgoThief;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ButtonViaje extends Button {
    public ButtonViaje(String nombreCiudad, Label reloj, AlgoThief juego) {
        super.setText(nombreCiudad);
        super.setPrefSize(80,50);
<<<<<<< HEAD
        BotonDestinoHandler botonDestinoHandler = new BotonDestinoHandler(nombreCiudad, juego);
        super.setOnAction(botonDestinoHandler);
=======
        BotonViajeHandler botonViajeHandler = new BotonViajeHandler(nombreCiudad, reloj, juego);
        super.setOnAction(botonViajeHandler);
>>>>>>> e0c92bca9ca94520415f6e073a6994f61ce1777b
    }
}
