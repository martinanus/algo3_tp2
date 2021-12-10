package edu.fiuba.algo3.modelo.rango;

import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.Reloj;
import edu.fiuba.algo3.modelo.Tiempo;

public class Detective implements Rango {
    private double velocidad;

    public Detective() {
        velocidad = 1100;
    }

    @Override
    public void viajar(Ciudad ciudadOrigen, Ciudad ciudadDestino, Reloj reloj) {
        double tiempo = (int)(ciudadDestino.tiempoViaje(ciudadOrigen, velocidad));
        reloj.incrementar(new Tiempo(tiempo));
    }

    @Override
    public Rango arrestar(int contadorArrestos) {
        if( contadorArrestos >= 10)
            return new Investigador();
        return this;
    }
}
