package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interactuable.Ladron;
import edu.fiuba.algo3.modelo.lector.LadronParser;

import java.util.ArrayList;

public class Computadora {
    private ArrayList<Ladron> sospechosos;

    public Computadora() {
        this.sospechosos = new ArrayList<>();
    }


    public void agregarSopechoso(Ladron sospechoso) {
        this.sospechosos.add(sospechoso);
    }

    public boolean emitirOrdenDeArresto(Ladron sospechosoBuscado) {
        ArrayList<Ladron> sospechososEncotrados = new ArrayList<>();
        for (Ladron sospechoso : sospechosos) {
            if(sospechosoBuscado.compararCon(sospechoso)){
                sospechososEncotrados.add(sospechoso);
            }
        }
        return (sospechososEncotrados.size()==1) ;
    }

    public void cargarDatos() {
        LadronParser ladronParser = new LadronParser();
        ArrayList<Ladron> ladrones = ladronParser.parser("/jsons/ladrones.json");
        this.sospechosos.addAll(ladrones);
    }

}
