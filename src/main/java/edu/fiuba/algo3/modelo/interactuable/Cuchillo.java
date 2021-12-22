package edu.fiuba.algo3.modelo.interactuable;

import edu.fiuba.algo3.modelo.Policia;
import edu.fiuba.algo3.modelo.tiempo.Reloj;
import edu.fiuba.algo3.modelo.tiempo.Tiempo;

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

    @Override
    public String mostrar(){
        return "Te han acuchillado.";
    }
}
