package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.modelo.interactuable.Pista;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EdificioTest {

    @Test
    public void SeCreaUnEdificioConUnaPista() {
        String contenido = "El ladron se fue en un auto de cuya bandera tenia colores  amarillo y verde";
        Pista pistaEdificio = new Pista(contenido);

        Edificio edificio = new Edificio(pistaEdificio);
        Ciudad ciudad = new Ciudad();
        ciudad.agregarEdificio(edificio);

        Policia policia = new Policia(ciudad);

        Tiempo tiempoMaximo = new Tiempo(168.0); //hs en 1 semana
        Reloj reloj = new Reloj(tiempoMaximo);

        Pista pista = (Pista) policia.visitar(edificio, reloj );

        assertEquals(contenido,pista.mostrar());
    }

}
