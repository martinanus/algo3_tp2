package edu.fiuba.algo3.JavaFX;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class BotonPistaHandler implements EventHandler<ActionEvent> {
    private Button miBoton;
    private VBox cuadroAccion;

    public BotonPistaHandler(Button botonVer, VBox cuadroAccion) {
        miBoton = botonVer;
        this.cuadroAccion = cuadroAccion;
    }

    @Override
    public void handle(ActionEvent event) {

        cuadroAccion.getChildren().clear();
        Label pista = new Label();
        pista.setText("El ladrón se fue caminando...\nNo puede estar muy lejos ");
        pista.setFont(Font.font(16));
        cuadroAccion.getChildren().add(pista);
    }
}