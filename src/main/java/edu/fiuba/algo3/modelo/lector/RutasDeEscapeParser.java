package edu.fiuba.algo3.modelo.lector;

import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.objeto.Objeto;
import edu.fiuba.algo3.modelo.objeto.ObjetoComun;
import edu.fiuba.algo3.modelo.objeto.ObjetoMuyValioso;
import edu.fiuba.algo3.modelo.objeto.ObjetoValioso;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class RutasDeEscapeParser {

    public HashMap<String,ArrayList<Ciudad>> parser(String rutaParaLeerJson,ArrayList<Ciudad> listaCiudades) {
        Lector lector = new Lector();
        HashMap <String,ArrayList<Ciudad> > recorridos = new HashMap<>();
        JSONArray rutas = lector.leer(rutaParaLeerJson);
        for (Object ruta : rutas) {         //Un momento
            ArrayList<Ciudad> ciudadesAgregar = new ArrayList<>();
            JSONObject js = (JSONObject) ruta;
            JSONObject jsdentro = (JSONObject) js.get("RutaDeEscape");
            String ciudadInicialNombre = (String) jsdentro.get("ciudadInicial");
            JSONArray ciudadesVisitadaLadron = (JSONArray) jsdentro.get("ciudadesRecorridos");
            for(Object ciudad : ciudadesVisitadaLadron){
                String nombreCiudad = (String) ciudad;
                for(Ciudad ciudadEnLista : listaCiudades){
                    if(ciudadEnLista.conNombreIgualA(nombreCiudad)){
                        ciudadesAgregar.add(ciudadEnLista);
                    }
                }
            }
            recorridos.put(ciudadInicialNombre,ciudadesAgregar);
        }
        return recorridos;
    }
}
