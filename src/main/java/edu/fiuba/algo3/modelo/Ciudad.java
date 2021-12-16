package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.interactuable.Interactuable;
import edu.fiuba.algo3.modelo.interactuable.Pista;

import java.util.ArrayList;
import java.util.Objects;

public class Ciudad {
    private ArrayList<Edificio> edificios;
    private Posicion posicion;
    private String nombre;
    private DescripcionCiudad descripcion;
    private ArrayList<Ciudad> ciudadesDestino;

    public Ciudad() {
        this.edificios = new ArrayList<>();
    }

    public Ciudad(Posicion posicion,String Nombre,DescripcionCiudad descripcion) {
        this.posicion = posicion;
        this.edificios = new ArrayList<>();
        this.nombre = Nombre;
        this.descripcion = descripcion;
        this.ciudadesDestino = new ArrayList<>();
    }

    public Ciudad(Posicion posicion) {
        this.posicion = posicion;
        this.edificios = new ArrayList<>();
    }
    public void agregarCiudadDestino(Ciudad unaCiudad){
        ciudadesDestino.add(unaCiudad);
    }

    public ArrayList<Ciudad> getCiudadesDestino(){
        return ciudadesDestino;
    }

    public Interactuable visitar(Edificio edificioNombre , Reloj reloj){
        Edificio edificio= this.buscarEdificio(edificioNombre);
        return edificio.visitar(reloj);
    }
    public Interactuable visitar(String edificioNombre , Reloj reloj){
        Edificio edificioViejo= new Edificio(new Pista("hola"));
        for(Edificio edificio: edificios){
            if(Objects.equals(edificio.getNombre(), edificioNombre)){
                edificioViejo = edificio;
            }
        }
        return edificioViejo.visitar(reloj);
    }

    private Edificio buscarEdificio(Edificio edificioNombre) {
        return edificios.get(edificios.indexOf(edificioNombre));
    }

    public void agregarEdificio(Edificio edificio) {
        edificios.add(edificio);
    }

    public double tiempoViaje(Ciudad origen, double velocidad) {
        return  calcularDistanciaCon(origen) / velocidad;
    }

    private double calcularDistanciaCon(Ciudad origen) {
        return origen.calcularDistancia(this.posicion);
    }

    private double calcularDistancia(Posicion posicion) {
        return this.posicion.calcularDistanciaCon(posicion);
    }

    public boolean conNombreIgualA(String nombreCiudad) {
        return (Objects.equals(this.nombre, nombreCiudad));
    }

    public String getNombre() {
        return nombre;
    }

    public void llenarPistas(Ciudad ciudadProxima) {
        ArrayList<Pista> pistas = ciudadProxima.generaPistas();
        Edificio banco = new Edificio(pistas.get(0),"banco");
        Edificio biblioteca = new Edificio(pistas.get(1),"biblioteca");
        Edificio puerto = new Edificio(pistas.get(2),"puerto");
        this.agregarEdificio(banco);
        this.agregarEdificio(biblioteca);
        this.agregarEdificio(puerto);
    }

    private ArrayList<Pista> generaPistas() {
        return this.descripcion.generarPistas();
    }
}
