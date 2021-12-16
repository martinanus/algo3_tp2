package edu.fiuba.algo3.modelo.rango;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.interactuable.Ladron;
import edu.fiuba.algo3.modelo.objeto.Objeto;
import edu.fiuba.algo3.modelo.objeto.ObjetoComun;
import edu.fiuba.algo3.modelo.objeto.ObjetoMuyValioso;
import edu.fiuba.algo3.modelo.tiempo.Reloj;
import edu.fiuba.algo3.modelo.tiempo.Tiempo;

import java.util.ArrayList;
import java.util.HashMap;

public class Sargento implements Rango {
    private double velocidad;
    private int contadorArrestos;


    public Sargento() {
        velocidad = 1500;
        contadorArrestos = 20;
    }

    @Override
    public void viajar(Ciudad ciudadOrigen, Ciudad ciudadDestino, Reloj reloj) {
        double tiempo = (int)(ciudadDestino.tiempoViaje(ciudadOrigen, velocidad));
        reloj.incrementar(new Tiempo(tiempo));
    }


    @Override
    public Rango sumarArrestos(int arrestoASumar) {
        contadorArrestos += arrestoASumar;
        return this;
    }
    @Override
    public Caso generarCaso(ArrayList<Objeto> objetosRobados, HashMap<String, ArrayList<Ciudad>> recorridoLadron, Ladron ladron, AlgoThief algoThief) {
        Objeto objetoRobado= new ObjetoMuyValioso();
        for (Objeto objeto : objetosRobados) {
            if (objeto instanceof ObjetoMuyValioso) {
                objetoRobado = objeto;
            }
        }
        ArrayList<Ciudad> ciudadesRecorridas = recorridoLadron.get( objetoRobado.getCiudadOrigen() );
        for(Ciudad ciudad: ciudadesRecorridas){
            ciudad.tomarPistasDificil();
        }
        return new Caso(objetoRobado,ciudadesRecorridas,ladron, algoThief);
    }

}
