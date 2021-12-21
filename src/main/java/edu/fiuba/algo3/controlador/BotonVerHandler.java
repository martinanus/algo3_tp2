package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.AlgoThief;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class BotonVerHandler implements EventHandler<ActionEvent> {
    private AlgoThief juego;
    private Button miBoton;
    private VBox cuadroAccion;
    private boolean pulsado;

    public BotonVerHandler(Button botonVer, VBox  cuadroAccion, AlgoThief juego) {
        this.miBoton = botonVer;
        this.cuadroAccion = cuadroAccion;
        this.pulsado = false;
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent event) {

        cuadroAccion.getChildren().clear();


        if(!pulsado){
            Label msjInfo = new Label();
            msjInfo.setText("Ciudades disponibles");
            msjInfo.setFont(Font.font(20));
            cuadroAccion.getChildren().add(msjInfo);

            System.out.println("Desplegar Ciudades \ndisponibles");
            miBoton.setText("Ocultar");
            Label ciudades = new Label();
            ciudades.setText(juego.mostrarCiudadesDisponibles());
            ciudades.setFont(Font.font(16));
            cuadroAccion.getChildren().add(ciudades);

            cuadroAccion.setSpacing(20);
        }else {
            System.out.println("Ocultar Ciudades \ndisponibles");
            miBoton.setText("Ver");
        }

        pulsado = !pulsado;
    }
}
