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

        //Reloj relojTest = new Reloj(reloj);

        Pista pista = jugador.visitar(banco, reloj );

        //Espero que se incremente 1 hora
        //relojTest.incrementar(1);

        assertEquals("pista banco",pista.mostrar());
        //assertEquals(relojTest.mostrar(), reloj.mostrar());
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
        //Jugador visita por primera vez un banco
        jugador.visitar(banco, reloj );

        //Espero que se incremente 4 hora
        relojTest.incrementar(4);

        //Jugador visita por segunda vez un banco
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

        Ciudad mexico = new Ciudad();
        mexico.agregarEdificio(aeropuerto);
        mexico.agregarEdificio(puerto);

        Rango rango = new Novato();

        Jugador jugador = new Jugador(montreal, rango);
        Reloj reloj = new Reloj();

        Reloj relojTest = new Reloj(reloj);


        jugador.viajar(mexico, reloj );

        relojTest.incrementar(4);
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

        Ciudad mexico = new Ciudad();
        mexico.agregarEdificio(aeropuerto);
        mexico.agregarEdificio(puerto);

        Rango rango = new Novato();

        Jugador jugador = new Jugador(montreal, rango);
        Reloj reloj = new Reloj();
        Reloj relojTest = new Reloj(reloj);


        jugador.viajar(mexico, reloj );
        for (int i = 0; i < 3; i++) {
            jugador.visitar(aeropuerto, reloj ); // (1+2+3 = 6 )
        }
        for (int i = 0; i < 55; i++) {
            jugador.visitar(puerto, reloj ); // 1 + 2 +3*53 = 162
        }
        //El reloj se debería incrementar 172  horas
        relojTest.incrementar(172);

        assertEquals(relojTest.mostrar(), reloj.mostrar());

    }

    @Test
    public void JugadorDuermeYTranscurrenOchoHoras() {

        Ciudad mexico = new Ciudad();

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

        Ciudad mexico = new Ciudad();
        Rango rango = new Novato();
        Jugador jugador = new Jugador(mexico, rango);

        Reloj reloj = new Reloj();
        Reloj relojTest = new Reloj(reloj);

        Cuchillo cuchillo = new Cuchillo();
        jugador.herir(cuchillo, reloj);
        //ladron.herir(cuchillo,jugador)
        // si visita a un edificio no sabes si saldra el ladron o la pista.
        //edificio tiene una demora de visitar,

        //El reloj se debería incrementar 2 horas por primer ataque cuchillo
        relojTest.incrementar(2);

        assertEquals(relojTest.mostrar(), reloj.mostrar());

    }
}
