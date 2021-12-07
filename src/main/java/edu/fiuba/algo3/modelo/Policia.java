package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.arma.Arma;
import edu.fiuba.algo3.modelo.rango.Rango;

public class Policia {
    private Ciudad ciudadActual;
    private Mision mision;
    private Rango rango;

    public Policia(Ciudad ciudad) {
        ciudadActual = ciudad;
        mision = new Mision();
    }

    public Policia(Ciudad ciudad, Rango rango) {
        ciudadActual = ciudad;
        mision = new Mision();
        this.rango = rango;
    }

    public Pista visitar(Edificio edificio ,Reloj reloj ){
        return ciudadActual.visitar(edificio,reloj);
    }

    public void viajar(Ciudad ciudadDestino, Reloj reloj) {
        rango.viajar(ciudadActual,ciudadDestino, reloj);
        this.ciudadActual = ciudadDestino;
    }

    public void duerme(Reloj reloj) {
        reloj.incrementar(new Tiempo(8)); //duerme 8hs
    }

    public void herir(Arma arma, Reloj reloj) {
        arma.herir(reloj);
    }
}


