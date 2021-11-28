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

    public double viajar(Ciudad ciudadDestino, double velocidad) {

        return  distanciaCalcular(ciudadDestino) / velocidad;
    }

    private double distanciaCalcular(Ciudad destino){
        CalcuDistanciaCiud calculadora = new CalcuDistanciaCiud();
        double distancia = calculadora.calcularDistancia(this,destino);
        return distancia;
    }
    //PRIMERA SOLUCION una calculadora de distancia que dado dos ciudades nos devuelva
    // la distancia entre ellas, no nos importa como lo hara.
    //SEGUNDA SOLUCION: Tener una clase Mapa que tiene una calculadora de distancia
    //Mapa delega en ciudad viajar y visitar. Jugador le paso la ciudad de destino y el mapa.
    //Mapa verifica que el destino exista.
    //Mapa tenga una lista de ciudades,

}
