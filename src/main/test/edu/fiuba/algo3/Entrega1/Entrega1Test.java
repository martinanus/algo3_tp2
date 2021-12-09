package edu.fiuba.algo3.Entrega1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Interactuable.Interactuable;
import edu.fiuba.algo3.modelo.Interactuable.Cuchillo;
import edu.fiuba.algo3.modelo.Interactuable.Pista;
import edu.fiuba.algo3.modelo.rango.Novato;
import edu.fiuba.algo3.modelo.rango.Rango;
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
        Pista pista = (Pista) policia.visitar(banco,reloj);
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

        policia.visitar(banco, reloj );
        policia.visitar(biblioteca, reloj );
        //Jugador visita por segunda vez un banco
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
        Edificio puerto = new Edificio(cuchillo);


        Interactuable interactuable = puerto.visitar(reloj);
        interactuable.interactuar(policia,reloj);

        //El reloj se debería incrementar 2 horas por el cuchillo mas 1 hora por visita
        assertEquals(new Tiempo(3), reloj.mostrar());

    }
    @Test
    public void ElTiempoTranscurridoDelRelojDeberiaSerMenorQueUnTiempoMasGrande(){
        Reloj reloj = new Reloj(new Tiempo(168.0));
        Tiempo unTiempo = new Tiempo(120);
        reloj.incrementar(unTiempo);
        Tiempo otroTiempo = new Tiempo(188);

        boolean esMayor = reloj.mostrar().esMayor(otroTiempo);

        assertFalse(esMayor);
    }


}