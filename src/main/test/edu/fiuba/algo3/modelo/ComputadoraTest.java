package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.interactuable.Ladron;
import edu.fiuba.algo3.modelo.ordenesArresto.OrdenEmitida;
import edu.fiuba.algo3.modelo.ordenesArresto.OrdenNoEmitida;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComputadoraTest {

    @Test
    public void SeBuscaEnLaComputadoraUnSospechosoConDatosDeLadronesYaCreados() {
        Computadora computadora = new Computadora();
        computadora.cargarDatos();
        Descripcion descripcion4 = new Descripcion("","Masculino","","","","");
        Ladron sospechosoBuscado = new Ladron(descripcion4);
        assertEquals(OrdenNoEmitida.class, computadora.emitirOrdenDeArresto(sospechosoBuscado).getClass());
    }

    @Test
    public void SeBuscaEnLaComputadoraUnSospechosoConSexoYHobbyConDatosDeLadrones() {
        Computadora computadora = new Computadora();
        computadora.cargarDatos();
        Descripcion descripcion4 = new Descripcion("","Masculino","Croquet","","","");
        Ladron sospechosoBuscado = new Ladron(descripcion4);
        assertEquals(OrdenEmitida.class, computadora.emitirOrdenDeArresto(sospechosoBuscado).getClass());
    }
}
