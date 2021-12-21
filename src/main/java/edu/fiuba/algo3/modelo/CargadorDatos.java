package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.interactuable.Ladron;
import edu.fiuba.algo3.modelo.lector.CiudadParser;
import edu.fiuba.algo3.modelo.lector.ObjetoParser;
import edu.fiuba.algo3.modelo.lector.PistaParser;
import edu.fiuba.algo3.modelo.objeto.Objeto;

import java.util.ArrayList;

public class CargadorDatos {

    public ArrayList<Ciudad> cargarCiudades(){
        CiudadParser parseador = new CiudadParser();
        return parseador.parser("/jsons/ciudades.json");
    }

    public ArrayList<Objeto> cargarObjetosRobados(){
        ObjetoParser parseador = new ObjetoParser();
        return parseador.parser("/jsons/objetosRobados.json");
    }

    public ArrayList<Ladron> cargarLadrones(Computadora computadora){
        return computadora.cargarDatos();
    }

    public void cargarPistas(ArrayList<Ciudad> ciudades){
        PistaParser parseador = new PistaParser();
        parseador.parser("/jsons/pistas.json",ciudades);
    }
}
