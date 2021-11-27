package edu.fiuba.algo3.modelo;

import java.time.LocalDateTime;

public class Reloj {
    private LocalDateTime fechaHora;

    public Reloj() {
        fechaHora = LocalDateTime.now();
    }

    //Constructor copia
    public Reloj(Reloj reloj) {
        this.fechaHora = reloj.fechaHora;
    }


    public void incrementar(double horas) {
        long segundos = (long) (horas * 3600) ; // 3600 secs en una hora
        fechaHora = fechaHora.plusSeconds(segundos);
    }

    public LocalDateTime mostrar() {
        return fechaHora;
    }
}
