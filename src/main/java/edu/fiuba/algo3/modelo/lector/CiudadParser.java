package edu.fiuba.algo3.modelo.lector;

import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.DescripcionCiudad;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.interactuable.Pista;
import edu.fiuba.algo3.modelo.objeto.Objeto;
import edu.fiuba.algo3.modelo.objeto.ObjetoComun;
import edu.fiuba.algo3.modelo.objeto.ObjetoMuyValioso;
import edu.fiuba.algo3.modelo.objeto.ObjetoValioso;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

public class CiudadParser {


    public ArrayList<Ciudad> parser(String ruta) {
        Lector lector = new Lector();
        ArrayList<Ciudad> ciudades = new ArrayList<>();
        JSONArray ciudadesJson = lector.leer(ruta);
        for (Object ciudad : ciudadesJson) {
            JSONObject js = (JSONObject) ciudad;
            JSONObject jcity = (JSONObject) js.get("Ciudad");
            String NombreCiudad = (String) jcity.get("Nombre");
            double latitud = (double) jcity.get("Latitud");
            double longitud = (double) jcity.get("Longitud");
            Posicion posicion = new Posicion(latitud, longitud);
            String coloresBandera = (String) jcity.get("Bandera");
            String Moneda = (String) jcity.get("Moneda");
            String Monumento = (String) jcity.get("Monumento");
            String Idioma = (String) jcity.get("Idioma");
            DescripcionCiudad descripcion = new DescripcionCiudad(coloresBandera,Moneda,Monumento,Idioma);
            Ciudad ciudadActual = new Ciudad(posicion,NombreCiudad,descripcion);
            ciudades.add(ciudadActual);
        }
        return ciudades;
    }


}
//Ciudad ciudadobtenida = new Ciudad(posicion,NombreCiudad);
//ciudades.add(ciudadobtenida);