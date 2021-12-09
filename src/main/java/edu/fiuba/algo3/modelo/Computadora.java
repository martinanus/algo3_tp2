package edu.fiuba.algo3.modelo;

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

    public int emitirOrdenDeArresto(Ladron sospechosoBuscado) {
        ArrayList<Ladron> sospechososEncotrados = new ArrayList<>();
        for (Ladron sospechoso : sospechosos) {
            if(sospechosoBuscado.compararCon(sospechoso)){
                sospechososEncotrados.add(sospechoso);
            }
        }
        return sospechososEncotrados.size();
    }

    public void cargarDatos() {
        LadronParser ladronParser = new LadronParser();
        ArrayList<Ladron> ladrones = ladronParser.parser("/jsons/ladrones.json");
        this.sospechosos.addAll(ladrones);
    }


    public ArrayList<Ladron> cargarDatoSospechoso(Descripcion descripcion4) {
        Ladron posibleLadron = new Ladron(descripcion4);
        ArrayList<Ladron> sospechososEncotrados = new ArrayList<>();
        for (Ladron sospechoso : sospechosos) {
            if(posibleLadron.compararCon(sospechoso)){
                sospechososEncotrados.add(sospechoso);
            }
        }
        return sospechososEncotrados;
    }
}
