package edu.fiuba.algo3.modelo.rango;

import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.Reloj;

public interface Rango {

    void viajar(Ciudad ciudadOrigen, Ciudad ciudadDestino, Reloj reloj);

    Rango arrestar(int contadorArrestos);
}
