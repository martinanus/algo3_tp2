package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.interactuable.Ladron;
import edu.fiuba.algo3.modelo.lector.LadronParser;
import edu.fiuba.algo3.modelo.ordenesArresto.EstadoOrdenArresto;
import edu.fiuba.algo3.modelo.ordenesArresto.OrdenEmitida;
import edu.fiuba.algo3.modelo.ordenesArresto.OrdenNoEmitida;

import java.util.ArrayList;

public class Computadora {
    private ArrayList<Ladron> sospechosos;

    public Computadora() {
        this.sospechosos = new ArrayList<>();
    }


    public void agregarSopechoso(Ladron sospechoso) {
        this.sospechosos.add(sospechoso);
    }

    public EstadoOrdenArresto emitirOrdenDeArresto(Ladron sospechosoBuscado) {
        ArrayList<Ladron> sospechososEncotrados = new ArrayList<>();
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

    public void cargarDatos() {
        LadronParser ladronParser = new LadronParser();
        ArrayList<Ladron> ladrones = ladronParser.parser("/jsons/ladrones.json");
        this.sospechosos.addAll(ladrones);
    }

}
