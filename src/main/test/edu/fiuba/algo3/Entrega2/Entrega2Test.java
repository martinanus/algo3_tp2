package edu.fiuba.algo3.Entrega2;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

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

        assertTrue(computadora.emitirOrdenDeArresto(sospechosoBuscado));
    }

    
    @Test
    public void compararDescripcionesDeSexoYHobby() {
        Descripcion descripcion1 = new Descripcion("sospechoso1","masculino","tenis","castaño","tatuaje","moto");
        Descripcion descripcion4 = new Descripcion("","masculino","tenis","","","");
        assertTrue(descripcion4.comparar(descripcion1));
    }

    /*Detective Tenga como atributo una orden de Arrestro no Emitida.
    * Computadora genera la orden de Arrestro le seteamos al policia  ordenDeArrestro Emitiada. Patron state
    *Detective: Orden de arrestro no Emitida.
    * CASO POLICIA ATRAPA AL LADRON SIN ORDEN DE ARRESTRO ->
    *
    * */





     
}
