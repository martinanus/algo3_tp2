package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.lector.CiudadParser;
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
    @Test
    public void test02LasCiudadesSeCarganCorrectamenteConSusCiudadesVecinasCasoMontreal() {
        CiudadParser parseador = new CiudadParser();
        ArrayList<Ciudad> ciudades  =  parseador.parser("/jsons/ciudades.json");
        ArrayList<Ciudad> ciudadPrueba = new ArrayList<>();
        for(Ciudad ciudad: ciudades){
            if(ciudad.conNombreIgualA("Montreal")){
                ciudadPrueba.addAll(ciudad.getCiudadesDestino());
            }
        }
        assertEquals(3,ciudadPrueba.size());
    }
    @Test
    public void test03LasCiudadesSeCarganCorrectamenteConSusCiudadesVecinasCasoLima() {
        CiudadParser parseador = new CiudadParser();
        ArrayList<Ciudad> ciudades  =  parseador.parser("/jsons/ciudades.json");
        ArrayList<Ciudad> ciudadPrueba = new ArrayList<>();
        for(Ciudad ciudad: ciudades){
            if(ciudad.conNombreIgualA("Lima")){
                ciudadPrueba.addAll(ciudad.getCiudadesDestino());
            }
        }
        assertEquals(4,ciudadPrueba.size());
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
