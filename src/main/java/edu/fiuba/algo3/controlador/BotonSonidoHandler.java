package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class BotonSonidoHandler implements EventHandler<ActionEvent> {


    private Stage stage;
    private AudioClip mediaPlayer;
    private Button botonSonido;

    public BotonSonidoHandler(Stage stage, AudioClip mediaPlayer, Button botonSodino) {
        this.stage = stage;
        this.mediaPlayer = mediaPlayer;
        this.botonSonido = botonSodino;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        if(botonSonido.getText() == "Silenciar"){
            mediaPlayer.stop();
            botonSonido.setText("Activar Sonido");
        }else{
            mediaPlayer.play();
            botonSonido.setText("Silenciar");
        }

    }
}
