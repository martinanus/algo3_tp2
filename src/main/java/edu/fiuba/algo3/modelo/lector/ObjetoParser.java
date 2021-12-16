package edu.fiuba.algo3.modelo.lector;

import edu.fiuba.algo3.modelo.objeto.Objeto;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

public class ObjetoParser {


    public ArrayList<Objeto> parser(String ruta) {
        Lector lector = new Lector();
        ArrayList<Objeto> objetosRobados = new ArrayList<>();
        JSONArray objetosJson = lector.leer(ruta);
        for (Object objetoRobado : objetosJson) {
            JSONObject js = (JSONObject) objetoRobado;
            JSONObject jobjetoRob = (JSONObject) js.get("ObjetoRobado");
            String NombreObjeto = (String) jobjetoRob.get("Nombre");
            String Rareza = (String) jobjetoRob.get("Rareza");
            String ciudadOrigen = (String) jobjetoRob.get("CiudadOrigen");
            Objeto objeto;
            if(Objects.equals(Rareza, "Comun")){
                objeto = new Objeto(NombreObjeto,ciudadOrigen,Rareza);
                objetosRobados.add(objeto);
            }else if(Objects.equals(Rareza, "Valioso")){
                objeto = new Objeto(NombreObjeto,ciudadOrigen,Rareza);
                objetosRobados.add(objeto);
            }else if(Objects.equals(Rareza, "Muy Valioso")){
                objeto = new Objeto(NombreObjeto,ciudadOrigen,Rareza);
                objetosRobados.add(objeto);
            }
        }
        return objetosRobados;
    }
}
