package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.AlgoThief;
import edu.fiuba.algo3.modelo.interactuable.Interactuable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class BotonEdificioHandler implements EventHandler<ActionEvent> {


    private VBox cuadroAccion;
    private AlgoThief juego;
    private String tipoEdificio;
    private Label relojLabel;

    public BotonEdificioHandler(VBox cuadroAccion, AlgoThief juego, String tipoEdificio, Label relojLabel) {
        this.cuadroAccion = cuadroAccion;
        this.juego = juego;
        this.tipoEdificio = tipoEdificio;
        this.relojLabel = relojLabel;
    }


    @Override
    public void handle(ActionEvent event) {

        String contenidoEdificio = (juego.visitar(tipoEdificio)).mostrar();
        relojLabel.setText(juego.mostrarReloj());

        cuadroAccion.getChildren().clear();
        Label descrPista = new Label();
        descrPista.setText(contenidoEdificio);
        descrPista.setFont(Font.font(14));
        cuadroAccion.getChildren().add(descrPista);
    }
}
