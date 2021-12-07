package edu.fiuba.algo3.modelo.lector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;


public class Lector {

    public Object leerJson(String ruta) throws IOException, org.json.simple.parser.ParseException{
        //Object ob = new JSONParser().parse(new FileReader(System.getProperty("user.dir") + "/jsons/ciudades.json"));
        return new JSONParser().parse(new FileReader(System.getProperty("user.dir") + ruta));
    }
}
