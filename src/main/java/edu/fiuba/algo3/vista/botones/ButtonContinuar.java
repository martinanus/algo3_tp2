package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.controlador.BotonContinuarHandler;
import edu.fiuba.algo3.controlador.BotonInicioHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ButtonContinuar extends Button {
    public ButtonContinuar() {
        super.setText("Continuar");
        //BotonContinuarHandler botonContinuarHandler = new BotonContinuarHandler(this , sceneCiudad, stage);
        //super.setOnAction(botonContinuarHandler);
    }
}
