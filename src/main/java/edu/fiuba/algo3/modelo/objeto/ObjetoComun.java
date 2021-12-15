package edu.fiuba.algo3.modelo.objeto;

import edu.fiuba.algo3.modelo.Ciudad;

import java.util.ArrayList;

public class ObjetoComun implements Objeto {
    private String nombre;
    private String ciudadOrigen;

    public ObjetoComun(String nombreObjeto, String CiudadOrigen) {
        this.nombre = nombreObjeto;
        this.ciudadOrigen = CiudadOrigen;
    }

    @Override
    public ArrayList<Ciudad> crearRutaEscape( ) {
        ArrayList<Ciudad> listaCiudades = new ArrayList<>();
        return listaCiudades;
        //Ideas :  Crear Otro objeto comun, valioso o muy valioso,

    }
}
