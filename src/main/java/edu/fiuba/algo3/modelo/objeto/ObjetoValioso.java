package edu.fiuba.algo3.modelo.objeto;

import edu.fiuba.algo3.modelo.Ciudad;

import java.util.ArrayList;

public class ObjetoValioso extends Objeto {

    public ObjetoValioso() {

    }

    public ObjetoValioso(String nombreObjeto, String nombreCiudad) {
        this.nombre = nombreObjeto;
        this.nombreCiudad = nombreCiudad;
    }

    @Override
    public ArrayList<Ciudad> generarRecorrido(ArrayList<Ciudad> ciudades) {
        return this.generarRecorrido(ciudades, 4, nombreCiudad);
    }
}
