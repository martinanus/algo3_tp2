package edu.fiuba.algo3.modelo.ordenesArresto;

import edu.fiuba.algo3.modelo.Policia;

public class OrdenEmitida implements EstadoOrdenArresto {

    @Override
    public void arrestar(Policia policia) {
        policia.sumarArresto(1);

    }

}
