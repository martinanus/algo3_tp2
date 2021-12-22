package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.interactuable.Ladron;
import edu.fiuba.algo3.modelo.lector.LadronParser;
import edu.fiuba.algo3.modelo.ordenesArresto.EstadoOrdenArresto;
import edu.fiuba.algo3.modelo.ordenesArresto.OrdenEmitida;
import edu.fiuba.algo3.modelo.ordenesArresto.OrdenNoEmitida;
import edu.fiuba.algo3.modelo.tiempo.Reloj;
import edu.fiuba.algo3.modelo.tiempo.Tiempo;

import java.util.ArrayList;

public class Computadora {
    private ArrayList<Ladron> sospechosos;

    public Computadora() {
        this.sospechosos = new ArrayList<>();
    }


    public void agregarSopechoso(Ladron sospechoso) {
        this.sospechosos.add(sospechoso);
    }

    public EstadoOrdenArresto emitirOrdenDeArresto(Ladron sospechosoBuscado, Reloj reloj) {
        ArrayList<Ladron> sospechososEncotrados = new ArrayList<>();
        reloj.incrementar(new Tiempo(3));
        for (Ladron sospechoso : sospechosos) {
            if(sospechosoBuscado.compararCon(sospechoso)){
                sospechososEncotrados.add(sospechoso);
            }
        }
        if (sospechososEncotrados.size()==1){
            return new OrdenEmitida();
        }
        return new OrdenNoEmitida();
    }

    public EstadoOrdenArresto emitirOrdenDeArresto2(Ladron sospechosoBuscado, Reloj reloj, Ladron ladron) {
        ArrayList<Ladron> sospechososEncotrados = new ArrayList<>();
        reloj.incrementar(new Tiempo(3));
        for (Ladron sospechoso : sospechosos) {
            if(sospechosoBuscado.compararCon(sospechoso)){
                sospechososEncotrados.add(sospechoso);
            }
        }
        if (sospechososEncotrados.size()==1){
            if (sospechososEncotrados.get(0).compararCon(ladron))
                return new OrdenEmitida();
        }
        return new OrdenNoEmitida();
    }

    public ArrayList<Ladron> cargarDatos() {
        LadronParser ladronParser = new LadronParser();
        ArrayList<Ladron> ladrones = ladronParser.parser("/jsons/ladrones.json");
        this.sospechosos.addAll(ladrones);
        return ladrones;
    }


}
