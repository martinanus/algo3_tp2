package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.rango.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RangoTest {

    @Test
    public void RangoNovatoRealiza5ArrestosYAumentaSuRago(){

        Rango novato = new Novato();

        assertEquals(Detective.class, novato.sumarArrestos(5).getClass());
    }


    @Test
    public void RangoDetectiveRealiza5ArrestosYAumentaSuRago(){

        Rango detective = new Detective();

        assertEquals(Investigador.class, detective.sumarArrestos(5).getClass());
    }


    @Test
    public void RangoInvestigadroRealiza10ArrestosYAumentaSuRago(){

        Rango investigador = new Investigador();

        assertEquals(Sargento.class, investigador.sumarArrestos(5).getClass());
    }


    @Test
    public void RangoSargentoRealiza5ArrestosNoAumentaSuRango(){

        Rango sargent = new Sargento();

        assertEquals(Sargento.class, sargent.sumarArrestos(5).getClass());
    }


}
