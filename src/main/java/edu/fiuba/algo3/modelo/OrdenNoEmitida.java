package edu.fiuba.algo3.modelo;

public class OrdenNoEmitida implements EstadoOrdenArresto {

    @Override
    public void terminarMision(Policia policia) {
        policia.sumarArresto(0);
    }
}
