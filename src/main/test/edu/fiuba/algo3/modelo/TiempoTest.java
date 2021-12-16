package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.tiempo.Tiempo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TiempoTest {

    @Test
    public void ElTiempoComparaSiEsMayor(){

        Tiempo unTiempo = new Tiempo(170.0);

        assertTrue(unTiempo.esMayor(new Tiempo(160)));
    }

    @Test
    public void ElTiempoComparaSiEsMayorYDevuelveFalso(){

        Tiempo unTiempo = new Tiempo(170.0);

        assertFalse(unTiempo.esMayor(new Tiempo(190)));
    }
}
