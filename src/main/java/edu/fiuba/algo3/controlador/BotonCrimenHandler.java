package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.AlgoThief;
import edu.fiuba.algo3.modelo.Descripcion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class BotonCrimenHandler implements EventHandler<ActionEvent> {
    private Button miBoton;
    private VBox cuadroAccion;
    private AlgoThief juego;
    private Label labelFecha;
    private Stage stage;

    public BotonCrimenHandler(VBox cuadroAccion, AlgoThief juego, Label labelFecha, Stage stage) {
        this.cuadroAccion = cuadroAccion;
        this.juego = juego;
        this.labelFecha = labelFecha;
        this.stage = stage;
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


        Button botonComputar = new Button();
        botonComputar.setText("COMPUTAR");
        botonComputar.setPrefSize(180,40);
        BotonComputarHandler botonComputarHandler = new BotonComputarHandler(cuadroAccion, juego,
                sexoText, hobbyText, cabelloText, señaText, vehiculoText,
                labelFecha, stage);
        botonComputar.setOnAction(botonComputarHandler);
        cuadroAccion.getChildren().add(botonComputar);
        cuadroAccion.setSpacing(25);





    }
}