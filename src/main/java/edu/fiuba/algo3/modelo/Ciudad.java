package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interactuable.Interactuable;

import java.util.ArrayList;

public class Ciudad {
    private ArrayList<Edificio> edificios;
    private String nombreCiudad;
    private Posicion posicion;

    public Ciudad() {
        this.edificios = new ArrayList<>();
    }

    public Ciudad(Posicion posicion) {
        this.posicion = posicion;
        this.edificios = new ArrayList<>();
    }

    public Interactuable visitar(Edificio edificioNombre , Reloj reloj){
        //"this.edificio.nombre() = edificio"
        Edificio edificio= this.buscarEdificio(edificioNombre);
        return edificio.visitar(reloj);
    }

    private Edificio buscarEdificio(Edificio edificioNombre) {
        return edificios.get(edificios.indexOf(edificioNombre));
    }

    public void agregarEdificio(Edificio edificio) {
        edificios.add(edificio);
    }

    public double tiempoViaje(Ciudad origen, double velocidad) {
        return  calcularDistanciaCon(origen) / velocidad;
    }

    private double calcularDistanciaCon(Ciudad origen) {
        return origen.calcularDistancia(this.posicion);
    }

    private double calcularDistancia(Posicion posicion) {
        return this.posicion.calcularDistanciaCon(posicion);
    }

}
