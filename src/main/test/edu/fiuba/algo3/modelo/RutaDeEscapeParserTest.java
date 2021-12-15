package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.lector.CiudadParser;
import edu.fiuba.algo3.modelo.lector.RutasDeEscapeParser;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RutaDeEscapeParserTest {

    @Test
    public void test01LasRutasSeCarganCorrectamenteEnUnHashMap() {
        CiudadParser parseador = new CiudadParser();
        ArrayList<Ciudad> ciudades  =  parseador.parser("/jsons/ciudades.json");
        RutasDeEscapeParser parseardorRuta = new RutasDeEscapeParser();
        HashMap<String,ArrayList<Ciudad>> unHashMap = parseardorRuta.parser("/jsons/rutasDeEscape.json",ciudades);
        System.out.println(unHashMap.get("Lima").get(3).getNombre());
        System.out.println(unHashMap.get("Buenos Aires").get(2).getNombre());
        assertEquals(3,unHashMap.size());
    }
}
