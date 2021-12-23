package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonContinuarHandler;
import edu.fiuba.algo3.modelo.AlgoThief;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ContenedorRegistro extends VBox {


    public ContenedorRegistro(Stage stage, AlgoThief juego) {
        super();
        this.setAlignment(Pos.CENTER);
        this.setSpacing(15);


        Label nombre = new Label("Ingrese su nombre");
        nombre.setFont(Font.font(20));



        TextField textNombre = new TextField();
        textNombre.setMaxWidth(150);

        Button botonContinuar = new Button();
        botonContinuar.setText("Continuar");
        BotonContinuarHandler botonContinuarHandler = new BotonContinuarHandler( stage, textNombre, nombre, juego);
        botonContinuar.setOnAction(botonContinuarHandler);

        Label descripcionJugador = new Label();
        descripcionJugador.setFont(Font.font(20));

        this.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        this.getChildren().addAll(nombre, textNombre, botonContinuar, descripcionJugador);
    }
}
