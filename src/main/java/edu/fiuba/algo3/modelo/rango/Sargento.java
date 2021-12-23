package edu.fiuba.algo3.modelo.rango;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.interactuable.Ladron;
import edu.fiuba.algo3.modelo.objeto.Objeto;
import edu.fiuba.algo3.modelo.objeto.ObjetoComun;
import edu.fiuba.algo3.modelo.objeto.ObjetoMuyValioso;
import edu.fiuba.algo3.modelo.objeto.ObjetoValioso;
import edu.fiuba.algo3.modelo.tiempo.Reloj;
import edu.fiuba.algo3.modelo.tiempo.Tiempo;

import java.util.ArrayList;

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
    public CasoAsignado generarCaso(ArrayList<Objeto> objetosRobados, ArrayList<Ciudad> ciudades, Ladron ladron, AlgoThief algoThief) {
        ArrayList<Objeto> objetosSargento= new ArrayList<>();
        for (Objeto objeto : objetosRobados) {
            if (objeto instanceof ObjetoComun || objeto instanceof ObjetoValioso || objeto instanceof ObjetoMuyValioso) {
                objetosSargento.add(objeto);
            }
        }
        Objeto objetoRobado = objetosSargento.get( (int)(Math.random()* objetosSargento.size())   );

        ArrayList<Ciudad> ciudadesRecorridas = objetoRobado.generarRecorrido(ciudades);
        for(Ciudad ciudad: ciudadesRecorridas){
            ciudad.tomarPistasDificil();
        }

        return new CasoAsignado(objetoRobado,ciudadesRecorridas,ladron, algoThief);
    }

    @Override
    public String mostrar() {
        return "Sargento";
    }


}
