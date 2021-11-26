package edu.fiuba.algo3.modelo;

public class Edificio {
    private Pista pista;
    private String nombre;
    private int contadorDeVisitas;

    public Edificio(Pista pistaEdificio) {
        pista = pistaEdificio;
    }

    public Pista visitar(Reloj reloj) {
        reloj.incrementar(1);
        return pista;
    }
}
