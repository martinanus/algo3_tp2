package edu.fiuba.algo3.modelo.Interactuable;

import edu.fiuba.algo3.modelo.Descripcion;
import edu.fiuba.algo3.modelo.Policia;
import edu.fiuba.algo3.modelo.Reloj;

public class Ladron implements Interactuable{
    private Descripcion descripcion;

    public Ladron(Descripcion descripcion) {
        this.descripcion = descripcion;
    }

    public boolean compararCon(Ladron sospechosoBuscado) {
        return sospechosoBuscado.comparar(this.descripcion);
    }


    private boolean comparar(Descripcion otraDescripcion) {
        return this.descripcion.comparar(otraDescripcion);
    }



    @Override
    public void interactuar(Policia policia, Reloj reloj) {

        policia.terminarMision();
    }
}
