package edu.fiuba.algo3.modelo.rango;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.objeto.ObjetoComun;
import edu.fiuba.algo3.modelo.objeto.ObjetoMuyValioso;

public class Investigador implements Rango {
    private double velocidad;
    private int contadorArrestos;


    public Investigador() {
        velocidad = 1300;
        contadorArrestos = 10;
    }

    @Override
    public void viajar(Ciudad ciudadOrigen, Ciudad ciudadDestino, Reloj reloj) {
        double tiempo = (int)(ciudadDestino.tiempoViaje(ciudadOrigen, velocidad));
        reloj.incrementar(new Tiempo(tiempo));
    }

    @Override
    public Rango sumarArrestos(int arrestoASumar) {
        this.contadorArrestos += arrestoASumar;
        if( contadorArrestos >= 10)
            return new Sargento();
        return this;
    }

    @Override
    public Caso generarCaso() {


        return new Caso(new ObjetoMuyValioso());
    }
}
