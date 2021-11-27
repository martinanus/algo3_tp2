package edu.fiuba.algo3.modelo;

public class Novato implements Rango{
    private double velocidad;
    //private int arrestos;


    public Novato() {
        velocidad = 900;
    }


    @Override
    public void viajar(Ciudad ciudad, Reloj reloj) {
        double tiempo = ciudad.viajar(velocidad);
        reloj.incrementar(tiempo);
    }
}
