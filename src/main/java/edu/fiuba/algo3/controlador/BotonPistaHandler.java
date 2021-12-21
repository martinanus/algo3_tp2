package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class BotonPistaHandler implements EventHandler<ActionEvent> {
    private Button miBoton;
    private VBox cuadroAccion;

    public BotonPistaHandler(Button botonVer, VBox cuadroAccion) {
        miBoton = botonVer;
        this.cuadroAccion = cuadroAccion;
    }

    @Override
    public void handle(ActionEvent event) {

        cuadroAccion.getChildren().clear();

        Label pista = new Label();
        pista.setFont(Font.font(16));

        Label msjInfo = new Label();
        msjInfo.setText("¿Qué edificio quiere visitar?");
        msjInfo.setFont(Font.font(20));
        cuadroAccion.getChildren().add(msjInfo);



        Button edificio1 = new Button();
        edificio1.setText("Banco");
        edificio1.setPrefSize(200,50);
        edificio1.setOnAction(e-> {
            pista.setText("¡Lo he visto! \nSe marchó con una bolsa \nrepleta de Yenes.    ");
            cuadroAccion.getChildren().clear();
            cuadroAccion.getChildren().add(pista);

        });

        Button edificio2 = new Button();
        edificio2.setText("Bibliotecta");
        edificio2.setPrefSize(200,50);
        edificio2.setOnAction(e-> {
            pista.setText("Estuvo consultando muchos \nlibros en japonés.\nQué extraño...");
            cuadroAccion.getChildren().clear();
            cuadroAccion.getChildren().add(pista);

        });


        Button edificio3 = new Button();
        edificio3.setText("Puerto");
        edificio3.setPrefSize(200,50);
        edificio3.setOnAction(e-> {
            pista.setText("Se fue cantando \n\"Al sur yo me voy...\".");
            cuadroAccion.getChildren().clear();
            cuadroAccion.getChildren().add(pista);

        });

        cuadroAccion.setSpacing(30);

        cuadroAccion.getChildren().add(edificio1);
        cuadroAccion.getChildren().add(edificio2);
        cuadroAccion.getChildren().add(edificio3);





    }
}