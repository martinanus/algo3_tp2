package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.AlgoThief;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.io.File;


public class BotonDestinoHandler implements EventHandler<ActionEvent> {

    private Label relojLabel;
    private Label ciudadLabel;
    private AlgoThief juego;
    private VBox cuadroAccion;
    private String nombreCiudad;
    private StackPane imagenPane;


    public BotonDestinoHandler(String nombreCiudad, AlgoThief juego, Label relojLabel, Label ciudadLabel, VBox cuadroAccion, StackPane imagenPane) {
        this.nombreCiudad = nombreCiudad;
        this.juego = juego;
        this.relojLabel = relojLabel;
        this.ciudadLabel = ciudadLabel;
        this.cuadroAccion = cuadroAccion;
        this.imagenPane = imagenPane;
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

        imagenPane.getChildren().clear();
        File file = new File("imgs/"+ juego.mostrarCiudadActual()  +".jpg");
        Image imagenCiudad = new Image(file.toURI().toString(),
                316,396,false,true);
        imagenPane.getChildren().add(new ImageView(imagenCiudad));


    }
}
