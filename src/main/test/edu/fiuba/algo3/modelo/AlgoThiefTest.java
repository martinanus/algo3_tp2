package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.interactuable.Ladron;
import edu.fiuba.algo3.modelo.lector.ArchivoNoEncontradoError;
import edu.fiuba.algo3.modelo.rango.*;
import edu.fiuba.algo3.modelo.tiempo.Reloj;
import edu.fiuba.algo3.modelo.tiempo.Tiempo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AlgoThiefTest {

    @Test
    public void test01SeCreaUnCasoYSeVisitaLos3EdificiosDeLaCiudadOrigen(){
        Policia unPolicia = new Policia("Pepe");
        AlgoThief juego = new AlgoThief();
        juego.setPolicia(unPolicia);
        juego.generarPartida();
        juego.visitar("banco");
        juego.visitar("biblioteca");
        juego.visitar("puerto");

        assertEquals(new Tiempo(3), juego.getReloj().tiempoTranscurrido());
    }

    @Test
    public void test02SeGeneraOrdenDeArresto() {
        Policia unPolicia = new Policia("Pepe");
        AlgoThief juego = new AlgoThief();
        juego.setPolicia(unPolicia);
        juego.generarPartida();

        juego.cargarDescripcion(new Descripcion("Masculino","Alpinismo","","Anillo",""));

        juego.generarOrdenDeArresto();
        System.out.println(juego.getMensajeOrden());

        assertEquals(new Tiempo(3), juego.getReloj().tiempoTranscurrido());
    }


    @Test
    public void test03SeAlcanzaElTiempoLimiteDelCasoAsignado() {
        Policia unPolicia = new Policia("Pepe");
        AlgoThief juego = new AlgoThief();
        juego.setPolicia(unPolicia);
        juego.generarPartida();


        for (int j = 0; j < 36; j++)
            juego.visitar("banco");

        assertThrows(CasoFinalizadoSinExitoError.class, ()-> {
            juego.visitar("biblioteca");  //
        } );
    }

    @Test
    public void test04SeMuestranCiudadesDisponibles(){
        Policia unPolicia = new Policia("Pepe");
        AlgoThief juego = new AlgoThief();
        juego.setPolicia(unPolicia);
        juego.generarPartida();

    }

    @Test
    public void test05SeTesteaLaListasDestinoDeLasCiudadesQueRecorrioElLadron(){
        Policia unPolicia = new Policia("Pepe");
        AlgoThief juego = new AlgoThief();
        juego.setPolicia(unPolicia);
        juego.generarPartida();
        ArrayList<Ciudad> ciudades123 = unPolicia.getCaso().ciudadesLadron();

        ArrayList<Ciudad> ciudades = juego.obtenerCiudades();

        assertEquals(4, ciudades123.size());
        assertEquals(11, ciudades.size());
    }

    @Test
    public void test06eTesteaLaListasDestinoDeLasCiudades(){
        Policia unPolicia = new Policia("Pepe");
        AlgoThief juego = new AlgoThief();
        juego.setPolicia(unPolicia);
        juego.generarPartida();

        ArrayList<Ciudad> ciudades = juego.mostrarCiudadesDestino();

        assertEquals(4, ciudades.size());
    }


    @Test
    public void  IntentarAtraparSospechoSinOrdenDeArrestoEmitidaRangoDetective(){
        Rango rango = new Detective();
        Policia policia = new Policia(rango);
        AlgoThief juego = new AlgoThief();

        juego.setPolicia(policia);
        juego.generarPartida();

        juego.visitar("banco");
        assertEquals(new Tiempo(1), juego.getReloj().tiempoTranscurrido());

    }

    @Test
    public void  IntentarAtraparSospechoSinOrdenDeArrestoEmitidaRangoInvestigador(){
        Rango rango = new Investigador();
        Policia policia = new Policia(rango);
        AlgoThief juego = new AlgoThief();

        juego.setPolicia(policia);
        juego.generarPartida();

        juego.visitar("banco");
        assertEquals(new Tiempo(1), juego.getReloj().tiempoTranscurrido());


    }

    @Test
    public void  IntentarAtraparSospechoSinOrdenDeArrestoEmitidaRangoSargento(){
        Rango rango = new Sargento();
        Policia policia = new Policia(rango);
        AlgoThief juego = new AlgoThief();

        juego.setPolicia(policia);
        juego.generarPartida();

        juego.visitar("banco");
        assertEquals(new Tiempo(1), juego.getReloj().tiempoTranscurrido());
    }
}
