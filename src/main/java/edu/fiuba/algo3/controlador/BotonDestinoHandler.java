package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.AlgoThief;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

<<<<<<< HEAD:src/main/java/edu/fiuba/algo3/controlador/BotonDestinoHandler.java
public class BotonDestinoHandler implements EventHandler<ActionEvent> {
=======
public class BotonViajeHandler implements EventHandler<ActionEvent> {
    private Label reloj;
>>>>>>> e0c92bca9ca94520415f6e073a6994f61ce1777b:src/main/java/edu/fiuba/algo3/controlador/BotonViajeHandler.java
    private VBox cuadroAccion;
    private AlgoThief juego;
    private String nombreCiudad;

<<<<<<< HEAD:src/main/java/edu/fiuba/algo3/controlador/BotonDestinoHandler.java
    public BotonDestinoHandler(String nombreCiudad, AlgoThief juego) {
=======
    public BotonViajeHandler(String nombreCiudad, Label reloj, AlgoThief juego) {
>>>>>>> e0c92bca9ca94520415f6e073a6994f61ce1777b:src/main/java/edu/fiuba/algo3/controlador/BotonViajeHandler.java
        this.nombreCiudad = nombreCiudad;
        this.juego = juego;
        this.reloj = reloj;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        juego.viajar(nombreCiudad);
        reloj.setText(juego.mostrarReloj());
    }
}
