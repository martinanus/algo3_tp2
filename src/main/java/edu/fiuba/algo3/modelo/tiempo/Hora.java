package edu.fiuba.algo3.modelo.tiempo;

public class Hora {

    private double valor;  // Toma valores entre 0 y 23

    public Hora(int horaInicial) {
        this.valor = horaInicial;
    }

    public void actualizar(double horas, int horaMin) {
        valor = horas - horaMin;
    }

    public boolean esHoraDeDormir() {
        return (this.valor >= 0 & this.valor < 8);
    }

    public double getValor() {
        return this.valor;
    }

    public boolean equals(Hora hora) {
        return this.valor == hora.getValor();
    }
}
