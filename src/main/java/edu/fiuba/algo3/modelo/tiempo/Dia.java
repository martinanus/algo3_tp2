package edu.fiuba.algo3.modelo.tiempo;

public class Dia {

    private final String nombre;

    private final int horaMin;

    private final int horaMax;

    public Dia(String nombre, int horaMin, int horaMax) {
        this.nombre = nombre;
        this.horaMin = horaMin;
        this.horaMax = horaMax;
    }

    public boolean contieneHoras(double horas) {
        return horaMin <= horas & horas <= horaMax;
    }

    public void actualizar(double horas, Hora hora) {
        hora.actualizar(horas, this.horaMin);
    }

    public String getNombre() {
        return this.nombre;
    }

    public boolean equals(Dia dia) {
        return this.nombre.equals(dia.getNombre());
    }
}
