package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.controlador.BotonVerHandler;
import edu.fiuba.algo3.modelo.AlgoThief;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class ButtonVer extends Button {

    public ButtonVer(VBox cuadroAccion, AlgoThief juego){
        super.setText("Ver");
        super.setPrefSize(80,50);
        BotonVerHandler botonVerHandler = new BotonVerHandler(this, cuadroAccion, juego);
        super.setOnAction(botonVerHandler);
    }
}
