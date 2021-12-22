package edu.fiuba.algo3.modelo.lector;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;


public class Lector {

    private Object leerJson(String ruta) throws IOException, org.json.simple.parser.ParseException{
        return new JSONParser().parse(new FileReader(System.getProperty("user.dir") + ruta));
    }

    public JSONArray leer(String ruta) {
        Object ob;
        try {
            ob = this.leerJson(ruta);
        } catch (IOException | ParseException e) {
            throw new ArchivoNoEncontradoError();
        }
        // typecasting ob to JSONObject
        return (JSONArray) ob;
    }
}
