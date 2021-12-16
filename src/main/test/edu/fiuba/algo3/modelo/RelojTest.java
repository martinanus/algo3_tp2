package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.tiempo.Reloj;
import edu.fiuba.algo3.modelo.tiempo.Tiempo;
import edu.fiuba.algo3.modelo.tiempo.TiempoExcedidoError;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RelojTest {

    @Test
    public void ElTiempoTranscurridoDelRelojDeberiaSerMenorQueUnTiempoMasGrande(){
        Reloj reloj = new Reloj(new Tiempo(168.0));
        Tiempo unTiempo = new Tiempo(120);
        reloj.incrementar(unTiempo);
        Tiempo otroTiempo = new Tiempo(188);

        boolean esMayor = reloj.tiempoTranscurrido().esMayor(otroTiempo);

        assertFalse(esMayor);
    }

    @Test
    public void ElRelojLanzaExcepcionSiTranscurreMasTiempo(){
        Reloj reloj = new Reloj(new Tiempo(168.0));
        Tiempo unTiempo = new Tiempo(170.0);

        assertThrows(TiempoExcedidoError.class, ()-> reloj.incrementar(unTiempo));
    }
}
