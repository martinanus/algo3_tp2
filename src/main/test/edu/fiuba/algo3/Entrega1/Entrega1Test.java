package edu.fiuba.algo3.Entrega1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

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

        Reloj relojTest = new Reloj(reloj);

        Pista pista = jugador.visitar(banco, reloj );


        //Espero que se incremente 1 hora
        relojTest.incrementar(1);

        assertEquals("pista banco",pista.mostrar());
        assertEquals(relojTest.mostrar(), reloj.mostrar());
    }

    @Test
    public void JugadorNovatoEnMontrealVisitaUnBancoNuevamenteYVisitaUnBiblioteca( ) {
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

        Reloj relojTest = new Reloj(reloj);

        jugador.visitar(banco, reloj );

        //Espero que se incremente 4 hora
        relojTest.incrementar(4);


        assertEquals("pista banco", jugador.visitar(banco,reloj).mostrar());
        assertEquals("pista biblioteca", jugador.visitar(biblioteca,reloj).mostrar());
        assertEquals(relojTest.mostrar(), reloj.mostrar());
    }

    @Test
    public void JugadorViajadeMontrealaMéxico() {
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

        Reloj relojTest = new Reloj(reloj);


        jugador.viajar(mexico, reloj );

        relojTest.incrementar(1);
        assertEquals(relojTest.mostrar(), reloj.mostrar());
    }

    @Test
    public void JugadorViajadeMontrealaMéxicoVisitaAeropuerto3VecesPuerto55Veces() {
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
        Reloj relojTest = new Reloj(reloj);


        jugador.viajar(mexico, reloj );
        for (int i = 0; i < 3; i++) {
            jugador.visitar(aeropuerto, reloj );
        }
        for (int i = 0; i < 55; i++) {
            jugador.visitar(puerto, reloj );
        }

        //El reloj se debería incrementar 169 horas
        relojTest.incrementar(169);

        assertEquals(relojTest.mostrar(), reloj.mostrar());

    }

    @Test
    public void JugadorDuermeYTranscurrenOchoHoras() {

        Ciudad mexico = new Ciudad(900.0);

        Rango rango = new Novato();

        Jugador jugador = new Jugador(mexico, rango);
        Reloj reloj = new Reloj();
        Reloj relojTest = new Reloj(reloj);

        jugador.duerme(reloj);


        //El reloj se debería incrementar 8 horas al dormir
        relojTest.incrementar(8);

        assertEquals(relojTest.mostrar(), reloj.mostrar());

    }


    @Test
    public void JugadorSufreHeridaDeCuchillo() {

        Ciudad mexico = new Ciudad(900.0);
        Rango rango = new Novato();
        Jugador jugador = new Jugador(mexico, rango);

        Reloj reloj = new Reloj();
        Reloj relojTest = new Reloj(reloj);

        Cuchillo cuchillo = new Cuchillo();
        jugador.herir(cuchillo, reloj);


        //El reloj se debería incrementar 2 horas por primer ataque cuchillo
        relojTest.incrementar(2);

        assertEquals(relojTest.mostrar(), reloj.mostrar());

    }
}
