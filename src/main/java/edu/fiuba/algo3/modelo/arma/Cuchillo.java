package edu.fiuba.algo3.modelo.arma;

import edu.fiuba.algo3.modelo.Reloj;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.arma.Arma;

public class Cuchillo extends Arma {

    private int contadorAtaques = 0;

    @Override
    public void herir(Reloj reloj) {
        if (contadorAtaques == 0){
            reloj.incrementar(new Tiempo(2));
        } else {
            reloj.incrementar(new Tiempo(1));
        }
        contadorAtaques++;
    }
}
