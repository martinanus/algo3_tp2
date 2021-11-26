package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Ciudad {
    private ArrayList<Edificio> edificios;
    private String nombreCiudad;
    private double distancia;

    public Ciudad() {
        this.edificios = new ArrayList<>();
    }

    public Ciudad(double distancia) {
        this.distancia = distancia;
        this.edificios = new ArrayList<>();
    }

    public Pista visitar(Edificio edificioNombre ,Reloj reloj){
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

    public double viajar(double velocidad) {
        return distancia / velocidad;
    }
}
