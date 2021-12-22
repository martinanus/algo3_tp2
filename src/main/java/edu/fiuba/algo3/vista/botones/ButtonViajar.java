package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.controlador.BotonViajarHandler;
import edu.fiuba.algo3.modelo.AlgoThief;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class ButtonViajar extends Button {

    public ButtonViajar(VBox cuadroAccion, AlgoThief juego){
        super.setText("Viajar");
        super.setPrefSize(80,50);
        BotonViajarHandler botonViajarHandler = new BotonViajarHandler(this, cuadroAccion , juego);
        super.setOnAction(botonViajarHandler);
    }
}
