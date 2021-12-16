package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.interactuable.Interactuable;
import edu.fiuba.algo3.modelo.interactuable.Pista;
import edu.fiuba.algo3.modelo.rango.Detective;
import edu.fiuba.algo3.modelo.rango.Investigador;
import edu.fiuba.algo3.modelo.rango.Novato;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlgoThiefTest {

    @Test
    public void test01SeCreaUnCasoYSeVisitaLos3EdificiosDeLaCiudadOrigen(){
        AlgoThief juego = new AlgoThief();
        juego.generarPartida();
        Pista interactuable = (Pista) juego.visitar("banco");
        Pista interactuable2 = (Pista) juego.visitar("biblioteca");
        Pista interactuable3 = (Pista) juego.visitar("puerto");
        assertEquals("Pesos",interactuable.mostrar()  );
        assertEquals("Templo de Kukulkán",interactuable2.mostrar());
        assertEquals("Verde, blanca y roja",interactuable3.mostrar());
    }

}
