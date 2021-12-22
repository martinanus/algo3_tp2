package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.AlgoThief;
import edu.fiuba.algo3.modelo.Descripcion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;

public class BotonCrimenHandler implements EventHandler<ActionEvent> {
    private Button miBoton;
    private VBox cuadroAccion;
    private AlgoThief juego;
    private Label labelFecha;
    private Stage stage;

    public BotonCrimenHandler(VBox cuadroAccion, AlgoThief juego, Label labelFecha, Stage stage) {
        this.cuadroAccion = cuadroAccion;
        this.juego = juego;
        this.labelFecha = labelFecha;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent event) {
        cuadroAccion.getChildren().clear();

        Label msjInfo = new Label();
        msjInfo.setText("Identifique al ladrón!");
        msjInfo.setFont(Font.font(20));
        cuadroAccion.getChildren().add(msjInfo);

        ObservableList<String> opcionesSexo = FXCollections.observableArrayList();
        opcionesSexo.addAll("Femenino","Masculino");

        ObservableList<String> opcionesHobby = FXCollections.observableArrayList();
        opcionesHobby.addAll("Tenis","Música","Alpinismo","Paracaidismo","Natación","Croquet");

        ObservableList<String> opcionesCabello = FXCollections.observableArrayList();
        opcionesCabello.addAll("Castaño","Rubio","Rojo","Negro");

        ObservableList<String> opcionesSeña = FXCollections.observableArrayList();
        opcionesSeña.addAll("Anillo","Tatuaje","Cicatriz","Joyas");

        ObservableList<String> opcionesVehiculo = FXCollections.observableArrayList();
        opcionesVehiculo.addAll("Descapotable","Limusina","Deportivo","Moto");

        ComboBox<String> comboSexo = new ComboBox<>(opcionesSexo);
        ComboBox<String> comboHobby = new ComboBox<>(opcionesHobby);
        ComboBox<String> comboCabello = new ComboBox<>(opcionesCabello);
        ComboBox<String> comboSeña = new ComboBox<>(opcionesSeña);
        ComboBox<String> comboVehiculo = new ComboBox<>(opcionesVehiculo);

        cuadroAccion.getChildren().add(new HBox(new Label("Sexo: "), comboSexo));
        cuadroAccion.getChildren().add(new HBox(new Label("Hobby: "),comboHobby));
        cuadroAccion.getChildren().add(new HBox(new Label("Cabello: "),comboCabello));
        cuadroAccion.getChildren().add(new HBox(new Label("Seña: "),comboSeña));
        cuadroAccion.getChildren().add(new HBox(new Label("Vehiculo: "),comboVehiculo));

        Button botonComputar = new Button();
        botonComputar.setText("COMPUTAR");
        botonComputar.setPrefSize(180,40);
        BotonComputarHandler botonComputarHandler = new BotonComputarHandler(cuadroAccion, juego,
                comboSexo, comboHobby, comboCabello, comboSeña, comboVehiculo,
                labelFecha, stage);
        botonComputar.setOnAction(botonComputarHandler);
        cuadroAccion.getChildren().add(botonComputar);
        cuadroAccion.setSpacing(25);
    }
}