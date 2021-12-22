package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.CasoFinalizadoSinExitoError;
import edu.fiuba.algo3.modelo.AlgoThief;
import edu.fiuba.algo3.vista.ContenedorCasoFinalizado;
import edu.fiuba.algo3.vista.ContenedorPantallaInicio;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;


public class BotonDestinoHandler implements EventHandler<ActionEvent> {

    private Label relojLabel;
    private Label ciudadLabel;
    private AlgoThief juego;
    private VBox cuadroAccion;
    private String nombreCiudad;
    private StackPane imagenPane;
    private Stage stage;


    public BotonDestinoHandler(String nombreCiudad, AlgoThief juego, Label relojLabel, Label ciudadLabel, VBox cuadroAccion, StackPane imagenPane, Stage stage) {
        this.nombreCiudad = nombreCiudad;
        this.juego = juego;
        this.relojLabel = relojLabel;
        this.ciudadLabel = ciudadLabel;
        this.cuadroAccion = cuadroAccion;
        this.imagenPane = imagenPane;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        try{
            juego.viajar(nombreCiudad);
        }catch( CasoFinalizadoSinExitoError e) {
            ContenedorCasoFinalizado contenedorCasoFinalizado = new ContenedorCasoFinalizado(stage, juego, "Mision Fallida");
            Scene sceneCasoFinalizado = new Scene(contenedorCasoFinalizado, 640, 480);
            stage.setScene(sceneCasoFinalizado);

        }




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
