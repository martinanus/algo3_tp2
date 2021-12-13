package edu.fiuba.algo3.modelo.lector;

import edu.fiuba.algo3.modelo.Ciudad;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class CiudadParser {

    public ArrayList<Ciudad> parser(String ruta) {
        ArrayList<Ciudad> ciudades = new  ArrayList<>();
        Lector lector = new Lector();

        JSONArray ciudadesJson = lector.leer(ruta);

        for (Object ladron: ciudadesJson) {
            JSONObject js = (JSONObject) ladron;
            JSONObject jcity = (JSONObject) js.get("city");
            ciudades.add(new Ciudad());
        }
        return ciudades;
    }
}
