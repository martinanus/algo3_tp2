package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DistanciaTest {

    @Test
    public void test01SeCalculaLaDistanciaEntreBuenosAiresYMadrid() {
        /* Arrange */
        Posicion posicionBuenosAires = new Posicion(-34.61305556, -58.37722222);
        Posicion posicionMadrid = new Posicion(40.41638889, -3.7025);

        /* Act */
        double distancia = posicionBuenosAires.calcularDistanciaCon(posicionMadrid);

        /* Assert */
        assertEquals(10000, distancia, 50);
    }

    @Test
    public void test02SeCalculaLaDistanciaEntreCiudadDeMexicoYMontreal() {
        /* Arrange */
        Posicion posicionMexico = new Posicion(19.42833333, -99.1275);
        Posicion posicionMontreal = new Posicion(45.50861111, -73.58777778);

        /* Act */
        double distancia = posicionMexico.calcularDistanciaCon(posicionMontreal);

        /* Assert */
        assertEquals(3700, distancia, 50);
    }

    @Test
    public void test03SeCalculaLaDistanciaEntreSeulYParis() {
        /* Arrange */
        Posicion posicionSeul = new Posicion(37.566, 126.9784);
        Posicion posicionParis = new Posicion(48.85341, 2.3488);

        /* Act */
        double distancia = posicionSeul.calcularDistanciaCon(posicionParis);
        System.out.println(distancia / 900);

        /* Assert */
        assertEquals(8970, distancia, 50);
    }
}
