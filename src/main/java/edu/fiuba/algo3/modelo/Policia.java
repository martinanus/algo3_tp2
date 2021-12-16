package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.interactuable.Interactuable;
import edu.fiuba.algo3.modelo.interactuable.Ladron;
import edu.fiuba.algo3.modelo.objeto.Objeto;
import edu.fiuba.algo3.modelo.ordenesArresto.EstadoOrdenArresto;
import edu.fiuba.algo3.modelo.ordenesArresto.OrdenNoEmitida;
import edu.fiuba.algo3.modelo.rango.Novato;
import edu.fiuba.algo3.modelo.rango.Rango;

import java.util.ArrayList;
import java.util.HashMap;

public class Policia {
    private Ciudad ciudadActual;
    private Rango rango;
    private EstadoOrdenArresto orden;
    private Caso caso;
    private String nombre;


    public Policia(Ciudad ciudad) {
        ciudadActual = ciudad;
    }

    public Policia(Ciudad ciudad, Rango rango) {
        ciudadActual = ciudad;
        this.rango = rango;
        orden = new OrdenNoEmitida();
    }

    public Policia(Rango rangoInicial) {
        this.rango = rangoInicial;
    }

    public Policia(String nombre) {
        this.rango = new Novato();
        this.nombre = nombre;
    }


    public Interactuable visitar(Edificio edificio , Reloj reloj ){
        Interactuable interac =ciudadActual.visitar(edificio,reloj);
        interac.interactuar(this,reloj);
        return  interac;
    }
    public Interactuable visitar(String nombreEdificio , Reloj reloj ){
        Interactuable interac =ciudadActual.visitar(nombreEdificio,reloj);
        interac.interactuar(this,reloj);
        return  interac;
    }

    public void viajar(Ciudad ciudadDestino, Reloj reloj) {
        rango.viajar(ciudadActual,ciudadDestino, reloj);
        this.ciudadActual = ciudadDestino;
    }

    public void duerme(Reloj reloj) {
        reloj.incrementar(new Tiempo(8)); //duerme 8hs
    }


    public void arrestar() {
        this.orden.arrestar(this);
        //mision.terminarMision(); //incrementa reloj al tiempo max,
    }

    public void sumarArresto(int arrestoASumar) {
        this.rango = this.rango.sumarArrestos(arrestoASumar);
    }


    public void emitirOrdenArresto(Computadora computadora, Ladron ladron){
        orden = computadora.emitirOrdenDeArresto(ladron);
    }

    public Rango rangoPolicia() {
        return this.rango;
    }


    public void generarCaso(ArrayList<Objeto> objetosRobados, HashMap<String, ArrayList<Ciudad>> recorridoLadron,Ladron ladron) {
        Caso unCaso =  rango.generarCaso(objetosRobados,recorridoLadron,ladron);
        this.ciudadActual= (unCaso.getCiudadOrigen());
        this.caso = unCaso;

    }
}


