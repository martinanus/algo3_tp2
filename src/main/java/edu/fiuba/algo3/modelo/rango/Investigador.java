package edu.fiuba.algo3.modelo.rango;

import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.Reloj;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.rango.Rango;

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
}
