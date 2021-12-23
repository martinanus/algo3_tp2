package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonNuevoCasoHandler;
import edu.fiuba.algo3.modelo.AlgoThief;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ContenedorCasoFinalizadoSinExito extends VBox {
    public ContenedorCasoFinalizadoSinExito(Stage stage, AlgoThief juego, String mensaje) {
        super();
        this.setAlignment(Pos.CENTER);
        this.setSpacing(40);

        Label titulo = new Label();
        titulo.setText(mensaje);
        titulo.setFont(Font.font(30));


        Button botonVolverAJugar = new Button();
        botonVolverAJugar.setText("Volver a Jugar");
        BotonNuevoCasoHandler botonNuevoCasoHandler = new BotonNuevoCasoHandler(stage, juego);
        botonVolverAJugar.setOnAction(botonNuevoCasoHandler);

        this.getChildren().addAll(titulo, botonVolverAJugar);
        stage.setTitle("Juego - Caso Finalizado");


    }

}
