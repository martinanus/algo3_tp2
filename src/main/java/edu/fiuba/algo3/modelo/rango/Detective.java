package edu.fiuba.algo3.modelo.rango;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.interactuable.Ladron;
import edu.fiuba.algo3.modelo.objeto.Objeto;
import edu.fiuba.algo3.modelo.objeto.ObjetoComun;
import edu.fiuba.algo3.modelo.objeto.ObjetoValioso;
import edu.fiuba.algo3.modelo.tiempo.Reloj;
import edu.fiuba.algo3.modelo.tiempo.Tiempo;
import java.util.ArrayList;

public class Detective implements Rango {
    private double velocidad;
    private int contadorArrestos;

    public Detective() {
        velocidad = 1100;
        contadorArrestos = 5;
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
            return new Investigador();
        return this;
    }

    @Override
    public Caso generarCaso(ArrayList<Objeto> objetosRobados,  ArrayList<Ciudad> ciudades , Ladron ladron, AlgoThief algoThief) {
        ArrayList<Objeto> objetosDetective = new ArrayList<>();
        for (Objeto objeto : objetosRobados) {
            if (objeto instanceof ObjetoComun || objeto instanceof ObjetoValioso) {
                objetosDetective.add(objeto);
            }
        }
        Objeto objetoRobado = objetosDetective.get( (int)(Math.random()* objetosDetective.size())   );

        ArrayList<Ciudad> ciudadesRecorridas = objetoRobado.generarRecorrido(ciudades);;
        for(Ciudad ciudad: ciudadesRecorridas){
            ciudad.tomarPistasMedias();
        }
        return new Caso(objetoRobado,ciudadesRecorridas,ladron, algoThief);
    }

    @Override
    public String mostrar() {
        return "Detective";
    }

}
