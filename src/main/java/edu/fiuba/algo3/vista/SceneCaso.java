package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonContinuarCasoHandler;
import edu.fiuba.algo3.controlador.BotonContinuarHandler;
import edu.fiuba.algo3.modelo.AlgoThief;
import edu.fiuba.algo3.vista.botones.ButtonContinuar;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SceneCaso {

    public VBox crearSceneCaso(Stage stage, AlgoThief juego) {
        Button botonContinuar = new ButtonContinuar();
        Label descripcionCaso = new Label();
        descripcionCaso.setFont(Font.font(20));

        SceneCiudad sceneParaCiudad = new SceneCiudad();
        Scene sceneCiudad = new Scene(sceneParaCiudad.crearSceneCiudad(juego), 640, 480);

        BotonContinuarCasoHandler botonContinuarCasoHandler = new BotonContinuarCasoHandler(botonContinuar, sceneCiudad, stage);
        botonContinuar.setOnAction(botonContinuarCasoHandler);

        VBox cajaNombre = new VBox(descripcionCaso, botonContinuar);
        cajaNombre.setAlignment(Pos.CENTER);


        return cajaNombre;
    }
}
