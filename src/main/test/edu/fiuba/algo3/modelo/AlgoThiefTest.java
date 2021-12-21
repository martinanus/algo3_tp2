package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.interactuable.Pista;
import edu.fiuba.algo3.modelo.tiempo.Tiempo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlgoThiefTest {

    @Test
    public void test01SeCreaUnCasoYSeVisitaLos3EdificiosDeLaCiudadOrigen(){
        Policia unPolicia = new Policia("Pepe");
        AlgoThief juego = new AlgoThief(unPolicia);
        juego.generarPartida();
        Pista interactuable = (Pista) juego.visitar("banco");
        Pista interactuable2 = (Pista) juego.visitar("biblioteca");
        Pista interactuable3 = (Pista) juego.visitar("puerto");
        assertEquals("Su moneda principal es el peso",interactuable.mostrar()  );
        assertEquals("Moto",interactuable2.mostrar());
        assertEquals("Bandera Verde, Blanca y Roja",interactuable3.mostrar());
    }

    @Test
    public void test02SeCreaUnCasoYSeViajaAUnPaisDondeNoEstuvoElLadron(){
        Policia unPolicia = new Policia("Pepe");
        AlgoThief juego = new AlgoThief(unPolicia);
        juego.generarPartida();
        juego.viajar("Lima");
        Pista interactuable = (Pista) juego.visitar("banco");
        Pista interactuable2 = (Pista) juego.visitar("biblioteca");
        Pista interactuable3 = (Pista) juego.visitar("puerto");

        assertEquals("No hemos visto al ladron",interactuable.mostrar()  );
        assertEquals("No hemos visto al ladron",interactuable2.mostrar());
        assertEquals("No hemos visto al ladron",interactuable3.mostrar());
    }

    @Test
    public void test03ElPoliciaAtrapaAlLadronHabiendoEmitidoLaOrdenDeArresto(){
        Policia unPolicia = new Policia("Pepito");
        AlgoThief juego = new AlgoThief(unPolicia);
        int ladronesIniciales = juego.getCantidadLadrones();
        int objetosIniciales = juego.getCantidadObjetosRobados();
        juego.generarPartida();
        Pista interactuable0 = (Pista) juego.visitar("biblioteca");

        assertEquals("Moto",interactuable0.mostrar());

        juego.viajar("Ciudad de Mexico");
        Pista interactuable = (Pista) juego.visitar("banco");
        Pista interactuable2 = (Pista) juego.visitar("biblioteca");
        Pista interactuable3 = (Pista) juego.visitar("puerto");


        assertEquals("Su moneda principal es el won",interactuable.mostrar()  );
        assertEquals("Anillo", interactuable2.mostrar());
        assertEquals("Bandera roja y azul",interactuable3.mostrar());

        juego.viajar("Seul"); //(11+13)=24
        Pista interactuable4 = (Pista) juego.visitar("banco");//(24+1)=25
        Pista interactuable5 = (Pista) juego.visitar("biblioteca");//(25+1)=26
        Pista interactuable6 = (Pista) juego.visitar("puerto");//(26+1)=27

        assertEquals("Su moneda principal es el euro",interactuable4.mostrar()  );
        assertEquals("Negro",interactuable5.mostrar());
        assertEquals("Idioma frances",interactuable6.mostrar());

        juego.viajar("Paris");//(27+10)=37
        Descripcion descripcion = new Descripcion("","Masculino","Croquet","","","");
        juego.cargarDescripcion(descripcion);
        juego.generarOrdenDeArresto(); //refactor generar orden de arresto incluido cargarDescripcion.

        juego.visitar("banco");
        juego.visitar("puerto");
        juego.visitar("biblioteca");


        assertEquals(new Tiempo(0), juego.getReloj().tiempoTranscurrido());
        assertEquals(ladronesIniciales - 1, juego.getCantidadLadrones());
        assertEquals(objetosIniciales - 1, juego.getCantidadObjetosRobados());
    }

    @Test
    public void test04ElPoliciaAtrapaAlLadronSinHaberEmitidoLaOrdenDeArresto(){
        Policia unPolicia = new Policia("Pepito");
        AlgoThief juego = new AlgoThief(unPolicia);
        int ladronesIniciales = juego.getCantidadLadrones();
        int objetosIniciales = juego.getCantidadObjetosRobados();
        juego.generarPartida();
        Pista interactuable0 = (Pista) juego.visitar("biblioteca");

        assertEquals("Moto",interactuable0.mostrar());

        juego.viajar("Ciudad de Mexico");
        Pista interactuable = (Pista) juego.visitar("banco");
        Pista interactuable2 = (Pista) juego.visitar("biblioteca");
        Pista interactuable3 = (Pista) juego.visitar("puerto");


        assertEquals("Su moneda principal es el won",interactuable.mostrar()  );
        assertEquals("Anillo",interactuable2.mostrar());
        assertEquals("Bandera roja y azul",interactuable3.mostrar());

        juego.viajar("Seul");
        Pista interactuable4 = (Pista) juego.visitar("banco");
        Pista interactuable5 = (Pista) juego.visitar("biblioteca");
        Pista interactuable6 = (Pista) juego.visitar("puerto");

        assertEquals("Su moneda principal es el euro",interactuable4.mostrar()  );
        assertEquals("Negro",interactuable5.mostrar());
        assertEquals("Idioma frances",interactuable6.mostrar());

        juego.viajar("Paris");

        juego.visitar("banco");//38
        juego.visitar("puerto");//40
        juego.visitar("biblioteca");

        assertEquals(new Tiempo(0), juego.getReloj().tiempoTranscurrido());
        assertEquals(ladronesIniciales, juego.getCantidadLadrones());
        assertEquals(objetosIniciales, juego.getCantidadObjetosRobados());
    }

    @Test
    public void test05SeAlcanzaElTiempoLimiteDelCasoAsignado() {
        Policia unPolicia = new Policia("Pepe");
        AlgoThief juego = new AlgoThief(unPolicia);
        juego.generarPartida();


        for (int j = 0; j < 36; j++)
            juego.visitar("banco");
        juego.visitar("biblioteca");

        assertEquals(new Tiempo(0), juego.getReloj().tiempoTranscurrido());
    }
}
