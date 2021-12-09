package edu.fiuba.algo3.Entrega2;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.arma.Cuchillo;
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

        Reloj reloj = new Reloj(new Tiempo(168.0));

        Cuchillo cuchillo = new Cuchillo();
        policia.herir(cuchillo, reloj);
        policia.duerme(reloj);

        assertEquals(new Tiempo(10), reloj.mostrar());

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

        assertEquals(new Tiempo(2), reloj.mostrar());
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

        assertEquals(1, computadora.emitirOrdenDeArresto(sospechosoBuscado));
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
        assertTrue(descripcion4.comparar(descripcion1));
    }

    @Test
    public void SeBuscaEnLaComputadoraUnSospechosoConDatosDeLadronesYaCreados() {
        Computadora computadora = new Computadora();
        computadora.cargarDatos();
        Descripcion descripcion4 = new Descripcion("","Masculino","","","","");
        Ladron sospechosoBuscado = new Ladron(descripcion4);
        assertEquals(3, computadora.emitirOrdenDeArresto(sospechosoBuscado));
    }

    @Test
    public void SeBuscaEnLaComputadoraUnSospechosoConSexoYHobbyConDatosDeLadrones() {
        Computadora computadora = new Computadora();
        computadora.cargarDatos();
        Descripcion descripcion4 = new Descripcion("","Masculino","Croquet","","","");
        Ladron sospechosoBuscado = new Ladron(descripcion4);
        assertEquals(1, computadora.emitirOrdenDeArresto(sospechosoBuscado));
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
        ladron.interactuar(policia);

        assertEquals(0,policia.getCantidadArrestos());
    }

    @Test
    public void JugadorHaceSeisArrestos(){
        Computadora computadora = new Computadora();
        computadora.cargarDatos();
        Ciudad mexico = new Ciudad(new Posicion(19.42833333, -99.1275));
        Ciudad lima = new Ciudad(new Posicion(-12.04318,  -77.02824));
        Rango rango = new Novato();
        Policia policia = new Policia(mexico, rango);
        policia.sumarArresto(6);

        Reloj reloj = new Reloj(new Tiempo(168.0)); //hs en 1 semana
        policia.viajar(mexico,reloj);

        //assertEquals(6,policia.getCantidadArrestos());
        //assertEquals(new Tiempo(3),reloj.mostrar() );
        //Json aparte esta el objeto acoplado a la rareza (asignamos nosotros) y al lugar de origen (analisisi de Requerimiento)
        // Comun,Valioso, Muy valioso,
        CuartelGeneral cuartel = new CuartelGeneral();
        cuartel.asignarMision(policia);
        policia.viajar(lima,reloj); //Creamos el ladron apartir de las pistas de los edificios.
        Descripcion descripcion4 = new Descripcion("","Masculino","Croquet","","","");
        ArrayList<Ladron> ladronesPosibles = computadora.cargarDatoSospechoso(descripcion4); //devuelve lista de sospechosos
        cuartel.emitirOrden(ladronesPosibles,policia);

        ladronesPosibles.get(0).interactuar(policia);

        //policia viaja a lima entra a los edificios, obtiene pistas , carga a la computadora, le da la orden de arrrestro y captura al ladron .
        //
        assertEquals(1,ladronesPosibles.size());
        assertEquals(7,policia.getCantidadArrestos());
    }

    /*Detective Tenga como atributo una orden de Arrestro no Emitida.
    * Computadora genera la orden de Arrestro le seteamos al policia  ordenDeArrestro Emitiada. Patron state
    *Detective: Orden de arrestro no Emitida.
    * CASO POLICIA ATRAPA AL LADRON SIN ORDEN DE ARRESTRO ->
    *COMO TERMINA LA Mision?
    * jugador.
    *
    * Cuando la orden de arresto del jugador "arreste" al ladron.
    *
    * IDEAS LOGICA:
    * JSON que contenga ->
    * Json.Ladron
    * acoplarlo con la trayectoria que recorre el ladron. DestinoFinal.
    * Ciudades con sus edificios.
    * Objetos Comun, Raro, Muy raro,
    *
    * */

     
}
