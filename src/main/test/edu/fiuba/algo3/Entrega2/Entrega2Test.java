package edu.fiuba.algo3.Entrega2;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.interactuable.Cuchillo;
import edu.fiuba.algo3.modelo.interactuable.Ladron;
import edu.fiuba.algo3.modelo.interactuable.Pista;
import edu.fiuba.algo3.modelo.ordenesArresto.OrdenEmitida;
import edu.fiuba.algo3.modelo.ordenesArresto.OrdenNoEmitidadError;
import edu.fiuba.algo3.modelo.rango.Detective;
import edu.fiuba.algo3.modelo.rango.Investigador;
import edu.fiuba.algo3.modelo.rango.Novato;
import edu.fiuba.algo3.modelo.rango.Rango;
import edu.fiuba.algo3.modelo.tiempo.Reloj;
import edu.fiuba.algo3.modelo.tiempo.Tiempo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Entrega2Test {

    @Test
    public void JugadorSufreHeridaDeCuchilloYDuerme() {

        Ciudad mexico = new Ciudad();
        Rango rango = new Novato();
        Policia policia = new Policia(mexico, rango);

        Reloj reloj = new Reloj(new Tiempo(168.0)); //hs en 1 semana no esta claro el timpo max
        Cuchillo cuchillo = new Cuchillo();
        Edificio puerto = new Edificio(cuchillo);
        mexico.agregarEdificio(puerto);
        policia.visitar(puerto,reloj);
        policia.duerme(reloj);

        assertEquals(new Tiempo(11), reloj.tiempoTranscurrido());

    }

    @Test
    public void JugadorConRangoInvestigadorViajaDeMontrealAMexico() {
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

        Rango rango = new Investigador();

        Policia policia = new Policia(montreal, rango);
        Reloj reloj = new Reloj(new Tiempo(168.0)); //hs en 1 semana


        policia.viajar(mexico, reloj );

        assertEquals(new Tiempo(2), reloj.tiempoTranscurrido());
    }

    @Test
    public void SeBuscaEnLaComputadoraUnSospechosoConSexoMasculino() {
        Descripcion descripcion1 = new Descripcion("sospechoso1","masculino","tenis","castaño","tatuaje","moto");
        Ladron sospechoso1 = new Ladron(descripcion1);
        Descripcion descripcion2 = new Descripcion("sospechoso2","femenino","musica","negro","anillo","deportivo");
        Ladron sospechoso2 = new Ladron(descripcion2);
        Descripcion descripcion3 = new Descripcion("sospechoso3","femenino","tenis","negro","tatuaje","moto");
        Ladron sospechoso3 = new Ladron(descripcion3);
        Descripcion descripcion4 = new Descripcion("","masculino","","","","");
        Ladron sospechosoBuscado = new Ladron(descripcion4);
        Computadora computadora = new Computadora();
        computadora.agregarSopechoso(sospechoso1);
        computadora.agregarSopechoso(sospechoso2);
        computadora.agregarSopechoso(sospechoso3);
        Reloj reloj = new Reloj(new Tiempo(168));

        assertEquals(OrdenEmitida.class, computadora.emitirOrdenDeArresto(sospechosoBuscado,reloj).getClass());
    }

    @Test
    public void  IntentarAtraparSospechoSinOrdenDeArrestoEmitida(){
        Descripcion descripcion1 = new Descripcion("sospechoso1","masculino","tenis","castaño","tatuaje","moto");
        Ladron ladron = new Ladron(descripcion1);

        Edificio banco = new Edificio(ladron);

        Ciudad montreal = new Ciudad();
        montreal.agregarEdificio(banco);

        Rango rango = new Novato();

        Policia policia = new Policia(montreal, rango);
        Reloj reloj = new Reloj(new Tiempo(168.0)); //hs en 1 semana

        assertThrows(OrdenNoEmitidadError.class, ()-> policia.visitar(banco, reloj));
    }

    @Test
    public void JugadorRealiza4ArrestosSeLeAsiganUnCasoYCapturAlLadron(){
        Computadora computadora = new Computadora();
        computadora.cargarDatos();
        Ciudad mexico = new Ciudad(new Posicion(19.42833333, -99.1275));
        Ciudad lima = new Ciudad(new Posicion(-12.04318,  -77.02824));
        Rango rango = new Novato();
        Policia policia = new Policia(lima, rango);

        policia.sumarArresto(4);  //rango deberia conocer la # de arrestos
        Descripcion descripcion1 = new Descripcion("","Masculino","Croquet","","","");
        Reloj reloj = new Reloj(new Tiempo(168.0)); //hs en 1 semana
        Ladron ladron = new Ladron(descripcion1);

        Pista pista = new Pista("Una pista "); //

        Edificio puerto = new Edificio(ladron);
        Edificio biblioteca = new Edificio(pista);

        mexico.agregarEdificio(puerto);
        lima.agregarEdificio(biblioteca);
        policia.visitar(biblioteca,reloj);

        policia.viajar(mexico,reloj);

        policia.emitirOrdenArresto(computadora,ladron,reloj);

        policia.visitar(puerto,reloj);

        assertEquals(Detective.class, policia.rangoPolicia().getClass());
    }
}
