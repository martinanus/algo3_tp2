package edu.fiuba.algo3.modelo;

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
}
