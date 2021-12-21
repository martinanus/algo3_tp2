package edu.fiuba.algo3.modelo.lector;

import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.Edificio;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.interactuable.Pista;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

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
            Ciudad ciudadActual = new Ciudad(posicion,NombreCiudad);
            Edificio banco = new Edificio(new Pista("No hemos visto al ladron"),"banco");
            Edificio biblioteca = new Edificio(new Pista("No hemos visto al ladron"),"biblioteca");
            Edificio puerto = new Edificio(new Pista("No hemos visto al ladron"),"puerto");
            ciudadActual.agregarEdificio(banco);
            ciudadActual.agregarEdificio(biblioteca);
            ciudadActual.agregarEdificio(puerto);
            ciudades.add(ciudadActual);
        }

        return ciudades;
    }

}
