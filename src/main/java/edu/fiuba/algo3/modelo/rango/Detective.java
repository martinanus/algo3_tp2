package edu.fiuba.algo3.modelo.rango;

import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.Reloj;
import edu.fiuba.algo3.modelo.Tiempo;

public class Detective implements Rango {
    private double velocidad;
    private int contadorArrestos;

    public Detective() {
        velocidad = 1100;
        contadorArrestos = 5;
    }

    @Override
    public void viajar(Ciudad ciudadOrigen, Ciudad ciudadDestino, Reloj reloj) {
        double tiempo = (int)(ciudadDestino.tiempoViaje(ciudadOrigen, velocidad));
        reloj.incrementar(new Tiempo(tiempo));
    }

    @Override
    public Rango sumarArrestos(int arrestoASumar) {
        this.contadorArrestos += arrestoASumar;
        if( contadorArrestos >= 5)
            return new Investigador();
        return this;
    }
}
