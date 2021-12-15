package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.interactuable.Ladron;
import edu.fiuba.algo3.modelo.objeto.Objeto;

import java.util.ArrayList;


public class Caso {
    private Objeto objeto;
    private Ladron ladron;
    private ArrayList<Ciudad> cantidadPaises;

    public Caso(Objeto objetoComun) {
        this.objeto = objetoComun;
        cantidadPaises = this.objeto.crearRutaEscape(); //Esta ruta de escape del ladron no del policia.


    }

    //public int getCantidadPaises() {
    //    return cantidadPaises;
    //}
}
