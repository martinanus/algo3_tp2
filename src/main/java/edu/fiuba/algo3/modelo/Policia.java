package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.interactuable.Interactuable;
import edu.fiuba.algo3.modelo.interactuable.Ladron;
import edu.fiuba.algo3.modelo.objeto.Objeto;
import edu.fiuba.algo3.modelo.ordenesArresto.EstadoOrdenArresto;
import edu.fiuba.algo3.modelo.ordenesArresto.OrdenNoEmitida;
import edu.fiuba.algo3.modelo.ordenesArresto.OrdenNoEmitidadError;
import edu.fiuba.algo3.modelo.rango.Novato;
import edu.fiuba.algo3.modelo.rango.Rango;
import edu.fiuba.algo3.modelo.tiempo.Reloj;
import edu.fiuba.algo3.modelo.tiempo.Tiempo;

import java.util.ArrayList;
import java.util.HashMap;

public class Policia {
    private Ciudad ciudadActual;
    private Rango rango;
    private EstadoOrdenArresto orden = new OrdenNoEmitida();
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
    public Policia(String nombre,Rango rangoInicial) {
        this.rango = rangoInicial;
        this.nombre = nombre;
    }

    public Policia() {
        this.rango = new Novato();
        this.nombre = "";
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
        if (caso != null)
            try {
                this.orden.arrestar(this);
                caso.finalizar();
            } catch(OrdenNoEmitidadError e) {
                caso.finalizarSinExito();
            }
        else
            this.orden.arrestar(this);
    }

    public void sumarArresto(int arrestoASumar) {
        this.rango = this.rango.sumarArrestos(arrestoASumar);
    }


    public void emitirOrdenArresto(Computadora computadora, Ladron ladron, Reloj reloj){
        orden = computadora.emitirOrdenDeArresto(ladron, reloj);
    }

    public Rango rangoPolicia() {
        return this.rango;
    }


    public void generarCaso(ArrayList<Objeto> objetosRobados, HashMap<String, ArrayList<Ciudad>> recorridoLadron,Ladron ladron, AlgoThief algoThief) {
        Caso unCaso =  rango.generarCaso(objetosRobados,recorridoLadron,ladron, algoThief);
        this.ciudadActual= (unCaso.getCiudadOrigen());
        this.caso = unCaso;

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String mostrarCiudadActual() {
        return ciudadActual.getNombre();
    }

    public String mostrarRango() {
        return rango.mostrarRango();
    }
}


