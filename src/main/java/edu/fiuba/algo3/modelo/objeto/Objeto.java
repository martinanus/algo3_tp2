package edu.fiuba.algo3.modelo.objeto;

import edu.fiuba.algo3.modelo.Ciudad;


import java.util.ArrayList;


public abstract class Objeto {
    protected String nombre;
    protected String nombreCiudad;

    public abstract ArrayList<Ciudad> generarRecorrido(ArrayList<Ciudad> ciudades);

    public ArrayList<Ciudad> generarRecorrido(ArrayList<Ciudad> ciudades, int numeroCiudades, String nombreCiudad) {
        ArrayList<Ciudad> ciudadesParaElegir = new ArrayList<>(ciudades);
        ArrayList<Ciudad> recorridoLadron = new ArrayList<>();
        for (Ciudad ciudad: ciudades){
            if (ciudad.conNombreIgualA(nombreCiudad)){
                recorridoLadron.add(ciudad);
            }
            ciudadesParaElegir.removeIf(c -> c.conNombreIgualA(nombreCiudad));
        }
        int contadorCiudades = 0;
        for(Ciudad ciudad: ciudades){
            if(contadorCiudades < numeroCiudades){
                contadorCiudades++;
                Ciudad ciudadRandom = ciudadesParaElegir.get((int)(Math.random()* ciudadesParaElegir.size()));
                recorridoLadron.add(ciudadRandom);
                ciudadesParaElegir.remove(ciudadRandom);
            }
        }
        return recorridoLadron;
    }
}

