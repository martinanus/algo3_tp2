package edu.fiuba.algo3.modelo;

public class OrdenEmitida implements EstadoOrdenArresto {


    @Override
    public void terminarMision(Policia policia) {
        policia.sumarArresto(1);

    }

}
