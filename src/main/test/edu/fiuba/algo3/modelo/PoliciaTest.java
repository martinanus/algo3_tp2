package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.interactuable.Cuchillo;
import edu.fiuba.algo3.modelo.interactuable.Interactuable;
import edu.fiuba.algo3.modelo.rango.Detective;
import edu.fiuba.algo3.modelo.rango.Investigador;
import edu.fiuba.algo3.modelo.rango.Novato;
import edu.fiuba.algo3.modelo.rango.Rango;
import edu.fiuba.algo3.modelo.tiempo.Reloj;
import edu.fiuba.algo3.modelo.tiempo.Tiempo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PoliciaTest {

    @Test
    public void PoliciaDuermeYTranscurrenOchoHoras() {

        Ciudad mexico = new Ciudad();

        Rango rango = new Novato();

        Policia policia = new Policia(mexico, rango);
        Reloj reloj = new Reloj(new Tiempo(168.0)); //hs en 1 semana


        policia.duerme(reloj);


        assertEquals(new Tiempo(8), reloj.tiempoTranscurrido());

    }

    @Test
    public void PoliciaSufreHeridaDeCuchillo() {

        Ciudad mexico = new Ciudad();
        Rango rango = new Novato();
        Policia policia = new Policia(mexico, rango);

        Reloj reloj = new Reloj(new Tiempo(168.0)); //hs en 1 semana
        Cuchillo cuchillo = new Cuchillo();
        Edificio puerto = new Edificio(cuchillo);


        Interactuable interactuable = puerto.visitar(reloj);
        interactuable.interactuar(policia,reloj);

        //El reloj se debería incrementar 2 horas por el cuchillo mas 1 hora por visita
        assertEquals(new Tiempo(3), reloj.tiempoTranscurrido());

    }

    @Test
    public void PoliciaRealiza5ArrestosYAumentaSuRago(){

        Ciudad lima = new Ciudad(new Posicion(-12.04318,  -77.02824));
        Rango rango = new Novato();
        Policia policia = new Policia(lima, rango);

        policia.sumarArresto(5);  //rango deberia conocer la # de arrestos

        assertEquals(Detective.class,policia.rangoPolicia().getClass()); //fijarnos el rango del policia,
    }

    @Test
    public void PoliciaConRangoDetectiveRealiza5ArrestosYAumentaSuRago(){

        Ciudad lima = new Ciudad(new Posicion(-12.04318,  -77.02824));
        Rango rango = new Detective();
        Policia policia = new Policia(lima, rango);

        policia.sumarArresto(5);  //rango deberia conocer la # de arrestos

        assertEquals(Investigador.class,policia.rangoPolicia().getClass()); //fijarnos el rango del policia,
    }
}
