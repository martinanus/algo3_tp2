package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.interactuable.Interactuable;
import edu.fiuba.algo3.modelo.interactuable.Ladron;
import edu.fiuba.algo3.modelo.lector.CiudadParser;
import edu.fiuba.algo3.modelo.lector.LadronParser;
import edu.fiuba.algo3.modelo.lector.ObjetoParser;
import edu.fiuba.algo3.modelo.lector.RutasDeEscapeParser;
import edu.fiuba.algo3.modelo.objeto.Objeto;
import edu.fiuba.algo3.modelo.rango.Rango;

import java.util.ArrayList;
import java.util.HashMap;

public class AlgoThief {
    private ArrayList<Ciudad> ciudades;
    private ArrayList<Objeto> objetosRobados;
    private HashMap<String,ArrayList<Ciudad>> recorridoLadron;
    private Computadora computadora;
    private ArrayList<Ladron> ladrones;
    private Reloj reloj;
    private Policia policia;

    public AlgoThief(){
        computadora = new Computadora();
        cargarLadrones();
        cargarCiudades();
        cargarObjetosRobados();
        cargarRutasLadron(ciudades);
        reloj = new Reloj(new Tiempo(168));
        this.policia = new Policia("Pepe");
    }

    public void generarPartida() {
        Ladron ladron= ladrones.get(0);
        //ladrones.remove(0); Si gana el ladron refactor de esto
        this.policia.generarCaso(objetosRobados,recorridoLadron,ladron); //refactor nombre

    }
    //refactor  para cargar todo esto en una clase aparte
    //private Inicializar iniciador;
    // iniciador(ciudades,objetosRobados,Recorridos);
    public void cargarCiudades(){
       CiudadParser parseador = new CiudadParser();
       ArrayList<Ciudad> ciudades  =  parseador.parser("/jsons/ciudades.json"); //Puede haber un refactor
       this.ciudades = ciudades;
    }
   public void cargarObjetosRobados(){
       ObjetoParser parseador = new ObjetoParser();
       ArrayList<Objeto> objetos  =  parseador.parser("/jsons/objetosRobados.json"); //Puede haber un refactor
       this.objetosRobados = objetos;
    }
   public void cargarRutasLadron(ArrayList<Ciudad> ciudades){
       RutasDeEscapeParser parseardorRuta = new RutasDeEscapeParser();
       HashMap<String,ArrayList<Ciudad>> unHashMap = parseardorRuta.parser("/jsons/rutasDeEscape.json",ciudades);
       this.recorridoLadron=unHashMap;
    }
    public void cargarLadrones(){
        this.ladrones = this.computadora.cargarDatos();
    }
    public void juegoVisitar(){

    }

    public Interactuable visitar(String nombreEdificio) {
        return policia.visitar(nombreEdificio,reloj);
    }
}
