package edu.fiuba.algo3.modelo.interactuable;

import edu.fiuba.algo3.modelo.Policia;
import edu.fiuba.algo3.modelo.tiempo.Reloj;
import edu.fiuba.algo3.modelo.tiempo.Tiempo;

public class ArmaDeFuego implements Interactuable{
    @Override
    public void interactuar(Policia policia, Reloj reloj) {
        reloj.incrementar(new Tiempo(4));
    }
}
