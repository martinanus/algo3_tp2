package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.controlador.BotonContinuarCasoHandler;
import edu.fiuba.algo3.controlador.BotonContinuarHandler;
import edu.fiuba.algo3.modelo.AlgoThief;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ButtonContinuar extends Button {

    public ButtonContinuar(Stage stage, TextField textNombre, Label nombre, AlgoThief juego) {
        super.setText("Continuar");
        BotonContinuarHandler botonContinuarHandler = new BotonContinuarHandler(this , stage, textNombre, nombre, juego);
        super.setOnAction(botonContinuarHandler);
    }

    public ButtonContinuar(Scene sceneCaso, Stage stage) {
        super.setText("Continuar");
        BotonContinuarCasoHandler botonContinuarHandler = new BotonContinuarCasoHandler(this , sceneCaso, stage);
        super.setOnAction(botonContinuarHandler);
    }
}
