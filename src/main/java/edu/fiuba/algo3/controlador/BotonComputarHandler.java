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
    private TextField sexoText;
    private TextField hobbyText;
    private TextField cabelloText;
    private TextField señaText;
    private TextField vehiculoText;

    public BotonComputarHandler(VBox cuadroAccion, AlgoThief juego, TextField sexoText, TextField hobbyText, TextField cabelloText, TextField señaText, TextField vehiculoText,
    Label labelFecha, Stage stage) {
        this.cuadroAccion = cuadroAccion;
        this.labelFecha = labelFecha;
        this.stage = stage;
        this.juego = juego;
        this.sexoText = sexoText;
        this.hobbyText = hobbyText;
        this.cabelloText = cabelloText;
        this.señaText = señaText;
        this.vehiculoText = vehiculoText;

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try{
            String sexo = sexoText.getText();
            String seña = señaText.getText();
            String pelo = cabelloText.getText();
            juego.cargarDescripcion(new Descripcion(sexo, hobbyText.getText(),
                    pelo, seña, vehiculoText.getText()));
            juego.generarOrdenDeArresto();
            cuadroAccion.getChildren().clear();
            Label mensajeOrden = new Label(juego.getMensajeOrden());
            cuadroAccion.getChildren().add(mensajeOrden);
            labelFecha.setText(juego.mostrarReloj());
        }catch( CasoFinalizadoSinExitoError e) {
            ContenedorCasoFinalizado contenedorCasoFinalizado = new ContenedorCasoFinalizado(stage);
            Scene sceneCasoFinalizado = new Scene(contenedorCasoFinalizado, 640, 480);
            stage.setScene(sceneCasoFinalizado);

        }
    }
}
