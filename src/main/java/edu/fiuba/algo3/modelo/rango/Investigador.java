package edu.fiuba.algo3.modelo.rango;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.interactuable.Ladron;
import edu.fiuba.algo3.modelo.objeto.Objeto;
import edu.fiuba.algo3.modelo.objeto.ObjetoValioso;
import edu.fiuba.algo3.modelo.tiempo.Reloj;
import edu.fiuba.algo3.modelo.tiempo.Tiempo;

import java.util.ArrayList;

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
        if( contadorArrestos >= 20)
            return new Sargento();
        return this;
    }

    @Override
    public Caso generarCaso(ArrayList<Objeto> objetosRobados,  ArrayList<Ciudad> ciudades, Ladron ladron, AlgoThief algoThief) {
        Objeto objetoRobado= new ObjetoValioso();
        for (Objeto objeto : objetosRobados) {
            if (objeto instanceof ObjetoValioso) {
                objetoRobado = objeto;
            }
        }
        ArrayList<Ciudad> ciudadesRecorridas = objetoRobado.generarRecorrido(ciudades);;
        for(Ciudad ciudad: ciudadesRecorridas){
            ciudad.tomarPistasMedias();
        }

        return new Caso(objetoRobado,ciudadesRecorridas,ladron, algoThief);
    }

}
