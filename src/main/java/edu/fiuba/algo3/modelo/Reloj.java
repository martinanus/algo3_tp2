package edu.fiuba.algo3.modelo;

public class Reloj {
    private double transcurrido;

    public Reloj() {
        transcurrido = 0;
    }

    public void incrementar(double i) {
        transcurrido = transcurrido + i;
    }

    public double mostrar() {
        return transcurrido;
    }
}
