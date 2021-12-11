package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.interactuable.Ladron;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DescripcionTest {

    @Test
    public void compararDescripciones() {
        Descripcion descripcion1 = new Descripcion("sospechoso1","masculino","tenis","castaño","tatuaje","moto");
        Ladron sospechoso1 = new Ladron(descripcion1);
        Descripcion descripcion2 = new Descripcion("sospechoso2","masculino","musica","negro","anillo","deportivo");
        Ladron sospechoso2 = new Ladron(descripcion2);
        assertFalse(sospechoso1.compararCon(sospechoso2));
    }

    @Test
    public void compararLadronesConDescripcionesDeSexoYHobby() {
        Descripcion descripcion1 = new Descripcion("sospechoso1","masculino","tenis","castaño","tatuaje","moto");
        Descripcion descripcion4 = new Descripcion("","masculino","tenis","","","");
        assertTrue(descripcion1.comparar(descripcion4));
    }
}
