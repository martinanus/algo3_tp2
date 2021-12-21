package edu.fiuba.algo3.modelo.lector;

import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.DescripcionCiudad;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class PistaParser {

    public void parser(String ruta,ArrayList<Ciudad> ciudades) {
        Lector lector = new Lector();
        JSONArray pistasJson = lector.leer(ruta);
        for (Object pista : pistasJson) {
            ArrayList<DescripcionCiudad> descripcionesCiudades = new ArrayList<>();
            JSONObject js = (JSONObject) pista;
            JSONObject jcity = (JSONObject) js.get("Pista");
            String NombreCiudad = (String) jcity.get("Ciudad");

            JSONArray pistasFaciles = (JSONArray) jcity.get("PistasFacil");
            DescripcionCiudad descripcionCiudadFacil = new DescripcionCiudad((String) pistasFaciles.get(0),
                    (String) pistasFaciles.get(1), (String) pistasFaciles.get(2));

            JSONArray pistasMedia = (JSONArray) jcity.get("PistasMedia");
            DescripcionCiudad descripcionCiudadMedia = new DescripcionCiudad((String) pistasMedia.get(0),
                    (String) pistasMedia.get(1), (String) pistasMedia.get(2));

            JSONArray pistasDifciles = (JSONArray) jcity.get("PistasDificil");
            DescripcionCiudad descripcionCiudadDificil = new DescripcionCiudad((String) pistasDifciles.get(0),
                    (String) pistasDifciles.get(1), (String) pistasDifciles.get(2));

            descripcionesCiudades.add(descripcionCiudadFacil);
            descripcionesCiudades.add(descripcionCiudadMedia);
            descripcionesCiudades.add(descripcionCiudadDificil);
            for(Ciudad ciudad: ciudades){
                if(ciudad.conNombreIgualA(NombreCiudad)){
                    ciudad.setDescripciones(descripcionesCiudades);
                }
            }
        }
    }
}
