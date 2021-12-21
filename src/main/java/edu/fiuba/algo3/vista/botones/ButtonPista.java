package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.controlador.BotonPistaHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class ButtonPista extends Button {

    public ButtonPista(VBox cuadroAccion){
        super.setText("Pista");
        super.setPrefSize(80,50);
        BotonPistaHandler botonPistaHandler = new BotonPistaHandler(this, cuadroAccion);
        super.setOnAction(botonPistaHandler);
    }
}
