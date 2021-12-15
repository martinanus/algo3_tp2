package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.interactuable.Ladron;
import edu.fiuba.algo3.modelo.lector.CiudadParser;
import edu.fiuba.algo3.modelo.lector.LadronParser;
import edu.fiuba.algo3.modelo.lector.ObjetoParser;
import edu.fiuba.algo3.modelo.objeto.Objeto;
import edu.fiuba.algo3.modelo.rango.Rango;

import java.util.ArrayList;

public class AlgoThief {
    private ArrayList<Ciudad> ciudades;

    public void generarPartida(Policia unPolicia) {
        //Aca hay que fijarnos que rango es el policia, en funcion del rango
        //va a buscar en el archivo json que tipo de objeto vamos a tener
        //y en funcion del tipo de objeto que tnemos vamos atener la circulacion del ladron
        //
        //unPolicia.generarCaso();
        //Cargo en algoThief
        //Origen
        //Leemos el Json de ciudades.


    }

   public void cargarCiudades(){
       CiudadParser parseador = new CiudadParser();
       ArrayList<Ciudad> ciudades  =  parseador.parser("/jsons/ciudades.json"); //Puede haber un refactor
   }
   public void cargarObjetosRobados(){
       ObjetoParser parseador = new ObjetoParser();
       ArrayList<Objeto> objetos  =  parseador.parser("/jsons/objetosRobados.json"); //Puede haber un refactor
   }
}
