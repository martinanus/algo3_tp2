package edu.fiuba.algo3.modelo.objeto;

import edu.fiuba.algo3.modelo.Ciudad;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public abstract class Objeto {
    protected String nombre;
    protected String nombreCiudad;

    public String getCiudadOrigen(){
        return this.nombreCiudad;
    }
}
