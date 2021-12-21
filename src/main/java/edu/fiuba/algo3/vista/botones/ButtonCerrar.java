package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.controlador.BotonCerrarHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ButtonCerrar  extends Button {

    public ButtonCerrar(Stage stage){
        super.setText("Cerrar");
        BotonCerrarHandler botonCerrarHandler = new BotonCerrarHandler(this, stage);
        super.setOnAction(botonCerrarHandler);
    }
}
