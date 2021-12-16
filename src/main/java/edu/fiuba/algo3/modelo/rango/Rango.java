package edu.fiuba.algo3.modelo.rango;

import edu.fiuba.algo3.modelo.AlgoThief;
import edu.fiuba.algo3.modelo.Caso;
import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.tiempo.Reloj;
import edu.fiuba.algo3.modelo.interactuable.Ladron;
import edu.fiuba.algo3.modelo.objeto.Objeto;

import java.util.ArrayList;
import java.util.HashMap;

public interface Rango {

    void viajar(Ciudad ciudadOrigen, Ciudad ciudadDestino, Reloj reloj);

    Rango sumarArrestos(int arrestoASumar);

    Caso generarCaso(ArrayList<Objeto> objetosRobados, HashMap<String, ArrayList<Ciudad>> recorridoLadron, Ladron ladron, AlgoThief algoThief);

    //Caso generarCaso();
}
