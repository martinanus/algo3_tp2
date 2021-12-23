package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonContinuarCasoHandler;

import edu.fiuba.algo3.modelo.AlgoThief;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;

public class ContenedorCaso extends VBox {



    public ContenedorCaso(Stage stage, AlgoThief juego) {
        super();
        this.setAlignment(Pos.CENTER);

        VBox caja = new VBox();

        Label descripcionRango = new Label();
        descripcionRango.setText("Tu Rango actual es " + juego.getRangoPolicia());
        descripcionRango.setStyle("-fx-text-fill: white; -fx-font-size: 15px");

        Label descripcionCaso = new Label();
        descripcionCaso.setFont(Font.font(14));
        descripcionCaso.setText(juego.descripcionCaso());
        descripcionCaso.setStyle("-fx-text-fill: white; -fx-font-size: 15px");
        descripcionCaso.setWrapText(true);

        ContenedorCiudad contenedorCiudad = new ContenedorCiudad(juego, stage);
        Scene sceneCiudad = new Scene(contenedorCiudad, 640, 480);


        Button botonContinuar = new Button();
        botonContinuar.setText("Continuar");
        BotonContinuarCasoHandler botonContinuarHandler = new BotonContinuarCasoHandler(sceneCiudad, stage);
        botonContinuar.setOnAction(botonContinuarHandler);

        caja.getChildren().addAll(descripcionRango, descripcionCaso, botonContinuar);
        caja.setAlignment(Pos.CENTER);
        caja.setPadding(new Insets(10,10,10, 10));
        caja.setSpacing(2);

        File file = new File("imgs/interpol.jpeg");
        BackgroundImage myBI= new BackgroundImage(new Image(file.toURI().toString(),
                640,480,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        this.setBackground(new Background(myBI));


        this.getChildren().addAll(caja);
        this.setAlignment(Pos.BOTTOM_CENTER);




    }
}
