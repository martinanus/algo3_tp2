package edu.fiuba.algo3.modelo;

public class Novato implements Rango{
    private double velocidad;
    //private int arrestos;

    /*public Novato(Ciudad ciudad) {
        super(ciudad);
        velocidad = 900;
    }*/

    public Novato() {
        velocidad = 900;
    }

    public String viajar(String nombreCiudad){
        String nuevaCiudad = nombreCiudad;
        return nuevaCiudad;
    }

    @Override
    public void viajar(Ciudad ciudad, Reloj reloj) {
        double tiempo = ciudad.viajar(velocidad);
        reloj.incrementar(tiempo);
    }
}
