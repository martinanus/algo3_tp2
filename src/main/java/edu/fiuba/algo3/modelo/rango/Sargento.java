package edu.fiuba.algo3.modelo.rango;

import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.Reloj;
import edu.fiuba.algo3.modelo.Tiempo;

public class Sargento implements Rango {
    private double velocidad;
    private int contadorArrestos;


    public Sargento() {
        velocidad = 1500;
        contadorArrestos = 20;
    }

    @Override
    public void viajar(Ciudad ciudadOrigen, Ciudad ciudadDestino, Reloj reloj) {
        double tiempo = (int)(ciudadDestino.tiempoViaje(ciudadOrigen, velocidad));
        reloj.incrementar(new Tiempo(tiempo));
    }


    @Override
    public Rango sumarArrestos(int arrestoASumar) {
        contadorArrestos += arrestoASumar;
        return this;
    }
}
