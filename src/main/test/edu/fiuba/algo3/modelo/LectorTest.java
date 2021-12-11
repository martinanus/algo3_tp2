package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.interactuable.Ladron;
import edu.fiuba.algo3.modelo.lector.LadronParser;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LectorTest {

    @Test
    public void SeCarganDatosDeLadronCorrectamente() {
        LadronParser ladronParser = new LadronParser();
        ArrayList<Ladron> ladrones = ladronParser.parser("/jsons/ladrones.json");
        assertEquals(6, ladrones.size());
    }

    @Test
    public void SeQuierenCarganDatosDeLadronConRutaInadecuada() {
        LadronParser ladronParser = new LadronParser();
        ArrayList<Ladron> ladrones = ladronParser.parser("/jsons/ladron.json");
        assertEquals(0, ladrones.size());
    }

}
