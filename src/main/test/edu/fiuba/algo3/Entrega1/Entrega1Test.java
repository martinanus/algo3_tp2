package edu.fiuba.algo3.Entrega1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class Entrega1Test {

    @Test
    public void JugadorNovatoEntraAUnBancoEnMontralYRecibeUnaPista( ) {
        Pista pistaBanco = new Pista("pista banco");
        Pista pistaBiblioteca = new Pista("pista biblioteca");

        Edificio banco = new Edificio(pistaBanco);
        Edificio biblioteca = new Edificio(pistaBiblioteca);

        Ciudad montreal = new Ciudad();
        montreal.agregarEdificio(banco);
        montreal.agregarEdificio(biblioteca);

        Rango rango = new Novato();

        Jugador jugador = new Jugador(montreal, rango);
        Reloj reloj = new Reloj();

        Pista pista = jugador.visitar(banco, reloj );

        assertEquals("pista banco",pista.mostrar());
        assertEquals(1, reloj.mostrar());
    }

    @Test
    public void DetectiveNovatoEnMontrealVisitaUnBancoNuevamenteYVisitaUnBiblioteca( ) {
        Pista pistaBanco = new Pista("pista banco");
        Pista pistaBiblioteca = new Pista("pista biblioteca");

        Edificio banco = new Edificio(pistaBanco);
        Edificio biblioteca = new Edificio(pistaBiblioteca);

        Ciudad montreal = new Ciudad();
        montreal.agregarEdificio(banco);
        montreal.agregarEdificio(biblioteca);

        //Rango rango = new Novato();

        Jugador jugador = new Jugador(montreal);
        Reloj reloj = new Reloj();

        jugador.visitar(banco, reloj );
        assertEquals("pista banco", jugador.visitar(banco,reloj).mostrar());
        assertEquals("pista biblioteca", jugador.visitar(biblioteca,reloj).mostrar());
        assertEquals(4, reloj.mostrar());
    }

    @Test
    public void DetectiveviajadeMontrealaMéxico() {
        Pista pistaBanco = new Pista("pista banco");
        Pista pistaBiblioteca = new Pista("pista biblioteca");
        Pista pistaAeropuerto = new Pista("pista aeropuerto");
        Pista pistaPuerto = new Pista("pista puerto");

        Edificio banco = new Edificio(pistaBanco);
        Edificio biblioteca = new Edificio(pistaBiblioteca);
        Edificio aeropuerto = new Edificio(pistaAeropuerto);
        Edificio puerto = new Edificio(pistaAeropuerto);

        Ciudad montreal = new Ciudad();
        montreal.agregarEdificio(banco);
        montreal.agregarEdificio(biblioteca);

        Ciudad mexico = new Ciudad(900.0);
        mexico.agregarEdificio(aeropuerto);
        mexico.agregarEdificio(puerto);

        Rango rango = new Novato();

        Jugador jugador = new Jugador(montreal, rango);
        Reloj reloj = new Reloj();

        jugador.viajar(mexico, reloj );
        assertEquals(1.0, reloj.mostrar());
    }

    @Test
    public void DetectiveviajadeMontrealaMéxicoVisitaAeropuerto3VecesPuerto55Veces() {
        Pista pistaBanco = new Pista("pista banco");
        Pista pistaBiblioteca = new Pista("pista biblioteca");
        Pista pistaAeropuerto = new Pista("pista aeropuerto");
        Pista pistaPuerto = new Pista("pista puerto");

        Edificio banco = new Edificio(pistaBanco);
        Edificio biblioteca = new Edificio(pistaBiblioteca);
        Edificio aeropuerto = new Edificio(pistaAeropuerto);
        Edificio puerto = new Edificio(pistaAeropuerto);

        Ciudad montreal = new Ciudad();
        montreal.agregarEdificio(banco);
        montreal.agregarEdificio(biblioteca);

        Ciudad mexico = new Ciudad(900.0);
        mexico.agregarEdificio(aeropuerto);
        mexico.agregarEdificio(puerto);

        Rango rango = new Novato();

        Jugador jugador = new Jugador(montreal, rango);
        Reloj reloj = new Reloj();

        jugador.viajar(mexico, reloj );
        for (int i = 0; i < 3; i++) {
            jugador.visitar(aeropuerto, reloj );
        }
        for (int i = 0; i < 55; i++) {
            jugador.visitar(puerto, reloj );
        }
        assertEquals(169.0, reloj.mostrar());
    }
}
