package edu.fiuba.algo3.JavaFX;

import edu.fiuba.algo3.modelo.AlgoThief;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;

/**
 * JavaFX App
 */
public class InicioFX extends Application {


    @Override
    public void start(Stage stage) {
        AlgoThief juego = new AlgoThief();
        juego.generarPartida();

        Scene sceneCiudad = crearSceneCiudad(juego);

        Scene sceneInicial = crearSceneInicial(sceneCiudad, stage, juego);

        stage.setScene(sceneInicial);
        stage.setResizable(false);
        stage.show();

    }

    private Scene crearSceneInicial(Scene sceneCiudad, Stage stage, AlgoThief juego) {

        Label titulo = new Label();
        titulo.setText("Bienvenido a Algo-Thief");
        titulo.setFont(Font.font(30));
        titulo.setBackground(new Background(new BackgroundFill(Color.rgb(20, 0, 80, 0.9), new CornerRadii(5.0), new Insets(-5.0))));
        titulo.setTextFill(Color.rgb(255, 255, 255, 0.7));

        Label nombre = new Label("Ingrese su nombre");
        nombre.setFont(Font.font(20));
        Button botonContinuar = new Button();
        botonContinuar.setText("Continuar");
        TextField textNombre = new TextField();
        textNombre.setMaxWidth(150);
        Label descripcionJugador = new Label();
        descripcionJugador.setFont(Font.font(20));
        VBox cajaNombre = new VBox(nombre, textNombre, botonContinuar, descripcionJugador);
        cajaNombre.setAlignment(Pos.CENTER);

        Button botonInicio = new Button();
        botonInicio.setText("Iniciar Juego");
        BotonInicioHandler botonInicioHandler = new BotonInicioHandler(botonInicio, sceneCiudad, stage);
        botonInicio.setOnAction(botonInicioHandler);

        botonContinuar.setOnAction(value ->  {
            juego.setNombreJugador(textNombre.getText());
            descripcionJugador.setText("Hola " + textNombre.getText() + " tienes rango " + juego.mostrarRango());
        });

        Button botonCerrar = new Button();
        botonCerrar.setText("Cerrar");
        BotonCerrarHandler botonCerrarHandler = new BotonCerrarHandler(botonCerrar, stage);
        botonCerrar.setOnAction(botonCerrarHandler);


        File file = new File("imgs/img_portada.jpg");
        BackgroundImage myBI= new BackgroundImage(new Image(file.toURI().toString(),
        640,480,false,true),
              BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
            BackgroundSize.DEFAULT);

        HBox layoutBotones = new HBox (botonInicio, botonCerrar);
        layoutBotones.setSpacing(50);
        layoutBotones.setAlignment(Pos.CENTER);

        VBox layout = new VBox( titulo, cajaNombre, layoutBotones);
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(100);
        layout.setBackground(new Background(myBI));

        stage.setTitle("Juego - Pantalla Inicio");

        return new Scene(layout , 640, 480);
    }


    private Scene crearSceneCiudad(AlgoThief juego) {
        Label ciudadActual = new Label();
        ciudadActual.setText(juego.ciudadActual());
        ciudadActual.setFont(Font.font(20));
        ciudadActual.setPrefSize(320, 80);
        ciudadActual.setAlignment(Pos.CENTER);

        Label fecha = new Label();
        fecha.setText(juego.mostrarReloj());
        fecha.setFont(Font.font(20));
        fecha.setPrefSize(320, 80);
        fecha.setAlignment(Pos.CENTER);

        VBox cuadroCiudadFecha = new VBox(ciudadActual, fecha);
        cuadroCiudadFecha.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));

        File file = new File(juego.pathImagenCiudad());
        Image imagenCiudad = new Image(file.toURI().toString(),
                316,396,false,true);
        StackPane imagenPane = new StackPane(new ImageView(imagenCiudad));
        imagenPane.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));

        cuadroCiudadFecha.setPrefSize(320, 400);

        Label descrPais = new Label();
        descrPais.setText(juego.descripcionCiudad());
        descrPais.setFont(Font.font(14));

        VBox cuadroAccion = new VBox(descrPais);
        cuadroAccion.setAlignment(Pos.CENTER);
        cuadroAccion.setPrefSize(320, 430);
        cuadroAccion.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));



        Button botonVer = new Button();
        botonVer.setText("Ver");
        botonVer.setPrefSize(80,50);
        BotonVerHandler botonVerHandler = new BotonVerHandler(botonVer, cuadroAccion, juego);
        botonVer.setOnAction(botonVerHandler);

        Button botonViajar = new Button();
        botonViajar.setText("Viajar");
        botonViajar.setPrefSize(80,50);
        BotonViajarHandler botonViajarHandler = new BotonViajarHandler(botonViajar, cuadroAccion);
        botonViajar.setOnAction(botonViajarHandler);

        Button botonPista = new Button();
        botonPista.setText("Pista");
        botonPista.setPrefSize(80,50);
        BotonPistaHandler botonPistaHandler = new BotonPistaHandler(botonPista, cuadroAccion);
        botonPista.setOnAction(botonPistaHandler);

        Button botonCrimen = new Button();
        botonCrimen.setText("Crimen");
        botonCrimen.setPrefSize(80,50);
        BotonCrimenHandler botonCrimenHandler = new BotonCrimenHandler(botonCrimen, cuadroAccion);
        botonCrimen.setOnAction(botonCrimenHandler);

        HBox contenedorBotones = new HBox(botonVer, botonViajar, botonPista, botonCrimen);
        contenedorBotones.setPrefSize(320, 50);
        contenedorBotones.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));



        VBox contenedorPantallaDerecha = new VBox(cuadroAccion, contenedorBotones);
        VBox contenedorPantallaIzquierda = new VBox( cuadroCiudadFecha, imagenPane );

        HBox contenedorPrincipal = new HBox(contenedorPantallaIzquierda, contenedorPantallaDerecha);
        contenedorPrincipal.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));



        return new Scene(contenedorPrincipal , 640, 480);

    }

    public static void main(String[] args) {
        launch();
    }

}
