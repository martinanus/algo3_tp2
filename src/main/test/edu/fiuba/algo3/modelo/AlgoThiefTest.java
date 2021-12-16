package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.interactuable.Cuchillo;
import edu.fiuba.algo3.modelo.interactuable.Interactuable;
import edu.fiuba.algo3.modelo.interactuable.Ladron;

import edu.fiuba.algo3.modelo.interactuable.Pista;
import edu.fiuba.algo3.modelo.rango.Detective;
import edu.fiuba.algo3.modelo.rango.Sargento;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlgoThiefTest {

    @Test
    public void test01SeCreaUnCasoYSeVisitaLos3EdificiosDeLaCiudadOrigen(){
        AlgoThief juego = new AlgoThief();
        Policia unPolicia = new Policia("Pepe");
        juego.generarPartida(unPolicia);
        Pista interactuable = (Pista) juego.visitar(unPolicia,"banco");
        Pista interactuable2 = (Pista) juego.visitar(unPolicia,"biblioteca");
        Pista interactuable3 = (Pista) juego.visitar(unPolicia,"puerto");
        assertEquals("pesos mexicanos ricardo",interactuable.mostrar()  );
        assertEquals("Moto",interactuable2.mostrar());
        assertEquals("Roja, verde y blanca",interactuable3.mostrar());
    }

    @Test
    public void test02SeCreaUnCasoYSeViajaAUnPaisDondeNoEstuvoElLadron(){
        AlgoThief juego = new AlgoThief();
        Policia unPolicia = new Policia("Pepe");
        juego.generarPartida(unPolicia);
        juego.viajar("Lima",unPolicia);
        Pista interactuable = (Pista) juego.visitar(unPolicia,"banco");
        Pista interactuable2 = (Pista) juego.visitar(unPolicia,"biblioteca");
        Pista interactuable3 = (Pista) juego.visitar(unPolicia,"puerto");

        assertEquals("No hemos visto al ladron",interactuable.mostrar()  );
        assertEquals("No hemos visto al ladron",interactuable2.mostrar());
        assertEquals("No hemos visto al ladron",interactuable3.mostrar());
    }

    @Test
    public void test03ElPoliciaAtrapaAlLadronLlegaALaCiudadFinal(){
        AlgoThief juego = new AlgoThief();
        Policia unPolicia = new Policia("Pepito");
        juego.generarPartida(unPolicia);
        Pista interactuable0 = (Pista) juego.visitar(unPolicia,"biblioteca");

        assertEquals("Moto",interactuable0.mostrar());

        juego.viajar("Ciudad de Mexico",unPolicia);
        Pista interactuable = (Pista) juego.visitar(unPolicia,"banco");
        Pista interactuable2 = (Pista) juego.visitar(unPolicia,"biblioteca");
        Pista interactuable3 = (Pista) juego.visitar(unPolicia,"puerto");


        assertEquals("Won",interactuable.mostrar()  );
        assertEquals("Anillo",interactuable2.mostrar());
        assertEquals("blanca, roja y azul",interactuable3.mostrar());

        juego.viajar("Seul",unPolicia); //(11+13)=24
        Pista interactuable4 = (Pista) juego.visitar(unPolicia,"banco");//(24+1)=25
        Pista interactuable5 = (Pista) juego.visitar(unPolicia,"biblioteca");//(25+1)=26
        Pista interactuable6 = (Pista) juego.visitar(unPolicia,"puerto");//(26+1)=27

        assertEquals("euro",interactuable4.mostrar()  );
        assertEquals("Negro",interactuable5.mostrar());
        assertEquals("roja, azul y blanca",interactuable6.mostrar());

        juego.viajar("Paris",unPolicia);//(27+10)=37
        Descripcion descripcion = new Descripcion("","Masculino","Croquet","","","");
        juego.cargarDescripcion(descripcion);
        juego.generarOrdenDeArresto(unPolicia); //refactor generar orden de arresto incluido cargarDescripcion.

        Cuchillo interactuable7 = (Cuchillo) juego.visitar(unPolicia,"banco");
        Cuchillo interactuable9 = (Cuchillo) juego.visitar(unPolicia,"puerto");
        Ladron interactuable8 = (Ladron) juego.visitar(unPolicia,"biblioteca");


    }



}
