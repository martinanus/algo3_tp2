package edu.fiuba.algo3.modelo;

public class Edificio {
    private Pista pista;
    private String nombre;
    private int contadorDeVisitas;

    public Edificio(Pista pistaEdificio) {
        pista = pistaEdificio;
        contadorDeVisitas = 0;
    }

    public Pista visitar(Reloj reloj){
        contadorDeVisitas = contadorDeVisitas + 1;
        if (contadorDeVisitas <= 3) {
            reloj.incrementar(new Tiempo(contadorDeVisitas));
        }
        else {
            reloj.incrementar(new Tiempo(3));
        }
        return pista;
    }
}
