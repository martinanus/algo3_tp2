package edu.fiuba.algo3.modelo.Interactuable;

import edu.fiuba.algo3.modelo.Interactuable.Interactuable;
import edu.fiuba.algo3.modelo.Policia;
import edu.fiuba.algo3.modelo.Reloj;
import edu.fiuba.algo3.modelo.Tiempo;

public class Cuchillo implements Interactuable {

    private int contadorAtaques = 0;

    @Override
    public void interactuar(Policia policia, Reloj reloj) {
        if (contadorAtaques == 0){
            reloj.incrementar(new Tiempo(2));
        } else {
            reloj.incrementar(new Tiempo(1));
        }
        contadorAtaques++;
    }
}
