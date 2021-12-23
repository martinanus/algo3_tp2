package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.lector.CiudadParser;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CiudadParserTest {

    @Test
    public void test01LasCiudadesSeCarganCorrectamente() {
        CiudadParser parseador = new CiudadParser();
        ArrayList<Ciudad> ciudades  =  parseador.parser("/jsons/ciudades.json");
        assertEquals(13,ciudades.size());
    }

}

