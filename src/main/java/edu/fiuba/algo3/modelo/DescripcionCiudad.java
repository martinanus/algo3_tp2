package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.interactuable.Pista;

import java.util.ArrayList;

public class DescripcionCiudad {
    private String bandera;
    private String moneda;
    private String monumento;
    private String idioma;

    public DescripcionCiudad(String bandera,String moneda,String monumento,String idioma){
        this.bandera = bandera;
        this.moneda = moneda;
        this.monumento = monumento;
        this.idioma = idioma;
    }

    public ArrayList<Pista> generarPistas() {
        ArrayList<Pista> pistas = new ArrayList<>(){{
            add(new Pista(moneda));
            add(new Pista(monumento));
            add(new Pista(bandera));
        }};
        return pistas;
    }
}
