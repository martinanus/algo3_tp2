package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.AlgoThief;
import edu.fiuba.algo3.modelo.Policia;
import edu.fiuba.algo3.modelo.rango.Detective;
import edu.fiuba.algo3.modelo.rango.Novato;
import edu.fiuba.algo3.modelo.rango.Sargento;
import edu.fiuba.algo3.vista.ContenedorCaso;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BotonContinuarHandler implements EventHandler<ActionEvent> {

    private Stage miStage;
    private Label label;
    private TextField textField;
    private AlgoThief juego;

    public BotonContinuarHandler( Stage stage, TextField textoNombre, Label label, AlgoThief juego) {
        this.textField = textoNombre;
        this.label = label;
        this.miStage = stage;
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (this.textField.getText().trim().equals("")) {
            this.label.setText("Debe Ingresar un nombre");
            this.label.setTextFill(Color.RED);
            this.textField.requestFocus();

        } else {
            Policia policia = new Policia(textField.getText(), new Novato());
            juego.setPolicia(policia);
            juego.generarPartida();
            ContenedorCaso contenedorCaso = new ContenedorCaso(miStage, juego);
            Scene sceneCaso = new Scene(contenedorCaso, 640, 480);
            miStage.setScene(sceneCaso);
            miStage.setTitle("Juego - Pantalla Caso");
        }

    }
}
