package edu.fiuba.algo3.Entrega0;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Entrega0Test {
    @Test
    public void JugadorEntraAUnEdificioPorPrimeraVezYRecibeUnaPista( ) {
        String contenido = "El ladron se fue en un auto de cuya bandera tenia colores  amarillo y verde";
        Pista pistaEdificio = new Pista(contenido);

        Edificio edificio = new Edificio(pistaEdificio);
        Ciudad ciudad = new Ciudad();
        ciudad.agregarEdificio(edificio);

        Jugador jugador = new Jugador(ciudad);
        Reloj reloj = new Reloj();

        Pista pista = jugador.visitar(edificio, reloj );

        assertEquals(contenido,pista.mostrar());

    }


}
