package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.interactuable.Ladron;
import edu.fiuba.algo3.modelo.lector.ArchivoNoEncontradoError;
import edu.fiuba.algo3.modelo.lector.CiudadParser;
import edu.fiuba.algo3.modelo.lector.LadronParser;
import edu.fiuba.algo3.modelo.lector.ObjetoParser;
import edu.fiuba.algo3.modelo.objeto.Objeto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LectorTest {

    @Test
    public void SeCarganDatosDeLadronCorrectamente() {
        LadronParser ladronParser = new LadronParser();
        ArrayList<Ladron> ladrones = ladronParser.parser("/jsons/ladrones.json");
        assertEquals(9, ladrones.size());
    }

    @Test
    public void SeQuierenCarganDatosDeLadronConRutaInadecuada() {
        LadronParser ladronParser = new LadronParser();

        assertThrows(ArchivoNoEncontradoError.class, ()-> {
            ladronParser.parser("/jsons/ladron.json");  //
        } );
    }

    @Test
    public void SeCarganDatosDeCiudadesCorrectamente() {
        CiudadParser ciudadParser = new CiudadParser();
        ArrayList<Ciudad> ciudades = ciudadParser.parser("/jsons/ciudades.json");
        assertEquals(13, ciudades.size());
    }

    @Test
    public void SeCarganDatosDeCiudadesConRutaInadecuada() {
        CiudadParser ciudadParser = new CiudadParser();

        assertThrows(ArchivoNoEncontradoError.class, ()-> {
            ciudadParser.parser("/jsons/ladron.json");  //
        } );
    }

    @Test
    public void SeCarganDatosDeCObjetosCorrectamente() {
        ObjetoParser parseador = new ObjetoParser();
        ArrayList<Objeto> objetosRobados  =  parseador.parser("/jsons/objetosRobados.json");
        assertEquals(10,objetosRobados.size());
    }

    @Test
    public void SeCarganDatosDeObjetosConRutaInadecuada() {
        ObjetoParser objetoParser = new ObjetoParser();

        assertThrows(ArchivoNoEncontradoError.class, ()-> {
            objetoParser.parser("/jsons/objdsatosRobados.json");  //
        } );
    }
}
