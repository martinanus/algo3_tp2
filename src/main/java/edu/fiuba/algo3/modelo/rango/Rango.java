package edu.fiuba.algo3.modelo.rango;

import edu.fiuba.algo3.modelo.AlgoThief;
import edu.fiuba.algo3.modelo.CasoAsignado;
import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.tiempo.Reloj;
import edu.fiuba.algo3.modelo.interactuable.Ladron;
import edu.fiuba.algo3.modelo.objeto.Objeto;

import java.util.ArrayList;

public interface Rango {

    void viajar(Ciudad ciudadOrigen, Ciudad ciudadDestino, Reloj reloj);

    Rango sumarArrestos(int arrestoASumar);

    CasoAsignado generarCaso(ArrayList<Objeto> objetosRobados, ArrayList<Ciudad> ciudades, Ladron ladron, AlgoThief algoThief);

    String mostrar();
}
