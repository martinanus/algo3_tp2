package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonInicioHandler;
import edu.fiuba.algo3.controlador.BotonVolverAJugarHandler;
import edu.fiuba.algo3.modelo.AlgoThief;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ContenedorCasoFinalizado extends VBox {
    public ContenedorCasoFinalizado(Stage stage, AlgoThief juego, String mensaje) {
        super();
        this.setAlignment(Pos.CENTER);
        this.setSpacing(40);

        Label titulo = new Label();
        titulo.setText(mensaje);
        titulo.setFont(Font.font(30));


        Button botonVolverAJugar = new Button();
        botonVolverAJugar.setText("Nuevo Caso");
        BotonVolverAJugarHandler botonVolverAJugarHandler = new BotonVolverAJugarHandler(stage, juego);
        botonVolverAJugar.setOnAction(botonVolverAJugarHandler);

        this.getChildren().addAll(titulo, botonVolverAJugar);
        stage.setTitle("Juego - Caso Finalizado");


    }

}
