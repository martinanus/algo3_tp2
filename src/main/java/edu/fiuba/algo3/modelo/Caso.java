package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.interactuable.Ladron;

import java.util.ArrayList;

public abstract class   Caso {

    public abstract void finalizar();

    public abstract void finalizarSinExito();

    public abstract Ladron getLadron();

    public abstract String getDescripcion();

    public abstract String getNombreLadron();

    public abstract void completarListasCiudadeDestino(ArrayList<Ciudad> ciudades);

    public abstract Ciudad getCiudadOrigen();

    public abstract ArrayList<Ciudad> ciudadesLadron();

}
