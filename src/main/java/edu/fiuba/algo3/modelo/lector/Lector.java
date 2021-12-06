package edu.fiuba.algo3.modelo.lector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class Lector {

    public static void cargaDatos() throws IOException, org.json.simple.parser.ParseException {
        // parsing file "JSONExample.json"
        Object ob = new JSONParser().parse(new FileReader(System.getProperty("user.dir") + "/jsons/ciudades.json"));

        // typecasting ob to JSONObject
        JSONArray ciudades = (JSONArray) ob;

        for (Object ciudad: ciudades){
            JSONObject js = (JSONObject) ciudad;
            JSONObject jcity = (JSONObject) js.get("city");
            String Name = (String) jcity.get("Name");
            String Currency = (String) jcity.get("Currency");
            System.out.println("City name: " + Name);
            System.out.println("Currency: " +Currency);
        }
    }
}
