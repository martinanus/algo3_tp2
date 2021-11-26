package edu.fiuba.algo3.Entrega1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Entrega1Test {

    @Test
    public void JugadorNovatoEntraAUnBancoEnMontralYRecibeUnaPista( ) {
        String nombreCiudad = "Montreal";
        String contenido = "El ladron se fue en un auto de cuya bandera tenia colores  amarillo y verde";
        Pista pistaEdificio = new Pista(contenido);

        Edificio edificio = new Edificio(pistaEdificio);
        Ciudad ciudad = new Ciudad(edificio, nombreCiudad);
        Rango rango = new Novato();

        Jugador jugador = new Jugador(ciudad, rango);
        Reloj reloj = new Reloj();

        Pista pista = jugador.visitar("Banco", reloj );

        assertEquals(contenido,pista.mostrar());

    }


}
