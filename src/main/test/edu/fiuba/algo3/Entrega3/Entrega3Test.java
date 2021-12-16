package edu.fiuba.algo3.Entrega3;

import edu.fiuba.algo3.modelo.AlgoThief;
import edu.fiuba.algo3.modelo.Descripcion;
import edu.fiuba.algo3.modelo.Policia;
import edu.fiuba.algo3.modelo.interactuable.Cuchillo;
import edu.fiuba.algo3.modelo.interactuable.Ladron;
import edu.fiuba.algo3.modelo.interactuable.Pista;
import edu.fiuba.algo3.modelo.tiempo.Tiempo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Entrega3Test {
    @Test
    public void test01JugadorSeLeAsignaUnCasoRealizaUnArrestoAtrapaAlLadronYSeLeAsignaOtroCaso() {
        AlgoThief juego = new AlgoThief();
        Policia unPolicia = new Policia("Pepito");
        juego.generarPartida(unPolicia);
        juego.viajar("Ciudad de Mexico",unPolicia);
        Pista interactuable = (Pista) juego.visitar(unPolicia,"banco");
        Pista interactuable2 = (Pista) juego.visitar(unPolicia,"biblioteca");
        Pista interactuable3 = (Pista) juego.visitar(unPolicia,"puerto");

        juego.viajar("Seul",unPolicia); //(11+13)=24
        Pista interactuable4 = (Pista) juego.visitar(unPolicia,"banco");//(24+1)=25
        Pista interactuable5 = (Pista) juego.visitar(unPolicia,"biblioteca");//(25+1)=26
        Pista interactuable6 = (Pista) juego.visitar(unPolicia,"puerto");//(26+1)=27

        juego.viajar("Paris",unPolicia);//(27+10)=37
        Descripcion descripcion = new Descripcion("","Masculino","Croquet","","","");
        juego.cargarDescripcion(descripcion);
        juego.generarOrdenDeArresto(unPolicia); //refactor generar orden de arresto incluido cargarDescripcion.

        Cuchillo interactuable7 = (Cuchillo) juego.visitar(unPolicia,"banco");
        Cuchillo interactuable9 = (Cuchillo) juego.visitar(unPolicia,"puerto");
        Ladron interactuable8 = (Ladron) juego.visitar(unPolicia,"biblioteca");

        juego.generarPartida(unPolicia);
        juego.visitar(unPolicia,"banco");
        juego.visitar(unPolicia,"biblioteca");
        juego.visitar(unPolicia,"banco");

        assertEquals(new Tiempo(4), juego.getReloj().tiempoTranscurrido());

        //Herida por arma de fuego: 4 hs cada vez.
        // Dormir: 8 hs por noche.


    }
}
