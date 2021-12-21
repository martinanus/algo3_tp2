package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.AlgoThief;
import edu.fiuba.algo3.modelo.Policia;
import edu.fiuba.algo3.vista.botones.ButtonCerrar;
import edu.fiuba.algo3.vista.botones.ButtonInicio;
import javafx.geometry.Insets;
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

public class SceneInicial {

    public VBox crearSceneInicial(Scene sceneCiudad, Stage stage, AlgoThief juego) {

        Label titulo = new Label();
        titulo.setText("Bienvenido a Algo-Thief");
        titulo.setFont(Font.font(30));
        titulo.setBackground(new Background(new BackgroundFill(Color.rgb(20, 0, 80, 0.9), new CornerRadii(5.0), new Insets(-5.0))));
        titulo.setTextFill(Color.rgb(255, 255, 255, 0.7));

        /*Label nombre = new Label("Ingrese su nombre");
        nombre.setFont(Font.font(20));
        Button botonContinuar = new Button();
        botonContinuar.setText("Continuar");
        TextField textNombre = new TextField();
        textNombre.setMaxWidth(150);
        Label descripcionJugador = new Label();
        descripcionJugador.setFont(Font.font(20));
        VBox cajaNombre = new VBox(nombre, textNombre, botonContinuar, descripcionJugador);
        cajaNombre.setAlignment(Pos.CENTER);*/

        Button botonInicio = new ButtonInicio(sceneCiudad, stage);


        /*botonContinuar.setOnAction(value ->  {
            juego.setPolicia(new Policia(textNombre.getText()));
            juego.generarPartida();
            descripcionJugador.setText("Hola " + textNombre.getText() + " tienes rango " + juego.mostrarRango());
        });*/

        Button botonCerrar = new ButtonCerrar(stage);

        File file = new File("imgs/img_portada.jpg");
        BackgroundImage myBI= new BackgroundImage(new Image(file.toURI().toString(),
                640,480,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        HBox layoutBotones = new HBox (botonInicio, botonCerrar);
        layoutBotones.setSpacing(50);
        layoutBotones.setAlignment(Pos.CENTER);

        //VBox layout = new VBox( titulo, cajaNombre, layoutBotones);
        VBox layout = new VBox( titulo, layoutBotones);
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(100);
        layout.setBackground(new Background(myBI));

        stage.setTitle("Juego - Pantalla Inicio");

        return layout;
    }
}
