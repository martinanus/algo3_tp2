package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonCerrarHandler;
import edu.fiuba.algo3.controlador.BotonInicioHandler;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;

public class ContenedorPantallaInicio extends VBox{

    public ContenedorPantallaInicio(Stage stage, Scene sceneRegistro) {

        super();
        this.setAlignment(Pos.CENTER);
        this.setSpacing(100);


        Label titulo = new Label();
        titulo.setText("Bienvenido a Algo-Thief");
        titulo.setFont(Font.font(30));
        titulo.setBackground(new Background(new BackgroundFill(Color.rgb(20, 0, 80, 0.9), new CornerRadii(5.0), new Insets(-5.0))));
        titulo.setTextFill(Color.rgb(255, 255, 255, 0.7));


        Button botonInicio = new Button();
        botonInicio.setText("Iniciar Juego");
        BotonInicioHandler botonInicioHandler = new BotonInicioHandler(botonInicio , sceneRegistro, stage);
        botonInicio.setOnAction(botonInicioHandler);


        Button botonCerrar = new Button();
        botonCerrar.setText("Cerrar");
        BotonCerrarHandler botonCerrarHandler = new BotonCerrarHandler( stage);
        botonCerrar.setOnAction(botonCerrarHandler);


        File file = new File("imgs/img_portada.jpg");
        BackgroundImage myBI= new BackgroundImage(new Image(file.toURI().toString(),
                640,480,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        this.setBackground(new Background(myBI));

        HBox layoutBotones = new HBox (botonInicio, botonCerrar);
        layoutBotones.setSpacing(50);
        layoutBotones.setAlignment(Pos.CENTER);


        stage.setTitle("Juego - Pantalla Inicio");

        this.getChildren().addAll(titulo, layoutBotones);

    }
}
