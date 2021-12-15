package edu.fiuba.algo3.modelo.objeto;

import edu.fiuba.algo3.modelo.Ciudad;

import java.util.ArrayList;

public class ObjetoMuyValioso implements Objeto {
    private String nombre;
    private String ciudadOrigen;

    public ObjetoMuyValioso(String nombreObjeto, String ciudadOrigen) {
        this.nombre = nombreObjeto;
        this.ciudadOrigen = ciudadOrigen;
    }

    @Override
    public ArrayList<Ciudad> crearRutaEscape() {
        ArrayList<Ciudad> listaCiudades = new ArrayList<>();

        return listaCiudades;


        //Ideas :  Crear Otro objeto comun, valioso o muy valioso,


    }
}
