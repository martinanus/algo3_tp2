package edu.fiuba.algo3.modelo.ordenesArresto;

import edu.fiuba.algo3.modelo.Policia;
import edu.fiuba.algo3.modelo.ordenesArresto.EstadoOrdenArresto;

public class OrdenNoEmitida implements EstadoOrdenArresto {

    @Override
    public void arrestar(Policia policia) {
        policia.sumarArresto(0); //esto es un error, notificamos a alguien
        throw new  OrdenNoEmitidadError();
        // error que dice NO EMITIO el policia la orden ade arresto no puedo detenr al sospechoso.
        //policia.fallarArresto(); if(contadorArresto=0) esta mal ,
    }
}
