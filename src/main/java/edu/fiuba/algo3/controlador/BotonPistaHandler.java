package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.AlgoThief;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class BotonPistaHandler implements EventHandler<ActionEvent> {
    private VBox cuadroAccion;
    private AlgoThief juego;
    private Label labelReloj;
    private Stage stage;

    public BotonPistaHandler(VBox cuadroAccion, AlgoThief juego, Label labelReloj, Stage stage) {
        this.cuadroAccion = cuadroAccion;
        this.juego = juego;
        this.labelReloj = labelReloj;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent event) {

        cuadroAccion.getChildren().clear();

        Label pista = new Label();
        pista.setFont(Font.font(16));

        Label msjInfo = new Label();
        msjInfo.setText("¿Qué edificio quiere visitar?");
        msjInfo.setFont(Font.font(20));
        cuadroAccion.getChildren().add(msjInfo);


        Button botonBanco = new Button();
        botonBanco.setText("Banco");
        botonBanco.setPrefSize(200,50);
        BotonEdificioHandler botonBancoHandler = new BotonEdificioHandler(cuadroAccion, juego, "banco", labelReloj, stage);
        botonBanco.setOnAction(botonBancoHandler);



        Button botonBiblioteca = new Button();
        botonBiblioteca.setText("Bibliotecta");
        botonBiblioteca.setPrefSize(200,50);
        BotonEdificioHandler botonBibliotecaHandler = new BotonEdificioHandler(cuadroAccion, juego, "biblioteca", labelReloj, stage);
        botonBiblioteca.setOnAction(botonBibliotecaHandler);


        Button botonPuerto = new Button();
        botonPuerto.setText("Puerto");
        botonPuerto.setPrefSize(200,50);
        BotonEdificioHandler botonPuertoHandler = new BotonEdificioHandler(cuadroAccion, juego, "puerto", labelReloj, stage);
        botonPuerto.setOnAction(botonPuertoHandler);


        cuadroAccion.setSpacing(30);

        cuadroAccion.getChildren().add(botonBanco);
        cuadroAccion.getChildren().add(botonBiblioteca);
        cuadroAccion.getChildren().add(botonPuerto);





    }
}