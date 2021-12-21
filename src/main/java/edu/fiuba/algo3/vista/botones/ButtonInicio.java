package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.controlador.BotonInicioHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ButtonInicio extends Button {

    public ButtonInicio(Scene sceneCiudad, Stage stage){
        super.setText("Iniciar Juego");
        BotonInicioHandler botonInicioHandler = new BotonInicioHandler(this , sceneCiudad, stage);
        super.setOnAction(botonInicioHandler);
    }
}
