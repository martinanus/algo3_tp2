package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.tiempo.Tiempo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

        juego.cargarDescripcion(new Descripcion("","Masculino","Croquet","","",""));

        juego.generarOrdenDeArresto();

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
        juego.visitar("biblioteca");

        assertEquals(new Tiempo(0), juego.getReloj().tiempoTranscurrido());
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


}
