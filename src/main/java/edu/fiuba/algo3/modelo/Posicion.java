package edu.fiuba.algo3.modelo;

import static java.lang.Math.*;

public class Posicion {

    private static final int RadioTierraKm = 6371;

    private final double latitud;

    private final double longitud;

    public Posicion(double latitud, double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public double calcularDistancia(double latitud, double longitud) {
        double difLatitud = toRadians(latitud - this.latitud);
        double difLongitud = toRadians(longitud - this.longitud);

        double a = pow(sin(difLatitud/2), 2) + cos(toRadians(this.latitud)) * cos(toRadians(latitud)) * pow(sin(difLongitud/2), 2);
        double c = 2 * atan2(sqrt(a), sqrt(1 - a));

        return RadioTierraKm * c;
    }

    public double calcularDistanciaCon(Posicion posicion) {
        return posicion.calcularDistancia(this.latitud, this.longitud);
    }
}
