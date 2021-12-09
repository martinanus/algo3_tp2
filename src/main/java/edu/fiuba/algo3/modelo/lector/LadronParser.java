package edu.fiuba.algo3.modelo.lector;

import edu.fiuba.algo3.modelo.Descripcion;
import edu.fiuba.algo3.modelo.Interactuable.Ladron;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;

public class LadronParser{

    public ArrayList<Ladron> parser(String ruta) {
        ArrayList<Ladron> ladrones = new  ArrayList<>();
        Lector lector = new Lector();

        Object ob;
        try {
            ob = lector.leerJson(ruta);
        } catch (IOException | ParseException e) {
            return new ArrayList<>();
        }
        // typecasting ob to JSONObject
        JSONArray ladronesJson = (JSONArray) ob;

        assert ladronesJson != null;
        for (Object ladron: ladronesJson) {
            JSONObject js = (JSONObject) ladron;
            JSONObject jLadron = (JSONObject) js.get("ladron");
            ladrones.add(new Ladron(new Descripcion((String) jLadron.get("Nombre"), (String) jLadron.get("Sexo"),
                    (String) jLadron.get("Hobby"),(String) jLadron.get("Cabello"),(String) jLadron.get("Seña"),
                    (String) jLadron.get("Vehiculo"))));
        }
        return ladrones;
    }
}
