package edu.fiuba.algo3.modelo.rango;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.interactuable.Ladron;
import edu.fiuba.algo3.modelo.objeto.Objeto;

import java.util.ArrayList;
import java.util.HashMap;

public class Detective implements Rango {
    private double velocidad;
    private int contadorArrestos;
    private ArrayList<Objeto> objetos;


    public Detective() {
        velocidad = 1100;
        contadorArrestos = 5;
        objetos = new ArrayList<>();
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
            return new Investigador();
        return this;
    }

    @Override
    public Caso generarCaso(ArrayList<Objeto> objetosRobados, HashMap<String, ArrayList<Ciudad>> recorridoLadron, Ladron ladron) {
        return null;
    }

    //@Override
    //public Caso generarCaso() {
    //    Collections.shuffle(objetos);
    //    return new Caso(objetos.get(0));
    //}
}
