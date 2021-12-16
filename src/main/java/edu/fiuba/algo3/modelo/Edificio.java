package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.interactuable.Interactuable;
import edu.fiuba.algo3.modelo.tiempo.Reloj;
import edu.fiuba.algo3.modelo.tiempo.Tiempo;

public class Edificio {
    private Interactuable interactuable;
    private int contadorDeVisitas;
    private String nombreEdificio;
    public Edificio(Interactuable unInteractuable) {
        interactuable = unInteractuable ;
        contadorDeVisitas = 0;
    }

    public Edificio(Interactuable unInteractuable, String nombreEdificio) {
        interactuable = unInteractuable;
        this.nombreEdificio = nombreEdificio;
    }

    public Interactuable visitar(Reloj reloj){
        contadorDeVisitas = contadorDeVisitas + 1;
        if (contadorDeVisitas <= 3) {
            reloj.incrementar(new Tiempo(contadorDeVisitas));
        }
        else {
            reloj.incrementar(new Tiempo(3));
        }
        return interactuable;
    }
    public String getNombre(){
        return nombreEdificio;
    }
}
