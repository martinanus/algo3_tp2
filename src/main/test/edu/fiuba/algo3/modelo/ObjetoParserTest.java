package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.lector.ObjetoParser;
import edu.fiuba.algo3.modelo.objeto.Objeto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObjetoParserTest {

    @Test
    public void test01LosObjetosRobadosSeCarganCorrectamente() {
        ObjetoParser parseador = new ObjetoParser();
        ArrayList<Objeto> objetosRobados  =  parseador.parser("/jsons/objetosRobados.json");
        assertEquals(10,objetosRobados.size());
    }
}
