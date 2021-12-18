package edu.fiuba.algo3.modelo.tiempo;


import java.util.ArrayList;

public class Reloj {
    private Tiempo tiempoMaximo;
    private Tiempo tiempoTranscurrido;

    public Reloj(Tiempo tiempoMaximo) {
        this.tiempoMaximo = tiempoMaximo;
        this.tiempoTranscurrido = new Tiempo(0);
    }


    public void incrementar(Tiempo tiempo) {
        tiempoTranscurrido.incrementar(tiempo);
        tiempoTranscurrido.actualizar();
        horaDeDormir();
        verificarTiempoExcedido();
    }

    private void verificarTiempoExcedido() {
        if(tiempoTranscurrido.esMayor(tiempoMaximo)){
            throw new TiempoExcedidoError();
        }
    }

    public Tiempo tiempoTranscurrido() {
        return tiempoTranscurrido;
    }

    public boolean horaDormir() {
        int[] cotaInferior = new int[]{22, 47, 71, 95, 119, 141};
        int[] cotaSuperior = new int[]{24, 49, 73, 97, 121, 145};
        boolean resultado = false;
        for (int i = 0; i < 6; i++) {
            if (tiempoTranscurrido().getTiempo() >= cotaInferior[i] && tiempoTranscurrido().getTiempo() <= cotaSuperior[i]) {
                resultado=true;
            }
        }
        return resultado;
    }

    private void horaDeDormir() {
        this.tiempoTranscurrido.horaDeDormir(this);
    }

    public String getDia() {
        return this.tiempoTranscurrido.getDia();
    }

    public double getHoraActual() {
        return this.tiempoTranscurrido.getHoraActual();
    }
}
