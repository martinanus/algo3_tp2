package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.AlgoThief;
import edu.fiuba.algo3.modelo.CasoFinalizadoSinExitoError;
import edu.fiuba.algo3.modelo.Descripcion;
import edu.fiuba.algo3.vista.ContenedorCasoFinalizado;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BotonComputarHandler implements EventHandler<ActionEvent> {


    private VBox cuadroAccion;
    private AlgoThief juego;
    private Label labelFecha;
    private Stage stage;
    private ComboBox<String> comboSexo;
    private ComboBox<String> comboHobby;
    private ComboBox<String> comboCabello;
    private ComboBox<String> comboSeña;
    private ComboBox<String> comboVehiculo;

    public BotonComputarHandler(VBox cuadroAccion, AlgoThief juego, ComboBox<String> comboSexo, ComboBox<String> comboHobby, ComboBox<String> comboCabello, ComboBox<String> comboSeña, ComboBox<String> comboVehiculo, Label labelFecha, Stage stage) {
        this.cuadroAccion = cuadroAccion;
        this.labelFecha = labelFecha;
        this.stage = stage;
        this.juego = juego;
        this.comboSexo = comboSexo;
        this.comboHobby = comboHobby;
        this.comboCabello = comboCabello;
        this.comboSeña = comboSeña;
        this.comboVehiculo = comboVehiculo;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try{
            String sexo = (String) comboSexo.getValue();
            String hobby = (String) comboHobby.getValue();
            String cabello = (String) comboCabello.getValue();
            String seña = (String) comboSeña.getValue();
            String vehiculo = (String) comboVehiculo.getValue();
            juego.cargarDescripcion(new Descripcion(sexo, hobby , cabello, seña, vehiculo));
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
