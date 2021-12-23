package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.AlgoThief;
import edu.fiuba.algo3.modelo.CasoFinalizadoSinExitoError;
import edu.fiuba.algo3.vista.ContenedorCasoFinalizadoConExito;
import edu.fiuba.algo3.vista.ContenedorCasoFinalizadoSinExito;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class BotonEdificioHandler implements EventHandler<ActionEvent> {


    private VBox cuadroAccion;
    private AlgoThief juego;
    private String tipoEdificio;
    private Label relojLabel;
    private Stage stage;

    public BotonEdificioHandler(VBox cuadroAccion, AlgoThief juego, String tipoEdificio, Label relojLabel, Stage stage) {
        this.cuadroAccion = cuadroAccion;
        this.juego = juego;
        this.tipoEdificio = tipoEdificio;
        this.relojLabel = relojLabel;
        this.stage = stage;
    }


    @Override
    public void handle(ActionEvent event) {
        String contenidoEdificio = "";
        try{
            contenidoEdificio = (juego.visitar(tipoEdificio)).mostrar();
            cuadroAccion.getChildren().clear();
            Label descrPista = new Label();
            descrPista.setText(contenidoEdificio);
            descrPista.setFont(Font.font(14));
            descrPista.setWrapText(true);
            cuadroAccion.getChildren().add(descrPista);
            relojLabel.setText(juego.mostrarReloj());

            if (contenidoEdificio.equals("Has encontrado al ladrón.")) {
                if (juego.getMensajeOrden().equals("No hay suficientes datos del ladrón")) {
                    throw new CasoFinalizadoSinExitoError();
                }
                else {
                    ContenedorCasoFinalizadoConExito contenedorCasoFinalizadoConExito = new ContenedorCasoFinalizadoConExito(stage, juego);
                    Scene sceneCasoFinalizado = new Scene(contenedorCasoFinalizadoConExito, 640, 480);
                    stage.setScene(sceneCasoFinalizado);
                }
            }
        }catch( CasoFinalizadoSinExitoError e) {
            String mensaje = "Mision Fallida";
            ContenedorCasoFinalizadoSinExito contenedorCasoFinalizado = new ContenedorCasoFinalizadoSinExito(stage, juego, mensaje);
            Scene sceneCasoFinalizado = new Scene(contenedorCasoFinalizado, 640, 480);
            stage.setScene(sceneCasoFinalizado);

        }
    }
}
