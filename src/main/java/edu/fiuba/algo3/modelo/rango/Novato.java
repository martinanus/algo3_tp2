package edu.fiuba.algo3.modelo.rango;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.interactuable.Ladron;
import edu.fiuba.algo3.modelo.objeto.Objeto;
import edu.fiuba.algo3.modelo.tiempo.Reloj;
import edu.fiuba.algo3.modelo.tiempo.Tiempo;

import java.util.ArrayList;
import java.util.HashMap;

public class Novato implements Rango {
    private double velocidad;
    private int contadorArrestos;


    public Novato() {
        velocidad = 900;
    }


    @Override
    public void viajar(Ciudad ciudadOrigen, Ciudad ciudadDestino, Reloj reloj) {
        double tiempo = (int) (ciudadDestino.tiempoViaje(ciudadOrigen, velocidad));
        reloj.incrementar(new Tiempo(tiempo));
    }

    @Override
    public Rango sumarArrestos(int arrestoASumar) {
        this.contadorArrestos += arrestoASumar;
        if (contadorArrestos >= 5)
            return new Detective();
        return this;
    }

    //Novato Solo va a ejecutar casos con objetos Comunes.
    //Aca el policia todavia no sabe nisiquiera en donde esta parado y el objeto nos dice en donde estan parado
    @Override
    public Caso generarCaso(ArrayList<Objeto> objetosRobados, HashMap<String, ArrayList<Ciudad>> recorridoLadron, Ladron ladron) {
        Objeto objetoRobado= new Objeto();
        for (Objeto objeto : objetosRobados) {
           if (objeto.esDeRareza("Comun")) {
               objetoRobado = objeto;
               //objetosRobados.remove(objeto); //si el jugador gana // Se queda con el ultimo si gana el caso se elimina
            }
        }

        Caso caso = new Caso(objetoRobado,recorridoLadron.get( objetoRobado.getCiudadOrigen() ),ladron);
        caso.cargarEdificios();
        return caso;
    }

}