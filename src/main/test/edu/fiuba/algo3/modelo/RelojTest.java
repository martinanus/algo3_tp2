package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.rango.Novato;
import edu.fiuba.algo3.modelo.tiempo.Reloj;
import edu.fiuba.algo3.modelo.tiempo.Tiempo;
import edu.fiuba.algo3.modelo.tiempo.TiempoExcedidoError;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void SeIncrementaElRelojEnUnTiempoDeUnaHora() {
        /* Arrange */
        Reloj reloj = new Reloj(new Tiempo(154));

        /* Act */
        reloj.incrementar(new Tiempo(1));

        /* Assert */
        assertEquals(reloj.getDia(), "Lunes");
        assertEquals(reloj.getHoraActual(), 8);
    }

    @Test
    public void SeAlcanzanLas0HorasDelMartesYSeIncrementaElRelojAutomaticamente8Horas() {
        /* Arrange */
        Reloj reloj = new Reloj(new Tiempo(154));

        /* Act */
        reloj.incrementar(new Tiempo(17));  // Lunes 7 a.m. + 17 hs = Martes 0 a.m.

        /* Assert */
        assertEquals(reloj.getDia(), "Martes");
        assertEquals(reloj.getHoraActual(), 8);
    }

    @Test
    public void SeAlcanzanLas3AmDelMiercolesYSeIncrementaElRelojAutomaticamente8Horas() {
        /* Arrange */
        Reloj reloj = new Reloj(new Tiempo(154));

        /* Act */
        reloj.incrementar(new Tiempo(44));  // Lunes 7 a.m. + 44 hs = Miércoles 3 a.m.

        /* Assert */
        assertEquals(reloj.getDia(), "Miercoles");
        assertEquals(reloj.getHoraActual(), 11);
    }

    @Test
    public void SeAlcanzanLas1AmDelMartesYSeIncrementaElRelojAutomaticamente8Horas() {
        /* Arrange */
        Reloj reloj = new Reloj(new Tiempo(154));

        /* Act */
        reloj.incrementar(new Tiempo(15));  // Lunes 7 a.m. + 15 hs = Lunes 10 p.m. (22)
        reloj.incrementar(new Tiempo(3));  // Lunes 10 p.m. + 3 hs = Martes 1 a.m.

        /* Assert */
        assertEquals(reloj.getDia(), "Martes");
        assertEquals(reloj.getHoraActual(), 9);
    }

    @Test
    public void SeIncrementaElRelojEnUnTiempoDe44Horas() {
        /* Arrange */
        Reloj reloj = new Reloj(new Tiempo(154));

        /* Act */
        reloj.incrementar(new Tiempo(8));
        reloj.incrementar(new Tiempo(3));
        reloj.incrementar(new Tiempo(13));  // Lunes 18 p.m. + 13 hs = Martes 7 a.m. + 8 hs = Martes 3 p.m.
        reloj.incrementar(new Tiempo(3));
        reloj.incrementar(new Tiempo(9));

        /* Assert */
        assertEquals(reloj.getDia(), "Miercoles");
        assertEquals(reloj.getHoraActual(), 11);
    }

    @Test
    public void SeRealizaUnViajeDesdeCiudadDeMexicoASeulElLunesALas11Pm() {
        Ciudad ciudadDeMexico = new Ciudad(new Posicion(19.42847, -99.12766));
        Ciudad seul = new Ciudad(new Posicion(37.566, 126.9784));
        Policia policia = new Policia(ciudadDeMexico, new Novato());
        Reloj reloj = new Reloj(new Tiempo(154));
        reloj.incrementar(new Tiempo(16));

        policia.viajar(seul, reloj);

        assertEquals(reloj.getDia(), "Martes");
        assertEquals(reloj.getHoraActual(), 12);
    }

    @Test
    public void SeChequeaResultadoHoraDormir() {
        Reloj reloj = new Reloj(new Tiempo(154));

        assertFalse(reloj.horaDormir());
        assertEquals(reloj.getHoraActual(), 7);
    }

    @Test
    public void SeChequeaSiSeDuerme() {
        Reloj reloj = new Reloj(new Tiempo(154));
        reloj.incrementar(new Tiempo(46));

        assertFalse(reloj.horaDormir());
        assertEquals(13, reloj.getHoraActual());
    }
}
