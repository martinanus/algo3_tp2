package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.controlador.BotonCrimenHandler;
import edu.fiuba.algo3.controlador.BotonVerHandler;
import edu.fiuba.algo3.modelo.AlgoThief;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class ButtonCrime extends Button {

    public ButtonCrime(VBox cuadroAccion){
        super.setText("Crimen");
        super.setPrefSize(80,50);
        BotonCrimenHandler botonCrimenHandler = new BotonCrimenHandler(this, cuadroAccion);
        super.setOnAction(botonCrimenHandler);
    }
}
