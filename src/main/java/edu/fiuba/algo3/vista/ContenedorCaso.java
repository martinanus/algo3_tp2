package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonContinuarCasoHandler;
import edu.fiuba.algo3.controlador.BotonContinuarHandler;
import edu.fiuba.algo3.modelo.AlgoThief;
import edu.fiuba.algo3.vista.botones.ButtonContinuar;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ContenedorCaso extends VBox {

    private Stage stage;


    public ContenedorCaso(Stage stage, AlgoThief juego) {
        super();
        this.stage = stage;
        this.setAlignment(Pos.CENTER);

        Button botonContinuar = new ButtonContinuar();
        Label descripcionCaso = new Label();
        descripcionCaso.setFont(Font.font(20));

        ContenedorCiudad contenedorCiudad = new ContenedorCiudad(juego);

        Scene sceneCiudad = new Scene(contenedorCiudad, 640, 480);


        BotonContinuarCasoHandler botonContinuarCasoHandler = new BotonContinuarCasoHandler(botonContinuar, sceneCiudad, stage);
        botonContinuar.setOnAction(botonContinuarCasoHandler);

        this.getChildren().addAll(descripcionCaso, botonContinuar);




    }
}
