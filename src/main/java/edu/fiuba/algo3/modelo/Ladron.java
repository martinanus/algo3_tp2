package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.lector.Descripcion;

public class Ladron {
    private final Descripcion descripcion;

    public Ladron(Descripcion descripcion) {
        this.descripcion = descripcion;
    }

    public boolean compararCon(Ladron sospechosoBuscado) {
        return sospechosoBuscado.comparar(this.descripcion);
    }

    private boolean comparar(Descripcion otraDescripcion) {
        return descripcion.comparar(otraDescripcion);
    }
}
