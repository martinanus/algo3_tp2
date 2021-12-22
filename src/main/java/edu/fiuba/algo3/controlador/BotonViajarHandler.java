package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.AlgoThief;
import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.vista.botones.ButtonViaje;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.io.File;

public class BotonViajarHandler implements EventHandler<ActionEvent> {

    private Label labelReloj;
    private Label labelCiudad;
    private VBox cuadroAccion;
    private AlgoThief juego;
    private  StackPane imagenPane;

    public BotonViajarHandler(VBox cuadroAccion, Label labelReloj, AlgoThief juego, Label labelCiudad, StackPane imagenPane) {

        this.cuadroAccion = cuadroAccion;
        this.juego = juego;
        this.labelReloj = labelReloj;
        this.labelCiudad = labelCiudad;
        this.imagenPane = imagenPane;
    }

    @Override
    public void handle(ActionEvent event) {
        cuadroAccion.getChildren().clear();
        String nombreCiudad;

        for(Ciudad ciudad: juego.mostrarCiudadesDestino()){
            Button botonViaje = new ButtonViaje();
            nombreCiudad = ciudad.getNombre();
            botonViaje.setText(nombreCiudad);
            botonViaje.setPrefSize(200,50);
            cuadroAccion.setSpacing(30);
            BotonDestinoHandler botonDestinoHandler = new BotonDestinoHandler(nombreCiudad, juego, labelReloj, labelCiudad, cuadroAccion, imagenPane);
            botonViaje.setOnAction(botonDestinoHandler);
            cuadroAccion.getChildren().add(botonViaje);
        }








    }
}
