package edu.fiuba.algo3.modelo.interactuable;

import edu.fiuba.algo3.modelo.Policia;
import edu.fiuba.algo3.modelo.tiempo.Reloj;

public interface Interactuable {

    String mostrar();
    void interactuar(Policia policia, Reloj reloj);
}
