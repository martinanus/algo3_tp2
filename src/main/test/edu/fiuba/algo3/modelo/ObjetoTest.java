package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.modelo.lector.CiudadParser;
import edu.fiuba.algo3.modelo.objeto.Objeto;
import edu.fiuba.algo3.modelo.objeto.ObjetoComun;
import edu.fiuba.algo3.modelo.objeto.ObjetoMuyValioso;
import edu.fiuba.algo3.modelo.objeto.ObjetoValioso;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ObjetoTest {

    @Test
    public void SeCreaRecorridoExitosamenteObjetoComun() {
        Objeto objeto = new ObjetoComun("hola","Lima");
        CiudadParser ciudadParser = new CiudadParser();
        ArrayList<Ciudad> ciudades = ciudadParser.parser("/jsons/ciudades.json");

        ArrayList<Ciudad> recorrido = objeto.generarRecorrido(ciudades);

        assertEquals(4, recorrido.size());

    }

    @Test
    public void SeCreaRecorridoExitosamenteObjetoValioso() {
        Objeto objeto = new ObjetoValioso("hola","Buenos Aires");
        CiudadParser ciudadParser = new CiudadParser();
        ArrayList<Ciudad> ciudades = ciudadParser.parser("/jsons/ciudades.json");

        ArrayList<Ciudad> recorrido = objeto.generarRecorrido(ciudades);

        assertEquals(5, recorrido.size());

    }

    @Test
    public void SeCreaRecorridoExitosamenteObjetoMuyValioso() {
        Objeto objeto = new ObjetoMuyValioso("hola","Buenos Aires");
        CiudadParser ciudadParser = new CiudadParser();
        ArrayList<Ciudad> ciudades = ciudadParser.parser("/jsons/ciudades.json");

        ArrayList<Ciudad> recorrido = objeto.generarRecorrido(ciudades);

        assertEquals(7, recorrido.size());
    }

}
