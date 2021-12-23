package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.interactuable.ArmaDeFuego;
import edu.fiuba.algo3.modelo.interactuable.Cuchillo;
import edu.fiuba.algo3.modelo.interactuable.Pista;
import edu.fiuba.algo3.modelo.rango.Novato;
import edu.fiuba.algo3.modelo.rango.Rango;
import edu.fiuba.algo3.modelo.tiempo.Reloj;
import edu.fiuba.algo3.modelo.tiempo.Tiempo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InteractuableTest {

    @Test
    public void  InteractuoConArmaDeFuego(){
        ArmaDeFuego arma = new ArmaDeFuego();

        Edificio banco = new Edificio(arma);

        Ciudad montreal = new Ciudad();
        montreal.agregarEdificio(banco);

        Rango rango = new Novato();

        Policia policia = new Policia(montreal, rango);

        Reloj reloj = new Reloj(new Tiempo(168.0)); //hs en 1 semana
        AlgoThief juego = new AlgoThief();
        CasoAsignado casoAsignado = new CasoAsignado(juego);
        policia.setCaso(casoAsignado);
        policia.visitar(banco, reloj);
        assertEquals(new Tiempo(5),reloj.tiempoTranscurrido());

    }

    @Test
    public void  InteractuoConCuchillo(){
        Cuchillo arma = new Cuchillo();

        Edificio banco = new Edificio(arma);

        Ciudad montreal = new Ciudad();
        montreal.agregarEdificio(banco);

        Rango rango = new Novato();

        Policia policia = new Policia(montreal, rango);

        Reloj reloj = new Reloj(new Tiempo(168.0)); //hs en 1 semana
        AlgoThief juego = new AlgoThief();
        CasoAsignado casoAsignado = new CasoAsignado(juego);
        policia.setCaso(casoAsignado);
        policia.visitar(banco, reloj);
        assertEquals(new Tiempo(3),reloj.tiempoTranscurrido());

    }

    @Test
    public void  InteractuoConPista(){
        Pista pista = new Pista("Hola");

        Edificio banco = new Edificio(pista);

        Ciudad montreal = new Ciudad();
        montreal.agregarEdificio(banco);

        Rango rango = new Novato();

        Policia policia = new Policia(montreal, rango);

        Reloj reloj = new Reloj(new Tiempo(168.0)); //hs en 1 semana
        AlgoThief juego = new AlgoThief();
        CasoAsignado casoAsignado = new CasoAsignado(juego);
        policia.setCaso(casoAsignado);
        policia.visitar(banco, reloj);
        assertEquals(new Tiempo(1),reloj.tiempoTranscurrido());

    }
}
