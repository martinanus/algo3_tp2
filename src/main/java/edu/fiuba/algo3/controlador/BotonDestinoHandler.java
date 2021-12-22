package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.AlgoThief;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


public class BotonDestinoHandler implements EventHandler<ActionEvent> {

    private Label relojLabel;
    private Label ciudadLabel;
    private AlgoThief juego;
    private VBox cuadroAccion;
    private String nombreCiudad;


    public BotonDestinoHandler(String nombreCiudad, AlgoThief juego, Label relojLabel, Label ciudadLabel, VBox cuadroAccion) {
        this.nombreCiudad = nombreCiudad;
        this.juego = juego;
        this.relojLabel = relojLabel;
        this.ciudadLabel = ciudadLabel;
        this.cuadroAccion = cuadroAccion;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        juego.viajar(nombreCiudad);
        relojLabel.setText(juego.mostrarReloj());
        ciudadLabel.setText(juego.mostrarCiudadActual());

        cuadroAccion.getChildren().clear();
        Label descrPais = new Label();
        descrPais.setText(juego.descripcionCiudad());
        descrPais.setFont(Font.font(14));
        cuadroAccion.getChildren().add(descrPais);


    }
}
