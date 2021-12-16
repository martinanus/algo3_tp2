package edu.fiuba.algo3.modelo.objeto;

import edu.fiuba.algo3.modelo.Ciudad;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class Objeto {
    private String nombre;
    private String ciudadOrigen;
    private String rareza;

    public Objeto(String nombreObjeto,String ciudadOrigen,String Rareza) {
        this.nombre = nombreObjeto;
        this.ciudadOrigen = ciudadOrigen;
        this.rareza = Rareza;
    }

    public Objeto() {

    }

    public boolean esDeRareza(String rareza) {
        return (Objects.equals(this.rareza, rareza));
    }
    public String getCiudadOrigen(){
        return ciudadOrigen;
    }
}
