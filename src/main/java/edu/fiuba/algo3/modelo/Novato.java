package edu.fiuba.algo3.modelo;

public class Novato implements Rango{
    private double velocidad;
    //private int arrestos;


    public Novato() {
        velocidad = 900;
    }


    @Override
    public void viajar(Ciudad ciudadOrigen, Ciudad ciudadDestino, Reloj reloj) {
        double tiempo = ciudadDestino.viajar(ciudadOrigen,velocidad);
        reloj.incrementar(tiempo);
    }
}
