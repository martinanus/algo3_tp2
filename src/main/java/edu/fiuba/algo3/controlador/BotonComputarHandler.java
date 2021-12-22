package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.AlgoThief;
import edu.fiuba.algo3.modelo.CasoFinalizadoSinExitoError;
import edu.fiuba.algo3.modelo.Descripcion;
import edu.fiuba.algo3.vista.ContenedorCasoFinalizado;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BotonComputarHandler implements EventHandler<ActionEvent> {


    private VBox cuadroAccion;
    private AlgoThief juego;
    private Label labelFecha;
    private Stage stage;
    private Descripcion descripcionLadron;

    public BotonComputarHandler(VBox cuadroAccion, AlgoThief juego, Descripcion descripcionLadron,
                                Label labelFecha, Stage stage) {
        this.cuadroAccion = cuadroAccion;
        this.juego = juego;
        this.labelFecha = labelFecha;
        this.stage = stage;
        this.descripcionLadron = descripcionLadron;

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try{
            juego.cargarDescripcion(descripcionLadron);
            juego.generarOrdenDeArresto();
            cuadroAccion.getChildren().clear();
            Label mensajeOrden = new Label(juego.getMensajeOrden());
            cuadroAccion.getChildren().add(mensajeOrden);
            labelFecha.setText(juego.mostrarReloj());
        }catch( CasoFinalizadoSinExitoError e) {
            ContenedorCasoFinalizado contenedorCasoFinalizado = new ContenedorCasoFinalizado(stage, juego);
            Scene sceneCasoFinalizado = new Scene(contenedorCasoFinalizado, 640, 480);
            stage.setScene(sceneCasoFinalizado);

        }
    }
}
