package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.interactuable.Interactuable;
import edu.fiuba.algo3.modelo.interactuable.Ladron;
import edu.fiuba.algo3.modelo.lector.CiudadParser;
import edu.fiuba.algo3.modelo.lector.ObjetoParser;
import edu.fiuba.algo3.modelo.lector.PistaParser;
import edu.fiuba.algo3.modelo.lector.RutasDeEscapeParser;
import edu.fiuba.algo3.modelo.objeto.Objeto;
import edu.fiuba.algo3.modelo.tiempo.Reloj;
import edu.fiuba.algo3.modelo.tiempo.Tiempo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class AlgoThief {
    private ArrayList<Ciudad> ciudades;
    private ArrayList<Objeto> objetosRobados;
    private HashMap<String,ArrayList<Ciudad>> recorridoLadron;
    private Computadora computadora;
    private ArrayList<Ladron> ladrones;
    private Reloj reloj;
    private Descripcion descripcionSospechoso;
    private Policia jugador;

    public AlgoThief(Policia jugador){
        descripcionSospechoso = new Descripcion();
        computadora = new Computadora();
        cargarLadrones();
        cargarCiudades();
        cargarObjetosRobados();
        cargarRutasLadron(ciudades);
        cargarPistas(ciudades);
        reloj = new Reloj(new Tiempo(168)); // 17+24*6+17=178
        this.jugador = jugador;
    }

    public AlgoThief() {
        descripcionSospechoso = new Descripcion();
        computadora = new Computadora();
        cargarLadrones();
        cargarCiudades();
        cargarObjetosRobados();
        cargarRutasLadron(ciudades);
        cargarPistas(ciudades);
        reloj = new Reloj(new Tiempo(168)); // 17+24*6+17=178
        jugador = new Policia();
    }

    public void inicializarDia() {
        reloj.incrementar(new Tiempo(7));
    }

    public void generarPartida() {
        Ladron ladron= ladrones.get(0);
        //ladrones.remove(0); Si gana el ladron refactor de esto
        //System.out.println(recorridoLadron);
        jugador.generarCaso(objetosRobados,recorridoLadron,ladron, this); //refactor nombre

    }


    //refactor  para cargar todo esto en una clase aparte
    //private Inicializar iniciador;
    // iniciador(ciudades,objetosRobados,Recorridos);
    private void cargarCiudades(){
       CiudadParser parseador = new CiudadParser();
       ArrayList<Ciudad> ciudades  =  parseador.parser("/jsons/ciudades.json"); //Puede haber un refactor
       this.ciudades = ciudades;
    }
    private void cargarObjetosRobados(){
       ObjetoParser parseador = new ObjetoParser();
       ArrayList<Objeto> objetos  =  parseador.parser("/jsons/objetosRobados.json"); //Puede haber un refactor
       this.objetosRobados = objetos;
    }
    private void cargarRutasLadron(ArrayList<Ciudad> ciudades){
       RutasDeEscapeParser parseardorRuta = new RutasDeEscapeParser();
       HashMap<String,ArrayList<Ciudad>> unHashMap = parseardorRuta.parser("/jsons/rutasDeEscape.json",ciudades);
       this.recorridoLadron=unHashMap;
    }
    public void cargarLadrones(){
        this.ladrones = this.computadora.cargarDatos();
    }

    public Interactuable visitar(String nombreEdificio) {
        /*if(reloj.horaDormir()){
            policia.duerme(reloj);
        }*/
        return jugador.visitar(nombreEdificio,reloj);
    }


    public void viajar(String nombreCiudad) {
        for(Ciudad ciudad: ciudades){
            if(Objects.equals(ciudad.getNombre(), nombreCiudad )){ //falta verificar la lista de ciudades destino
                jugador.viajar(ciudad,reloj);
            }
        }
    }
    public Reloj getReloj(){
        return this.reloj;
    }

    public void cargarDescripcion(Descripcion descripcion) {
        descripcionSospechoso = descripcion;

    }

    public void generarOrdenDeArresto() {
        Ladron ladronSopechoso = new Ladron(descripcionSospechoso);
        jugador.emitirOrdenArresto(computadora,ladronSopechoso,reloj);
    }

    private void cargarPistas(ArrayList<Ciudad> ciudades){
        PistaParser parseador = new PistaParser();
        parseador.parser("/jsons/pistas.json",ciudades); //Puede haber un refactor
    }

    public void finalizar(Objeto objetoRobado, Ladron ladron) {
        this.ladrones.remove(ladron);
        this.objetosRobados.remove(objetoRobado);
        this.reloj = new Reloj(new Tiempo(168));
    }

    public void finalizar() {
        this.reloj = new Reloj(new Tiempo(168));
    }

    public int getCantidadLadrones() {
        return ladrones.size();
    }

    public int getCantidadObjetosRobados() {
        return objetosRobados.size();
    }

    public String descripcionCiudad() {
        return "Egipto fue cuna de la antigua civilización \n" +
                "egipcia, que junto con la mesopotámica \n" +
                "fue el origen de la actual cultura \n" +
                "occidental";
    }

    public String ciudadActual() {
        return jugador.mostrarCiudadActual();
    }

    public void setNombreJugador(String nombre) {
        jugador.setNombre(nombre);
    }

    public String mostrarRango() {
        return jugador.mostrarRango();
    }

    public String mostrarReloj() {
        return reloj.getDia() + ", " + Double.toString(reloj.getHoraActual()) + "hs";
    }

    public String pathImagenCiudad() {
        return "imgs/egipto.jpg";
    }
}
