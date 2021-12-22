package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class BotonCrimenHandler implements EventHandler<ActionEvent> {
    private Button miBoton;
    private VBox cuadroAccion;

    public BotonCrimenHandler( VBox cuadroAccion) {
        this.cuadroAccion = cuadroAccion;
    }

    @Override
    public void handle(ActionEvent event) {
        cuadroAccion.getChildren().clear();

        Label msjInfo = new Label();
        msjInfo.setText("Identifique al ladrón!");
        msjInfo.setFont(Font.font(20));
        cuadroAccion.getChildren().add(msjInfo);

        TextField sexoText = new TextField();
        sexoText.setPromptText("Sexo");
        cuadroAccion.getChildren().add(sexoText);

        TextField hobbyText = new TextField();
        hobbyText.setPromptText("Hobby");
        cuadroAccion.getChildren().add(hobbyText);

        TextField cabelloText = new TextField();
        cabelloText.setPromptText("Cabello");
        cuadroAccion.getChildren().add(cabelloText);

        TextField señaText = new TextField();
        señaText.setPromptText("Seña");
        cuadroAccion.getChildren().add(señaText);

        TextField vehiculoText = new TextField();
        vehiculoText.setPromptText("Vehiculo");
        cuadroAccion.getChildren().add(vehiculoText);


        Label msjResultado = new Label();
        msjResultado.setFont(Font.font(18));


        Button botonComputar = new Button();
        botonComputar.setText("COMPUTAR");
        botonComputar.setPrefSize(180,40);
        botonComputar.setOnAction(e-> {
            msjResultado.setText("Computado!");

        });
        cuadroAccion.getChildren().add(botonComputar);
        cuadroAccion.getChildren().add(msjResultado);

        cuadroAccion.setSpacing(25);



    }
}