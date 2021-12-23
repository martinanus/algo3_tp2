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

public class Policia {
    private Ciudad ciudadActual;
    private Rango rango;
    private EstadoOrdenArresto orden = new OrdenNoEmitida();
    private Caso caso;
    private String nombre;


    public Policia(Ciudad ciudad) {
        ciudadActual = ciudad;
        caso = new CasoNoAsignado();
    }

    public Policia(Ciudad ciudad, Rango rango) {
        ciudadActual = ciudad;
        this.rango = rango;
        orden = new OrdenNoEmitida();
        caso = new CasoNoAsignado();
    }

    public Policia(Rango rangoInicial) {
        this.rango = rangoInicial;
    }

    public Policia(String nombre) {
        this.rango = new Novato();
        this.nombre = nombre;
        caso = new CasoNoAsignado();
    }
    public Policia(String nombre,Rango rangoInicial) {
        this.rango = rangoInicial;
        this.nombre = nombre;
        caso = new CasoNoAsignado();
    }

    public Policia() {
        this.rango = new Novato();
        this.nombre = "";
        caso = new CasoNoAsignado();
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
            try {
                this.orden.arrestar(this);
                caso.finalizar();
            } catch(OrdenNoEmitidadError e) {
                caso.finalizarSinExito();
            }
    }

    public void sumarArresto(int arrestoASumar) {
        this.rango = this.rango.sumarArrestos(arrestoASumar);
    }


    public void emitirOrdenArresto(Computadora computadora, Ladron ladron, Reloj reloj){
        orden = computadora.emitirOrdenDeArresto2(ladron, reloj, this.caso.getLadron());
    }

    public Rango rangoPolicia() {
        return this.rango;
    }


    public void generarCaso(ArrayList<Objeto> objetosRobados, ArrayList<Ciudad> ciudades,Ladron ladron, AlgoThief algoThief) {
        Caso caso =  rango.generarCaso(objetosRobados, ciudades,ladron, algoThief);
        caso.completarListasCiudadeDestino(ciudades);
        this.ciudadActual= (caso.getCiudadOrigen());
        this.setCaso(caso);

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String mostrarCiudadActual() {
        return ciudadActual.getNombre();
    }

    public String mostrarCiudadesDisponibles() {
        return ciudadActual.mostrarCiudadesDisponibles();
    }

    public Caso getCaso(){
        return caso;
    }

    public void setCaso(Caso caso){
        this.caso = caso;
    }

    public Ciudad getCiudadActual() {
        return ciudadActual;
    }

    public String getDescripcionCaso() {
        return caso.getDescripcion();

    }

    public String mostrarOrden() {
        return this.orden.mostrarOrden(this.caso.getNombreLadron());
    }

    public String mostrarRango() {
        return this.rango.mostrar();
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getNombreLadron() {
        return this.caso.getNombreLadron();
    }

    public void reiniciarOrden(){
        this.orden = new OrdenNoEmitida();
    }
}


