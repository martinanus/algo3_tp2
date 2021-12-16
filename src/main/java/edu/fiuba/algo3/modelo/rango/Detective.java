package edu.fiuba.algo3.modelo.rango;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.interactuable.Ladron;
import edu.fiuba.algo3.modelo.objeto.Objeto;
import edu.fiuba.algo3.modelo.tiempo.Reloj;
import edu.fiuba.algo3.modelo.tiempo.Tiempo;

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
    public Caso generarCaso(ArrayList<Objeto> objetosRobados, HashMap<String, ArrayList<Ciudad>> recorridoLadron, Ladron ladron, AlgoThief algoThief) {
        Objeto objetoRobado= new Objeto();
        for (Objeto objeto : objetosRobados) {
            if (objeto.esDeRareza("Comun")) {
                objetoRobado = objeto;
                //objetosRobados.remove(objeto); //si el jugador gana // Se queda con el ultimo si gana el caso se elimina
            }
        }           //HashMap = <"Lima;<ArrayList> >   =  <"Lima, [Lima,BuenosAires,El Cairo]  >
        ArrayList<Ciudad> ciudadesRecorridas =recorridoLadron.get( objetoRobado.getCiudadOrigen() );
        for(Ciudad ciudad: ciudadesRecorridas){
            ciudad.tomarPistasMedias();
        }

        return new Caso(objetoRobado,ciudadesRecorridas,ladron, algoThief);
    }
}
