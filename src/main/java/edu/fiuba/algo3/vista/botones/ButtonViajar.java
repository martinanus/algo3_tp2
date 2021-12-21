package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.controlador.BotonViajarHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class ButtonViajar extends Button {

    public ButtonViajar(VBox cuadroAccion){
        super.setText("Viajar");
        super.setPrefSize(80,50);
        BotonViajarHandler botonViajarHandler = new BotonViajarHandler(this, cuadroAccion);
        super.setOnAction(botonViajarHandler);
    }
}
