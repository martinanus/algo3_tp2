package edu.fiuba.algo3.modelo.lector;

import edu.fiuba.algo3.modelo.Descripcion;
import edu.fiuba.algo3.modelo.interactuable.Ladron;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.ArrayList;

public class LadronParser{

    public ArrayList<Ladron> parser(String ruta) {
        ArrayList<Ladron> ladrones = new  ArrayList<>();
        Lector lector = new Lector();

        JSONArray ladronesJson = lector.leer(ruta);

        for (Object ladron: ladronesJson) {
            JSONObject js = (JSONObject) ladron;
            JSONObject jLadron = (JSONObject) js.get("ladron");
            ladrones.add(new Ladron(new Descripcion((String) jLadron.get("Nombre"), (String) jLadron.get("Sexo"),
                    (String) jLadron.get("Hobby"),(String) jLadron.get("Cabello"),(String) jLadron.get("Seña"),
                    (String) jLadron.get("Vehiculo")))) ;
        }
        return ladrones;
    }
}
