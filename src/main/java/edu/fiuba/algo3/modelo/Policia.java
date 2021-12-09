package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interactuable.Interactuable;
import edu.fiuba.algo3.modelo.Interactuable.Ladron;
import edu.fiuba.algo3.modelo.ordenesArresto.EstadoOrdenArresto;
import edu.fiuba.algo3.modelo.ordenesArresto.OrdenEmitida;
import edu.fiuba.algo3.modelo.ordenesArresto.OrdenNoEmitida;
import edu.fiuba.algo3.modelo.rango.Rango;

public class Policia {
    private Ciudad ciudadActual;
    private Mision mision;
    private Rango rango;
    private EstadoOrdenArresto orden;
    private int contadorArrestos;

    public Policia(Ciudad ciudad) {
        ciudadActual = ciudad;
        mision = new Mision();
    }

    public Policia(Ciudad ciudad, Rango rango) {
        ciudadActual = ciudad;
        mision = new Mision();
        this.rango = rango;
        orden = new OrdenNoEmitida();
        contadorArrestos = 0;
    }

    public Interactuable visitar(Edificio edificio , Reloj reloj ){
        return ciudadActual.visitar(edificio,reloj);
    }

    public void viajar(Ciudad ciudadDestino, Reloj reloj) {
        rango.viajar(ciudadActual,ciudadDestino, reloj);
        this.ciudadActual = ciudadDestino;
    }

    public void duerme(Reloj reloj) {
        reloj.incrementar(new Tiempo(8)); //duerme 8hs
    }


    public void terminarMision() {
        this.orden.terminarMision(this);
    }

    public void sumarArresto(int arrestoASumar) {
        contadorArrestos +=arrestoASumar;
        this.rango = this.rango.verificarCantidadArrestos(contadorArrestos);
    }
    public int  getCantidadArrestos() {
        return this.contadorArrestos;
    }


    public void emitirOrdenArresto(Computadora computadora, Ladron ladron){
        if(computadora.emitirOrdenDeArresto(ladron)){
            orden = new OrdenEmitida();
        }
    }

}


