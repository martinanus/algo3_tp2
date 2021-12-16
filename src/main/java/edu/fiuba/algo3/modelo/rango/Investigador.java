package edu.fiuba.algo3.modelo.rango;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.interactuable.Ladron;
import edu.fiuba.algo3.modelo.objeto.Objeto;

import java.util.ArrayList;
import java.util.HashMap;

public class Investigador implements Rango {
    private double velocidad;
    private int contadorArrestos;


    public Investigador() {
        velocidad = 1300;
        contadorArrestos = 10;
    }

    @Override
    public void viajar(Ciudad ciudadOrigen, Ciudad ciudadDestino, Reloj reloj) {
        double tiempo = (int)(ciudadDestino.tiempoViaje(ciudadOrigen, velocidad));
        reloj.incrementar(new Tiempo(tiempo));
    }

    @Override
    public Rango sumarArrestos(int arrestoASumar) {
        this.contadorArrestos += arrestoASumar;
        if( contadorArrestos >= 10)
            return new Sargento();
        return this;
    }

    @Override
    public Caso generarCaso(ArrayList<Objeto> objetosRobados, HashMap<String, ArrayList<Ciudad>> recorridoLadron, Ladron ladron) {
        return null;
    }

    //@Override
    //public Caso generarCaso() {

    //    return new Caso(new ObjetoMuyValioso("Huevo de Oro"));
    //}
}
