package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.interactuable.Cuchillo;
import edu.fiuba.algo3.modelo.interactuable.Interactuable;
import edu.fiuba.algo3.modelo.interactuable.Ladron;

import edu.fiuba.algo3.modelo.interactuable.Pista;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlgoThiefTest {

    @Test
    public void test01SeCreaUnCasoYSeVisitaLos3EdificiosDeLaCiudadOrigen(){
        AlgoThief juego = new AlgoThief();
        juego.generarPartida();
        Pista interactuable = (Pista) juego.visitar("banco");
        Pista interactuable2 = (Pista) juego.visitar("biblioteca");
        Pista interactuable3 = (Pista) juego.visitar("puerto");
        assertEquals("Pesos",interactuable.mostrar()  );
        assertEquals("Templo de Kukulkan",interactuable2.mostrar());
        assertEquals("Verde, blanca y roja",interactuable3.mostrar());
    }

    @Test
    public void test02SeCreaUnCasoYSeViajaALaSiguienteCiudadaQueVisitoElLadron(){
        AlgoThief juego = new AlgoThief();
        juego.generarPartida();
        juego.viajar("Lima");
        Pista interactuable = (Pista) juego.visitar("banco");
        Pista interactuable2 = (Pista) juego.visitar("biblioteca");
        Pista interactuable3 = (Pista) juego.visitar("puerto");

        assertEquals("No hemos visto al ladron",interactuable.mostrar()  );
        assertEquals("No hemos visto al ladron",interactuable2.mostrar());
        assertEquals("No hemos visto al ladron",interactuable3.mostrar());
    }

    @Test
    public void test03ElPoliciaAtrapaAlLadronLlegaALaCiudadFinal(){
        AlgoThief juego = new AlgoThief();
        juego.generarPartida();
        juego.viajar("Ciudad de Mexico");
        Pista interactuable = (Pista) juego.visitar("banco");
        Pista interactuable2 = (Pista) juego.visitar("biblioteca");
        Pista interactuable3 = (Pista) juego.visitar("puerto");


        assertEquals("Won",interactuable.mostrar()  );
        assertEquals("Fortaleza de Hwasong",interactuable2.mostrar());
        assertEquals("blanca, roja y azul",interactuable3.mostrar());

        juego.viajar("Seul"); //(11+13)=24
        Pista interactuable4 = (Pista) juego.visitar("banco");//(24+1)=25
        Pista interactuable5 = (Pista) juego.visitar("biblioteca");//(25+1)=26
        Pista interactuable6 = (Pista) juego.visitar("puerto");//(26+1)=27

        assertEquals("euro",interactuable4.mostrar()  );
        assertEquals("La torre Eiffel",interactuable5.mostrar());
        assertEquals("roja, azul y blanca",interactuable6.mostrar());

        juego.viajar("Paris");//(27+10)=37
        Descripcion descripcion = new Descripcion("","Masculino","Croquet","","","");
        juego.cargarDescripcion(descripcion);
        juego.generarOrdenDeArresto(); //refactor generar orden de arresto incluido cargarDescripcion.

        System.out.println(juego.getReloj().tiempoTranscurrido().getTiempo());//34
        Cuchillo interactuable7 = (Cuchillo) juego.visitar("banco");
        System.out.println(juego.getReloj().tiempoTranscurrido().getTiempo());//(34+1+2)=37
        Cuchillo interactuable9 = (Cuchillo) juego.visitar("puerto");
        System.out.println(juego.getReloj().tiempoTranscurrido().getTiempo());//(37+1+1)=39
        Ladron interactuable8 = (Ladron) juego.visitar("biblioteca");
        System.out.println(juego.getReloj().tiempoTranscurrido().getTiempo());//(39+1)=40

    }


}
