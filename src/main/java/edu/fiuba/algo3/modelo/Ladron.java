package edu.fiuba.algo3.modelo;

public class Ladron {
    private Descripcion descripcion;

    public Ladron(Descripcion descripcion) {
        this.descripcion = descripcion;
    }

    public boolean compararCon(Ladron sospechosoBuscado) {
        return this.descripcion.comparar(sospechosoBuscado.descripcion());
    }

    private Descripcion descripcion(){
        return this.descripcion;
    }

    private boolean comparar(Descripcion otraDescripcion) {
        return this.descripcion.comparar(otraDescripcion);
    }

}
