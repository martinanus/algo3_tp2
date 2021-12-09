package edu.fiuba.algo3.modelo;


public class Reloj {
    private Tiempo tiempoMaximo;
    private Tiempo tiempoTranscurrido;

    public Reloj(Tiempo tiempoMaximo) {
        this.tiempoMaximo = tiempoMaximo;
        this.tiempoTranscurrido = new Tiempo(0);
    }


    public void incrementar(Tiempo tiempo) {
        tiempoTranscurrido.incrementar(tiempo);
        verificarTiempoExcedido();
    }

    private void verificarTiempoExcedido() {
        if(tiempoTranscurrido.esMayor(tiempoMaximo)){
            //throw new Exception("TERMINO EL JUEGO; TIEMPO MAXIMO EXCEDIDO");
        }
    }

    public Tiempo mostrar() {
        return tiempoTranscurrido;
    }

}
