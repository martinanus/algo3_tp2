package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.interactuable.Interactuable;

import java.util.ArrayList;
import java.util.Objects;

public class Ciudad {
    private ArrayList<Edificio> edificios;
    private Posicion posicion;
    private String nombre;
    private DescripcionCiudad descripcion;

    public Ciudad() {
        this.edificios = new ArrayList<>();
    }

    public Ciudad(Posicion posicion,String Nombre,DescripcionCiudad descripcion) {
        this.posicion = posicion;
        this.edificios = new ArrayList<>();
        this.nombre = Nombre;
        this.descripcion = descripcion;
    }

    public Ciudad(Posicion posicion) {
        this.posicion = posicion;
        this.edificios = new ArrayList<>();
    }

    public Interactuable visitar(Edificio edificioNombre , Reloj reloj){
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

    public boolean conNombreIgualA(String nombreCiudad) {
        return (Objects.equals(this.nombre, nombreCiudad));
    }

    public String getNombre() {
        return nombre;
    }
}
