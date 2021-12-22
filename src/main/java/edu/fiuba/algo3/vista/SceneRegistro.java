package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonContinuarHandler;
import edu.fiuba.algo3.modelo.AlgoThief;
import edu.fiuba.algo3.vista.botones.ButtonContinuar;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;

public class SceneRegistro {

    public VBox crearSceneRegistro(Stage stage, AlgoThief juego) {
        Label nombre = new Label("Ingrese su nombre");
        nombre.setFont(Font.font(20));
        TextField textNombre = new TextField();
        textNombre.setMaxWidth(150);

        Button botonContinuar = new ButtonContinuar(stage, textNombre, nombre, juego);

        Label descripcionJugador = new Label();
        descripcionJugador.setFont(Font.font(20));
        VBox cajaNombre = new VBox(nombre, textNombre, botonContinuar, descripcionJugador);
        cajaNombre.setAlignment(Pos.CENTER);


        return cajaNombre;
    }
}
