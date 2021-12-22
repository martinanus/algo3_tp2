package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonContinuarCasoHandler;

import edu.fiuba.algo3.modelo.AlgoThief;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ContenedorCaso extends VBox {



    public ContenedorCaso(Stage stage, AlgoThief juego) {
        super();
        this.setAlignment(Pos.CENTER);


        Label descripcionCaso = new Label();
        descripcionCaso.setFont(Font.font(14));
        descripcionCaso.setText(juego.descripcionCaso());

        ContenedorCiudad contenedorCiudad = new ContenedorCiudad(juego);
        Scene sceneCiudad = new Scene(contenedorCiudad, 640, 480);


        Button botonContinuar = new Button();
        botonContinuar.setText("Continuar");
        BotonContinuarCasoHandler botonContinuarHandler = new BotonContinuarCasoHandler(sceneCiudad, stage);
        botonContinuar.setOnAction(botonContinuarHandler);


        this.getChildren().addAll(descripcionCaso, botonContinuar);




    }
}
