package edu.fiuba.algo3.modelo.objeto;

import edu.fiuba.algo3.modelo.Ciudad;

import java.util.ArrayList;

public class ObjetoComun extends Objeto {

    public ObjetoComun() {

    }

    public ObjetoComun(String nombreObjeto, String nombreCiudad) {
        this.nombre = nombreObjeto;
        this.nombreCiudad = nombreCiudad;
    }

    @Override
    public ArrayList<Ciudad> generarRecorrido(ArrayList<Ciudad> ciudades) {
        return this.generarRecorrido(ciudades, 3, nombreCiudad);
    }
}
