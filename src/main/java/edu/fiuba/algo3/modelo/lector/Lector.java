package edu.fiuba.algo3.modelo.lector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;


public class Lector {

    public String cargaDatos(String ruta){
        String nombreCiudad = "";

        Object ob = null;
        try {
            ob = this.leerJson(ruta);
        } catch (IOException | ParseException e) {
            return nombreCiudad;
        }
        // typecasting ob to JSONObject
        JSONArray ciudades = (JSONArray) ob;

        assert ciudades != null;
        for (Object ciudad: ciudades){
            JSONObject js = (JSONObject) ciudad;
            JSONObject jcity = (JSONObject) js.get("city");
            //String Name = (String) jcity.get("Name");
            //String Currency = (String) jcity.get("Currency");
            nombreCiudad = (String) jcity.get("Name");
        }
        return nombreCiudad;
    }

    private Object leerJson(String ruta) throws IOException, org.json.simple.parser.ParseException{
        //Object ob = new JSONParser().parse(new FileReader(System.getProperty("user.dir") + "/jsons/ciudades.json"));
        return new JSONParser().parse(new FileReader(System.getProperty("user.dir") + ruta));
    }
}
