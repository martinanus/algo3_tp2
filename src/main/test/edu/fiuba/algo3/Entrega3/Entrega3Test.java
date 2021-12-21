package edu.fiuba.algo3.Entrega3;

import edu.fiuba.algo3.modelo.AlgoThief;
import edu.fiuba.algo3.modelo.Descripcion;
import edu.fiuba.algo3.modelo.Policia;
import edu.fiuba.algo3.modelo.interactuable.ArmaDeFuego;
import edu.fiuba.algo3.modelo.interactuable.Cuchillo;
import edu.fiuba.algo3.modelo.interactuable.Ladron;
import edu.fiuba.algo3.modelo.interactuable.Pista;
import edu.fiuba.algo3.modelo.rango.Detective;
import edu.fiuba.algo3.modelo.rango.Investigador;
import edu.fiuba.algo3.modelo.rango.Sargento;
import edu.fiuba.algo3.modelo.tiempo.Tiempo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Entrega3Test {
    @Test
    public void test01JugadorSeLeAsignaUnCasoRealizaUnArrestoAtrapaAlLadronYSeLeAsignaOtroCaso() {
        Policia unPolicia = new Policia("Pepito");
        AlgoThief juego = new AlgoThief(unPolicia);
        juego.generarPartida();
        juego.viajar("Ciudad de Mexico");
        Pista interactuable = (Pista) juego.visitar("banco");
        Pista interactuable2 = (Pista) juego.visitar("biblioteca");
        Pista interactuable3 = (Pista) juego.visitar("puerto");

        juego.viajar("Seul"); //(11+13)=24
        Pista interactuable4 = (Pista) juego.visitar("banco");//(24+1)=25
        Pista interactuable5 = (Pista) juego.visitar("biblioteca");//(25+1)=26
        Pista interactuable6 = (Pista) juego.visitar("puerto");//(26+1)=27

        juego.viajar("Paris");//(27+10)=37
        Descripcion descripcion = new Descripcion("","Masculino","Croquet","","","");
        juego.cargarDescripcion(descripcion);
        juego.generarOrdenDeArresto(); //refactor generar orden de arresto incluido cargarDescripcion.

        ArmaDeFuego interactuable7 = (ArmaDeFuego) juego.visitar("banco");
        Cuchillo interactuable9 = (Cuchillo) juego.visitar("puerto");
        Ladron interactuable8 = (Ladron) juego.visitar("biblioteca");

        juego.generarPartida();
        juego.visitar("biblioteca");
        juego.visitar("banco");

        assertEquals(new Tiempo(2), juego.getReloj().tiempoTranscurrido());

        //Herida por arma de fuego: 4 hs cada vez.
        // Dormir: 8 hs por noche.

    }

    @Test
    public void test02JugadorInvestigadorRealiza9ArrestosSeLeAsiganUnCasoYCapturAlLadron() {
        Policia unPolicia = new Policia("Pepito", new Investigador());
        AlgoThief juego = new AlgoThief(unPolicia);
        unPolicia.sumarArresto(9);
        juego.generarPartida();
        juego.viajar("Ciudad de Mexico"); // 5 hs viaje
        Pista interactuable = (Pista) juego.visitar("banco");
        Pista interactuable2 = (Pista) juego.visitar("biblioteca");
        Pista interactuable3 = (Pista) juego.visitar("puerto");

        juego.viajar("Seul"); // 9 hs viaje
        Pista interactuable4 = (Pista) juego.visitar("banco");//(24+1)=25
        Pista interactuable5 = (Pista) juego.visitar("biblioteca");//(25+1)=26
        Pista interactuable6 = (Pista) juego.visitar("puerto");//(26+1)=27

        juego.viajar("Paris"); // 6 hs viaje
        Descripcion descripcion = new Descripcion("","Masculino","Croquet","","","");
        juego.cargarDescripcion(descripcion);
        assertEquals(34, juego.getReloj().tiempoTranscurrido().getTiempo());
        juego.generarOrdenDeArresto(); //refactor generar orden de arresto incluido cargarDescripcion.
        assertEquals(37, juego.getReloj().tiempoTranscurrido().getTiempo());
        juego.visitar("banco");
        juego.visitar("puerto");
        juego.visitar("biblioteca");

        assertEquals(Sargento.class, unPolicia.rangoPolicia().getClass());

    }

    @Test
    public void test03ArmaDeFuegoAumentaLaCantidadEnCinco() {
        Policia unPolicia = new Policia("Pepito");
        AlgoThief juego = new AlgoThief(unPolicia);
        juego.generarPartida();
        juego.viajar("Ciudad de Mexico"); // 8 hs viaje
        Pista interactuable = (Pista) juego.visitar("banco");
        Pista interactuable2 = (Pista) juego.visitar("biblioteca");
        Pista interactuable3 = (Pista) juego.visitar("puerto");

        juego.viajar("Seul"); // 32 hs // 13 hs viaje
        Pista interactuable4 = (Pista) juego.visitar("banco");//(24+1)=25
        Pista interactuable5 = (Pista) juego.visitar("biblioteca");//(25+1)=26
        Pista interactuable6 = (Pista) juego.visitar("puerto");//(26+1)=27

        juego.viajar("Paris"); // 9 hs
        Descripcion descripcion = new Descripcion("","Masculino","Croquet","","","");
        juego.cargarDescripcion(descripcion);
        juego.generarOrdenDeArresto(); //refactor generar orden de arresto incluido cargarDescripcion.
        assertEquals(55, juego.getReloj().tiempoTranscurrido().getTiempo());
        ArmaDeFuego interactuable7 = (ArmaDeFuego) juego.visitar("banco");
        assertEquals(60, juego.getReloj().tiempoTranscurrido().getTiempo());
        Cuchillo interactuable9 = (Cuchillo) juego.visitar("puerto");
        Ladron interactuable8 = (Ladron) juego.visitar("biblioteca");

    }
    @Test
    public void test04JugadorNovatoRealiza4ArrestosSeLeAsiganUnCasoYCapturAlLadron() {
        Policia unPolicia = new Policia("Pepito");
        AlgoThief juego = new AlgoThief(unPolicia);
        unPolicia.sumarArresto(4);
        juego.generarPartida();
        juego.viajar("Ciudad de Mexico");
        Pista interactuable = (Pista) juego.visitar("banco");
        Pista interactuable2 = (Pista) juego.visitar("biblioteca");
        Pista interactuable3 = (Pista) juego.visitar("puerto");

        juego.viajar("Seul");
        Pista interactuable4 = (Pista) juego.visitar("banco");//(24+1)=25
        Pista interactuable5 = (Pista) juego.visitar("biblioteca");//(25+1)=26
        Pista interactuable6 = (Pista) juego.visitar("puerto");//(26+1)=27

        juego.viajar("Paris");
        Descripcion descripcion = new Descripcion("","Masculino","Croquet","","","");
        juego.cargarDescripcion(descripcion);
        juego.generarOrdenDeArresto(); //refactor generar orden de arresto incluido cargarDescripcion.
        juego.visitar("banco");
        juego.visitar("puerto");
        juego.visitar("biblioteca");

        assertEquals(Detective.class, unPolicia.rangoPolicia().getClass());

    }
    @Test
    public void test05JugadorDetectiveRealiza4ArrestosSeLeAsiganUnCasoYCapturAlLadron() {
        Policia unPolicia = new Policia("Pepito",new Detective());
        AlgoThief juego = new AlgoThief(unPolicia);
        unPolicia.sumarArresto(4);
        juego.generarPartida();
        juego.viajar("Ciudad de Mexico");
        Pista interactuable = (Pista) juego.visitar("banco");
        Pista interactuable2 = (Pista) juego.visitar("biblioteca");
        Pista interactuable3 = (Pista) juego.visitar("puerto");

        juego.viajar("Seul");
        Pista interactuable4 = (Pista) juego.visitar("banco");//(24+1)=25
        Pista interactuable5 = (Pista) juego.visitar("biblioteca");//(25+1)=26
        Pista interactuable6 = (Pista) juego.visitar("puerto");//(26+1)=27

        juego.viajar("Paris");
        Descripcion descripcion = new Descripcion("","Masculino","Croquet","","","");
        juego.cargarDescripcion(descripcion);
        juego.generarOrdenDeArresto(); //refactor generar orden de arresto incluido cargarDescripcion.
        juego.visitar("banco");
        juego.visitar("puerto");
        juego.visitar("biblioteca");

        assertEquals(Investigador.class, unPolicia.rangoPolicia().getClass());

    }

    /*@Test
    public void test06JugadorDuermeLuegoDeVisitarEdificiosEnlaCiudadActual() {
        AlgoThief juego = new AlgoThief();
        Policia unPolicia = new Policia("Pepito");
        juego.generarPartida(unPolicia);
        juego.inicializarDia();
        juego.visitar(unPolicia,"banco");
        juego.visitar(unPolicia,"biblioteca");
        juego.visitar(unPolicia,"puerto");
        juego.visitar(unPolicia,"banco");
        juego.visitar(unPolicia,"biblioteca");
        juego.visitar(unPolicia,"puerto"); //16
        juego.visitar(unPolicia,"banco"); //19
        juego.visitar(unPolicia,"biblioteca");//22
        assertEquals(22,juego.getReloj().tiempoTranscurrido().getTiempo());
        juego.visitar(unPolicia,"puerto"); //25 Duerme
        assertEquals(33,juego.getReloj().tiempoTranscurrido().getTiempo());
        juego.visitar(unPolicia,"banco");
        assertEquals(36,juego.getReloj().tiempoTranscurrido().getTiempo());
    }*/
}
