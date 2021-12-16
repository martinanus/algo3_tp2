package edu.fiuba.algo3.JavaFX;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class BotonViajarHandler implements EventHandler<ActionEvent> {
    private Button miBoton;
    private VBox cuadroAccion;

    public BotonViajarHandler(Button botonVer, VBox cuadroAccion) {
        miBoton = botonVer;
        this.cuadroAccion = cuadroAccion;
    }

    @Override
    public void handle(ActionEvent event) {
        cuadroAccion.getChildren().clear();

        Button botonPais1 = new Button();
        botonPais1.setText("Argentina");
        botonPais1.setPrefSize(200,50);

        Button botonPais2 = new Button();
        botonPais2.setText("Brasil");
        botonPais2.setPrefSize(200,50);

        Button botonPais3 = new Button();
        botonPais3.setText("Marruecos");
        botonPais3.setPrefSize(200,50);

        Button botonPais4 = new Button();
        botonPais4.setText("Indonesia");
        botonPais4.setPrefSize(200,50);

        cuadroAccion.setSpacing(30);

        cuadroAccion.getChildren().add(botonPais1);
        cuadroAccion.getChildren().add(botonPais2);
        cuadroAccion.getChildren().add(botonPais3);
        cuadroAccion.getChildren().add(botonPais4);

    }
}
