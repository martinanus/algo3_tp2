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

        Policia policia = new Policia(montreal, rango);
        Reloj reloj = new Reloj(new Tiempo(168.0)); //hs en 1 semana
        /*
        Interactuable interactuable = new Pista();
        Interactuable interactuable = new Ladron();
        Interactuable interactuable = new Arma();
        Interactuable interactuable = policia.visitar(banco, reloj );
        interactuable.interartuar(reloj,this.jugador) ;
        //Ladron  en el metodo interactuar:
        // jugador.arrestar()
        // dentro de la clase jugador tiene el metodo -> arrestar()
        // en el metodo arrestar():
        // estadoOrdenArresto.arrestar();
        */
        Pista pista = policia.visitar(banco,reloj);
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

        Policia policia = new Policia(montreal);
        Reloj reloj = new Reloj(new Tiempo(168.0)); //hs en 1 semana


        //Jugador visita por primera vez un banco
        policia.visitar(banco, reloj );


        //Jugador visita por segunda vez un banco
        assertEquals("pista banco", policia.visitar(banco,reloj).mostrar());
        assertEquals("pista biblioteca", policia.visitar(biblioteca,reloj).mostrar());
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

        Policia policia = new Policia(montreal, rango);
        Reloj reloj = new Reloj(new Tiempo(168.0)); //hs en 1 semana



        policia.viajar(mexico, reloj );


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

        Policia policia = new Policia(montreal, rango);
        Reloj reloj = new Reloj(new Tiempo(168.0)); //hs en 1 semana



        policia.viajar(mexico, reloj );
        for (int i = 0; i < 3; i++) {
            policia.visitar(aeropuerto, reloj ); // (1+2+3 = 6 )
        }
        for (int i = 0; i < 55; i++) {
            policia.visitar(puerto, reloj ); // 1 + 2 +3*53 = 162
        }

        assertEquals(new Tiempo(172), reloj.mostrar());

    }

    @Test
    public void JugadorDuermeYTranscurrenOchoHoras() {

        Ciudad mexico = new Ciudad();

        Rango rango = new Novato();

        Policia policia = new Policia(mexico, rango);
        Reloj reloj = new Reloj(new Tiempo(168.0)); //hs en 1 semana


        policia.duerme(reloj);


        assertEquals(new Tiempo(8), reloj.mostrar());

    }


    @Test
    public void JugadorSufreHeridaDeCuchillo() {

        Ciudad mexico = new Ciudad();
        Rango rango = new Novato();
        Policia policia = new Policia(mexico, rango);

        Reloj reloj = new Reloj(new Tiempo(168.0)); //hs en 1 semana


        Cuchillo cuchillo = new Cuchillo();
        policia.herir(cuchillo, reloj);
        //ladron.herir(cuchillo,jugador)
        // si visita a un edificio no sabes si saldra el ladron o la pista.
        //edificio tiene una demora de visitar,

        //El reloj se debería incrementar 2 horas por primer ataque cuchillo


        assertEquals(new Tiempo(2), reloj.mostrar());

    }
    @Test
    public void ElTiempoTranscurridoDelRelojDeberiaSerMenorQueUnTiempoMasGrande(){
        Reloj reloj = new Reloj(new Tiempo(168.0));
        Tiempo unTiempo = new Tiempo(120);
        reloj.incrementar(unTiempo);
        Tiempo otroTiempo = new Tiempo(188);
        boolean esMayor = reloj.mostrar().esMayor(otroTiempo);
        assertEquals(false,esMayor);
    }


}