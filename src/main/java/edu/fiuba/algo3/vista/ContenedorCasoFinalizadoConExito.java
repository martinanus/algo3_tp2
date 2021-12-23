package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonNuevoCasoHandler;
import edu.fiuba.algo3.modelo.AlgoThief;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;

public class ContenedorCasoFinalizadoConExito extends VBox {

    public ContenedorCasoFinalizadoConExito(Stage stage, AlgoThief juego) {
        super();
        this.setAlignment(Pos.CENTER);
        this.setSpacing(40);

        Label titulo = new Label();
        titulo.setText("Misión Cumplida");
        titulo.setFont(Font.font(30));
        titulo.setStyle("-fx-text-fill: black; -fx-font-size: 16px; -fx-border-color: white;");

        Label mensaje = new Label();
        mensaje.setText("Has capturado exitosamente a " + juego.getNombreLadron() + ".");
        mensaje.setFont(Font.font(20));
        mensaje.setStyle("-fx-text-fill: black; -fx-font-size: 16px; -fx-border-color: white;");


        Button botonVolverAJugar = new Button();
        botonVolverAJugar.setText("Siguiente Caso");
        BotonNuevoCasoHandler botonNuevoCasoHandler = new BotonNuevoCasoHandler(stage, juego);
        botonVolverAJugar.setOnAction(botonNuevoCasoHandler);

        File file = new File("imgs/policia_captura_ladron.png");
        BackgroundImage myBI= new BackgroundImage(new Image(file.toURI().toString(),
                640,480,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        this.setBackground(new Background(myBI));

        this.getChildren().addAll(titulo, mensaje, botonVolverAJugar);
        stage.setTitle("Juego - Caso Finalizado");


    }
}
