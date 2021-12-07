package edu.fiuba.algo3.ArchivoJson;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Descripcion;
import org.junit.jupiter.api.Test;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class ArchivoJsonTest {

    @Test
    public void SeObtieneLasDescripcionesDeLadronesEnElArchivo() throws IOException {
        String texto = Files.readString(Path.of("src/main/DescripcionLadronesYObjetos.json") );
        JsonObject unJsonObjeto = JsonParser.parseString(texto).getAsJsonObject();

        ArrayList<Ladron> arrayLadrones = new ArrayList<>();


        JsonArray arrayDescripciones = unJsonObjeto.getAsJsonArray("DescripcionesLadrones");
        for(JsonElement unJson: arrayDescripciones){
            ArrayList<Descripcion> unasDescripciones = new ArrayList<>();
            String nombre = unJson.getAsJsonObject().get("Nombre").getAsString();
            String sexo = unJson.getAsJsonObject().get("Sexo").getAsString();
            String hobby = unJson.getAsJsonObject().get("Hobby").getAsString();
            String cabello = unJson.getAsJsonObject().get("Cabello").getAsString();
            String seña = unJson.getAsJsonObject().get("Seña").getAsString();
            String vehiculo = unJson.getAsJsonObject().get("Vehiculo").getAsString();
            Descripcion unaDescripcion = new Descripcion(nombre,sexo,hobby,cabello,seña,vehiculo);
            Ladron unLadron = new Ladron(unaDescripcion);
            arrayLadrones.add(unLadron);
        }
        assertEquals(6,arrayLadrones.size());
    }

}
