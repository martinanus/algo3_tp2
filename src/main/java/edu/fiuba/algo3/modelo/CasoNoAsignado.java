package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.interactuable.Ladron;

import java.util.ArrayList;

public class CasoNoAsignado extends Caso {


    public void finalizar() {
        throw new CasoNoAsignadoError();
    }

    public void finalizarSinExito() {

    }

    public Ladron getLadron() {
        throw new CasoNoAsignadoError();
    }

    public String getDescripcion() {
        throw new CasoNoAsignadoError();
    }

    public String getNombreLadron() {
        throw new CasoNoAsignadoError();
    }

    public void completarListasCiudadeDestino(ArrayList<Ciudad> ciudades) {
        throw new CasoNoAsignadoError();
    }

    public Ciudad getCiudadOrigen() {
        throw new CasoNoAsignadoError();
    }


    public ArrayList<Ciudad> ciudadesLadron() {
        throw new CasoNoAsignadoError();
    }


}
