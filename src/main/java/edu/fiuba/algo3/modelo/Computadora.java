package edu.fiuba.algo3.modelo;

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
        for (Ladron sospechoso :sospechosos) {
            if (sospechoso.compararCon(sospechosoBuscado)){
                sospechososEncotrados.add(sospechoso);
            }

        }
        return sospechososEncotrados.size()==1;
    }
}
