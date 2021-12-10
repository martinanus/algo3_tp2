package edu.fiuba.algo3.Entrega2;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Interactuable.Cuchillo;
import edu.fiuba.algo3.modelo.Interactuable.Interactuable;
import edu.fiuba.algo3.modelo.Interactuable.Ladron;
import edu.fiuba.algo3.modelo.Interactuable.Pista;
import edu.fiuba.algo3.modelo.lector.LadronParser;
import edu.fiuba.algo3.modelo.ordenesArresto.OrdenNoEmitidadError;
import edu.fiuba.algo3.modelo.rango.Investigador;
import edu.fiuba.algo3.modelo.rango.Novato;
import edu.fiuba.algo3.modelo.rango.Rango;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
        Interactuable interactuable = policia.visitar(puerto,reloj);
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

        assertEquals(true, computadora.emitirOrdenDeArresto(sospechosoBuscado));
    }
    
    @Test
    public void compararDescripciones() {
        Descripcion descripcion1 = new Descripcion("sospechoso1","masculino","tenis","castaño","tatuaje","moto");
        Ladron sospechoso1 = new Ladron(descripcion1);
        Descripcion descripcion2 = new Descripcion("sospechoso2","masculino","musica","negro","anillo","deportivo");
        Ladron sospechoso2 = new Ladron(descripcion2);
        assertFalse(sospechoso1.compararCon(sospechoso2));
    }

    @Test
    public void compararLadronesConDescripcionesDeSexoYHobby() {
        Descripcion descripcion1 = new Descripcion("sospechoso1","masculino","tenis","castaño","tatuaje","moto");
        Descripcion descripcion4 = new Descripcion("","masculino","tenis","","","");
        assertTrue(descripcion1.comparar(descripcion4));
    }

    @Test
    public void SeBuscaEnLaComputadoraUnSospechosoConDatosDeLadronesYaCreados() {
        Computadora computadora = new Computadora();
        computadora.cargarDatos();
        Descripcion descripcion4 = new Descripcion("","Masculino","","","","");
        Ladron sospechosoBuscado = new Ladron(descripcion4);
        assertEquals(false, computadora.emitirOrdenDeArresto(sospechosoBuscado));
    }

    @Test
    public void SeBuscaEnLaComputadoraUnSospechosoConSexoYHobbyConDatosDeLadrones() {
        Computadora computadora = new Computadora();
        computadora.cargarDatos();
        Descripcion descripcion4 = new Descripcion("","Masculino","Croquet","","","");
        Ladron sospechosoBuscado = new Ladron(descripcion4);
        assertEquals(true, computadora.emitirOrdenDeArresto(sospechosoBuscado));
    }
    @Test
    public void  IntentarAtraparSospechoSinOrdenDeArrestoEmitida(){
        Descripcion descripcion1 = new Descripcion("sospechoso1","masculino","tenis","castaño","tatuaje","moto");
        Ladron ladron = new Ladron(descripcion1);
        Ciudad montreal = new Ciudad(new Posicion(45.50861111, -73.58777778));
        Rango rango = new Investigador();
        Policia policia = new Policia(montreal, rango);

         //Arma, Pista, Ladron ->>>> Interactuable postergarlo este refactor
        //El Quilombo de setear la orden de arresto emitida la computadora y se le asignaba al jugador no esta.
        //ARREGLAR DIAGRAMAS DE SEC,
        Edificio puerto = new Edificio(ladron);
        //montreal.agregarEdificio(puerto);
        Reloj reloj = new Reloj(new Tiempo(168.0)); //hs en 1 semana


        assertThrows(OrdenNoEmitidadError.class, ()-> {
            Interactuable interactuable = puerto.visitar(reloj);
            interactuable.interactuar(policia,reloj);   //
        } );
    }
    @Test
    public void JugadorRealiza6ArrestosSeLeAsiganUnCasoYCapturAlLadron(){
        Computadora computadora = new Computadora();
        computadora.cargarDatos();
        Ciudad mexico = new Ciudad(new Posicion(19.42833333, -99.1275));
        Ciudad lima = new Ciudad(new Posicion(-12.04318,  -77.02824));
        Rango rango = new Novato();
        Policia policia = new Policia(lima, rango);

        policia.sumarArresto(6);  //rango deberia conocer la # de arrestos
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

        policia.emitirOrdenArresto(computadora,ladron);

        Interactuable interactuable = policia.visitar(puerto,reloj);

        assertEquals(7,policia.getCantidadArrestos()); //fijarnos el rango del policia,
        //Cuando el chavon hace el 7timo arresto, deberiamos fijarnos el rango sea Detective,Sargento,etc
        //medimos el rango,  cambie rango.
        //Clase Juego -> pasarSiguienteMision(); Intercae agarra la exocpcion y se propaga para arriba,
        // y en algun lugar van aestar las clas qeu reaccionan a eso.
        //AUMENTA ACOPLAMIENTO, no viene al tema, mas adelante, puede ser que aparezca no ahora.
        //

    }

    @Test
    public void SeCarganDatosDeLadronCorrectamente() {
        LadronParser ladronParser = new LadronParser();
        ArrayList<Ladron> ladrones = ladronParser.parser("/jsons/ladrones.json");
        assertEquals(6, ladrones.size());
    }

    @Test
    public void SeQuierenCarganDatosDeLadronConRutaInadecuada() {
        LadronParser ladronParser = new LadronParser();
        ArrayList<Ladron> ladrones = ladronParser.parser("/jsons/ladron.json");
        assertEquals(0, ladrones.size());
    }

     
}
