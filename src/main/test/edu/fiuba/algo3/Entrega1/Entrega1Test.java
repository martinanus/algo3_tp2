package edu.fiuba.algo3.Entrega1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.interactuable.Interactuable;
import edu.fiuba.algo3.modelo.interactuable.Cuchillo;
import edu.fiuba.algo3.modelo.interactuable.Pista;
import edu.fiuba.algo3.modelo.rango.Novato;
import edu.fiuba.algo3.modelo.rango.Rango;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Entrega1Test {

    @Test
    public void PoliciaNovatoEntraAUnBancoEnMontrealYRecibeUnaPista( ) {
        Pista pistaBanco = new Pista("pista banco");
        Pista pistaBiblioteca = new Pista("pista biblioteca");

        Edificio banco = new Edificio(pistaBanco);
        Edificio biblioteca = new Edificio(pistaBiblioteca);

        Ciudad montreal = new Ciudad();
        montreal.agregarEdificio(banco);
        montreal.agregarEdificio(biblioteca);

        Rango rango = new Novato();

        Policia policia = new Policia(montreal, rango);
        Reloj reloj = new Reloj(new Tiempo(168.0)); //hs en 1 semana

        Pista pista = (Pista) policia.visitar(banco,reloj);
        assertEquals("pista banco",pista.mostrar());
        assertEquals(new Tiempo(1), reloj.tiempoTranscurrido());
    }


    @Test
    public void PoliciaNovatoEnMontrealVisitaUnBancoNuevamenteYVisitaUnBiblioteca( ) {
        Pista pistaBanco = new Pista("pista banco");
        Pista pistaBiblioteca = new Pista("pista biblioteca");

        Edificio banco = new Edificio(pistaBanco);
        Edificio biblioteca = new Edificio(pistaBiblioteca);

        Ciudad montreal = new Ciudad();
        montreal.agregarEdificio(banco);
        montreal.agregarEdificio(biblioteca);


        Policia policia = new Policia(montreal);
        Reloj reloj = new Reloj(new Tiempo(168.0)); //hs en 1 semana


        //Jugador visita por primera vez un banco
        policia.visitar(banco, reloj );

        policia.visitar(banco, reloj );
        policia.visitar(biblioteca, reloj );
        //Jugador visita por segunda vez un banco
        assertEquals(new Tiempo(4), reloj.tiempoTranscurrido());
    }

    @Test
    public void PoliciaViajaDeMontrealAMexico() {
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

        Policia policia = new Policia(montreal, rango);
        Reloj reloj = new Reloj(new Tiempo(168.0)); //hs en 1 semana



        policia.viajar(mexico, reloj );


        assertEquals(new Tiempo(4), reloj.tiempoTranscurrido());
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

        Policia policia = new Policia(montreal, rango);
        Reloj reloj = new Reloj(new Tiempo(168.0)); //hs en 1 semana



        policia.viajar(mexico, reloj );
        for (int i = 0; i < 3; i++) {
            policia.visitar(aeropuerto, reloj ); // (1+2+3 = 6 )
        }
        for (int i = 0; i < 55; i++) {
            policia.visitar(puerto, reloj ); // 1 + 2 +3*53 = 162
        }

        assertEquals(new Tiempo(172 /* 162+6 + viaje*/ ), reloj.tiempoTranscurrido());

    }

    @Test
    public void PoliciaDuermeYTranscurrenOchoHoras() {

        Ciudad mexico = new Ciudad();

        Rango rango = new Novato();

        Policia policia = new Policia(mexico, rango);
        Reloj reloj = new Reloj(new Tiempo(168.0)); //hs en 1 semana


        policia.duerme(reloj);


        assertEquals(new Tiempo(8), reloj.tiempoTranscurrido());

    }

    @Test
    public void PoliciaSufreHeridaDeCuchillo() {
        Cuchillo cuchillo = new Cuchillo();

        Edificio banco = new Edificio(cuchillo);

        Ciudad montreal = new Ciudad();
        montreal.agregarEdificio(banco);

        Rango rango = new Novato();

        Policia policia = new Policia(montreal, rango);
        Reloj reloj = new Reloj(new Tiempo(168.0)); //hs en 1 semana

        policia.visitar(banco,reloj);
        assertEquals(new Tiempo(3), reloj.tiempoTranscurrido());
    }

}