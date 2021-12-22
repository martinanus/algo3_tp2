package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.interactuable.Pista;
import java.util.ArrayList;

public class DescripcionCiudad {
    private String bandera;
    private String moneda;
    private String monumento;

    public DescripcionCiudad(String economico,String geografico,String internacional){
        this.bandera = internacional;
        this.moneda = economico;
        this.monumento = geografico;
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
