package edu.fiuba.algo3.modelo.ordenesArresto;

import edu.fiuba.algo3.modelo.Policia;
import edu.fiuba.algo3.modelo.ordenesArresto.EstadoOrdenArresto;

public class OrdenNoEmitida implements EstadoOrdenArresto {

    @Override
    public void arrestar(Policia policia) {
        throw new  OrdenNoEmitidadError();
    }
}
