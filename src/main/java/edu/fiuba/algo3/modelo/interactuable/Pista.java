package edu.fiuba.algo3.modelo.interactuable;

import edu.fiuba.algo3.modelo.Policia;
import edu.fiuba.algo3.modelo.Reloj;

public class Pista implements Interactuable {
    private String contenido;


    public Pista(String contenido) {
        this.contenido = contenido;
    }

    public String mostrar(){
        return contenido;
    }

    @Override
    public void interactuar(Policia policia, Reloj reloj) {
        //Mostar por pantalla
    }
}
