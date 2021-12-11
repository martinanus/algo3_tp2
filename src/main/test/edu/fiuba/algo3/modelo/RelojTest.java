package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class RelojTest {

    @Test //En RelojTest prueba de acepta falla, haces el ciclo de unit test, prueba u
    public void ElTiempoTranscurridoDelRelojDeberiaSerMenorQueUnTiempoMasGrande(){
        Reloj reloj = new Reloj(new Tiempo(168.0));
        Tiempo unTiempo = new Tiempo(120);
        reloj.incrementar(unTiempo);
        Tiempo otroTiempo = new Tiempo(188);

        boolean esMayor = reloj.tiempoTranscurrido().esMayor(otroTiempo);

        assertFalse(esMayor);
    }
}
