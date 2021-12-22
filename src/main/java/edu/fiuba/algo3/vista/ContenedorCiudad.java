package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.AlgoThief;
import edu.fiuba.algo3.vista.botones.ButtonCrime;
import edu.fiuba.algo3.vista.botones.ButtonPista;
import edu.fiuba.algo3.vista.botones.ButtonVer;
import edu.fiuba.algo3.vista.botones.ButtonViajar;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;

public class ContenedorCiudad extends HBox {

    private Stage stage;

    public ContenedorCiudad(AlgoThief juego) {
        super();
        this.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));


        Label ciudadActual = new Label();
        ciudadActual.setText(juego.ciudadActual());
        ciudadActual.setFont(Font.font(20));
        ciudadActual.setPrefSize(320, 80);
        ciudadActual.setAlignment(Pos.CENTER);

        Label fecha = new Label();
        fecha.setText(juego.mostrarReloj());
        fecha.setFont(Font.font(20));
        fecha.setPrefSize(320, 80);
        fecha.setAlignment(Pos.CENTER);

        VBox cuadroCiudadFecha = new VBox(ciudadActual, fecha);
        cuadroCiudadFecha.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));

        File file = new File("imgs/egipto.jpg");
        Image imagenCiudad = new Image(file.toURI().toString(),
                316,396,false,true);
        StackPane imagenPane = new StackPane(new ImageView(imagenCiudad));
        imagenPane.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));

        cuadroCiudadFecha.setPrefSize(320, 400);

        Label descrPais = new Label();
        descrPais.setText(juego.descripcionCiudad());
        descrPais.setFont(Font.font(14));

        VBox cuadroAccion = new VBox(descrPais);
        cuadroAccion.setAlignment(Pos.CENTER);
        cuadroAccion.setPrefSize(320, 430);
        cuadroAccion.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));


        Button botonVer = new ButtonVer(cuadroAccion, juego);

        Button botonViajar = new ButtonViajar(cuadroAccion);

        Button botonPista = new ButtonPista(cuadroAccion);


        Button botonCrimen = new ButtonCrime(cuadroAccion);

        HBox contenedorBotones = new HBox(botonVer, botonViajar, botonPista, botonCrimen);
        contenedorBotones.setPrefSize(320, 50);
        contenedorBotones.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));

        VBox contenedorPantallaDerecha = new VBox(cuadroAccion, contenedorBotones);
        VBox contenedorPantallaIzquierda = new VBox( cuadroCiudadFecha, imagenPane );


        this.getChildren().addAll(contenedorPantallaIzquierda, contenedorPantallaDerecha);

    }
}
