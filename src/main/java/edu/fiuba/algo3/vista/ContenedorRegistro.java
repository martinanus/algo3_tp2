package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonContinuarHandler;
import edu.fiuba.algo3.modelo.AlgoThief;
import edu.fiuba.algo3.vista.botones.ButtonContinuar;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ContenedorRegistro extends VBox {

    private Stage stage;

    public ContenedorRegistro(Stage stage, AlgoThief juego) {
        super();
        this.stage = stage;
        this.setAlignment(Pos.CENTER);


        Label nombre = new Label("Ingrese su nombre");
        nombre.setFont(Font.font(20));

        Button botonContinuar = new ButtonContinuar();

        TextField textNombre = new TextField();
        textNombre.setMaxWidth(150);

        Label descripcionJugador = new Label();
        descripcionJugador.setFont(Font.font(20));

        BotonContinuarHandler botonContinuarHandler = new BotonContinuarHandler(botonContinuar, stage, textNombre, nombre, juego);
        botonContinuar.setOnAction(botonContinuarHandler);

        this.getChildren().addAll(nombre, textNombre, botonContinuar, descripcionJugador);
    }
}
