package edu.fiuba.algo3.modelo.rango;

import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.Reloj;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.rango.Rango;

public class Investigador implements Rango {
    private double velocidad;


    public Investigador() {
        velocidad = 1300;
    }

    @Override
    public void viajar(Ciudad ciudadOrigen, Ciudad ciudadDestino, Reloj reloj) {
        double tiempo = (int)(ciudadDestino.tiempoViaje(ciudadOrigen, velocidad));
        reloj.incrementar(new Tiempo(tiempo));
    }


    @Override
    public Rango verificarCantidadArrestos(int contadorArrestos) {
        if( contadorArrestos >= 20)
            return new Sargento();
        return this;
    }

}
