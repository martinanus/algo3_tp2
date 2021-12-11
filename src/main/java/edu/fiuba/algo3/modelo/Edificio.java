package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.interactuable.Interactuable;

public class Edificio {
    private Interactuable interactuable;
    private int contadorDeVisitas;

    public Edificio(Interactuable unInteractuable) {
        interactuable = unInteractuable ;
        contadorDeVisitas = 0;
    }

    public Interactuable visitar(Reloj reloj){
        contadorDeVisitas = contadorDeVisitas + 1;
        if (contadorDeVisitas <= 3) {
            reloj.incrementar(new Tiempo(contadorDeVisitas));
        }
        else {
            reloj.incrementar(new Tiempo(3));
        }
        return interactuable;
    }
}
