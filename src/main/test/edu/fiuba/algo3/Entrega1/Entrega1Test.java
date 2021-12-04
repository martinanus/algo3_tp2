package edu.fiuba.algo3.Entrega1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Entrega1Test {

    @Test
    public void JugadorNovatoEntraAUnBancoEnMontrealYRecibeUnaPista( ) {
        Pista pistaBanco = new Pista("pista banco");
        Pista pistaBiblioteca = new Pista("pista biblioteca");

        Edificio banco = new Edificio(pistaBanco);
        Edificio biblioteca = new Edificio(pistaBiblioteca);

        Ciudad montreal = new Ciudad();
        montreal.agregarEdificio(banco);
        montreal.agregarEdificio(biblioteca);

        Rango rango = new Novato();

        Jugador jugador = new Jugador(montreal, rango);
        Reloj reloj = new Reloj(new Tiempo(168.0)); //hs en 1 semana


        Pista pista = jugador.visitar(banco, reloj );


        assertEquals("pista banco",pista.mostrar());
        assertEquals(new Tiempo(1), reloj.mostrar());
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
        Reloj reloj = new Reloj(new Tiempo(168.0)); //hs en 1 semana


        //Jugador visita por primera vez un banco
        jugador.visitar(banco, reloj );


        //Jugador visita por segunda vez un banco
        assertEquals("pista banco", jugador.visitar(banco,reloj).mostrar());
        assertEquals("pista biblioteca", jugador.visitar(biblioteca,reloj).mostrar());
        assertEquals(new Tiempo(4), reloj.mostrar());
    }

    @Test
    public void JugadorViajaDeMontrealAMexico() {
        Pista pistaBanco = new Pista("pista banco");
        Pista pistaBiblioteca = new Pista("pista biblioteca");
        Pista pistaAeropuerto = new Pista("pista aeropuerto");
        Pista pistaPuerto = new Pista("pista puerto");

        Edificio banco = new Edificio(pistaBanco);
        Edificio biblioteca = new Edificio(pistaBiblioteca);
        Edificio aeropuerto = new Edificio(pistaAeropuerto);
        Edificio puerto = new Edificio(pistaPuerto);

        Ciudad montreal = new Ciudad(new Posicion(45.50861111, -73.58777778));
        montreal.agregarEdificio(banco);
        montreal.agregarEdificio(biblioteca);

        Ciudad mexico = new Ciudad(new Posicion(19.42833333, -99.1275));
        mexico.agregarEdificio(aeropuerto);
        mexico.agregarEdificio(puerto);

        Rango rango = new Novato();

        Jugador jugador = new Jugador(montreal, rango);
        Reloj reloj = new Reloj(new Tiempo(168.0)); //hs en 1 semana



        jugador.viajar(mexico, reloj );


        assertEquals(new Tiempo(4), reloj.mostrar());
    }

    @Test
    public void JugadorViajaDeMontrealAMexicoYVisitaAeropuerto3VecesPuerto55Veces() {
        Pista pistaBanco = new Pista("pista banco");
        Pista pistaBiblioteca = new Pista("pista biblioteca");
        Pista pistaAeropuerto = new Pista("pista aeropuerto");
        Pista pistaPuerto = new Pista("pista puerto");

        Edificio banco = new Edificio(pistaBanco);
        Edificio biblioteca = new Edificio(pistaBiblioteca);
        Edificio aeropuerto = new Edificio(pistaAeropuerto);
        Edificio puerto = new Edificio(pistaPuerto);

        Ciudad montreal = new Ciudad(new Posicion(45.50861111, -73.58777778));
        montreal.agregarEdificio(banco);
        montreal.agregarEdificio(biblioteca);

        Ciudad mexico = new Ciudad(new Posicion(19.42833333, -99.1275));
        mexico.agregarEdificio(aeropuerto);
        mexico.agregarEdificio(puerto);

        Rango rango = new Novato();

        Jugador jugador = new Jugador(montreal, rango);
        Reloj reloj = new Reloj(new Tiempo(168.0)); //hs en 1 semana



        jugador.viajar(mexico, reloj );
        for (int i = 0; i < 3; i++) {
            jugador.visitar(aeropuerto, reloj ); // (1+2+3 = 6 )
        }
        for (int i = 0; i < 55; i++) {
            jugador.visitar(puerto, reloj ); // 1 + 2 +3*53 = 162
        }

        assertEquals(new Tiempo(172), reloj.mostrar());

    }

    @Test
    public void JugadorDuermeYTranscurrenOchoHoras() {

        Ciudad mexico = new Ciudad();

        Rango rango = new Novato();

        Jugador jugador = new Jugador(mexico, rango);
        Reloj reloj = new Reloj(new Tiempo(168.0)); //hs en 1 semana


        jugador.duerme(reloj);


        assertEquals(new Tiempo(8), reloj.mostrar());

    }


    @Test
    public void JugadorSufreHeridaDeCuchillo() {

        Ciudad mexico = new Ciudad();
        Rango rango = new Novato();
        Jugador jugador = new Jugador(mexico, rango);

        Reloj reloj = new Reloj(new Tiempo(168.0)); //hs en 1 semana


        Cuchillo cuchillo = new Cuchillo();
        jugador.herir(cuchillo, reloj);
        //ladron.herir(cuchillo,jugador)
        // si visita a un edificio no sabes si saldra el ladron o la pista.
        //edificio tiene una demora de visitar,

        //El reloj se debería incrementar 2 horas por primer ataque cuchillo


        assertEquals(new Tiempo(2), reloj.mostrar());

    }


}
