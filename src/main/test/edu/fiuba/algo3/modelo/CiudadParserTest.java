package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.interactuable.Ladron;
import edu.fiuba.algo3.modelo.lector.CiudadParser;
import edu.fiuba.algo3.modelo.objeto.Objeto;
import edu.fiuba.algo3.modelo.objeto.ObjetoComun;
import edu.fiuba.algo3.modelo.ordenesArresto.OrdenEmitida;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CiudadParserTest {

    @Test
    public void test01LasCiudadesSeCarganCorrectamente() {
        CiudadParser parseador = new CiudadParser();
        ArrayList<Ciudad> ciudades  =  parseador.parser("/jsons/ciudades.json");
        assertEquals(11,ciudades.size());
    }

}



/*
    public void test01LosObjetosDeCadaCiudadSeCarganCorrectamente() {
        CiudadParser parseador = new CiudadParser();
        ArrayList<Objeto> objeto  =  parseador.parser("/jsons/ciudades.json");
        assertEquals(1,objeto.size());
        assertTrue(objeto.get(0) instanceof ObjetoComun);
    }
                String nombreObjeto = (String) jcity.get("NombreObjeto");
            String rareza = (String) jcity.get("ObjetoRareza");
            if (Objects.equals(rareza, "Comun")) {
                ObjetoComun objeto = new ObjetoComun(nombreObjeto);
                objetos.add(objeto);
            } else if(Objects.equals(rareza, "Valioso")){
                ObjetoValioso objeto = new ObjetoValioso(nombreObjeto);
                objetos.add(objeto);
            } else if(Objects.equals(rareza, "MuyValioso")){
                ObjetoMuyValioso objeto = new ObjetoMuyValioso(nombreObjeto);
                objetos.add(objeto);
            }
 */
