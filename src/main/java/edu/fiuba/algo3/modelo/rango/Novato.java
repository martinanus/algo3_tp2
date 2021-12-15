package edu.fiuba.algo3.modelo.rango;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.objeto.ObjetoComun;

public class Novato implements Rango {
    private double velocidad;
    private int contadorArrestos;


    public Novato() {
        velocidad = 900;
    }


    @Override
    public void viajar(Ciudad ciudadOrigen, Ciudad ciudadDestino, Reloj reloj) {
        double tiempo = (int)(ciudadDestino.tiempoViaje(ciudadOrigen, velocidad));
        reloj.incrementar(new Tiempo(tiempo));
    }

    @Override
    public Rango sumarArrestos(int arrestoASumar) {
        this.contadorArrestos += arrestoASumar;
        if( contadorArrestos >= 5)
            return new Detective();
        return this;
    }

    //@Override
    //public Caso generarCaso() {
    //    return new Caso (new ObjetoComun() );
    //}

}
