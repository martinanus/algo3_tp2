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
            //Lanzamos la excepcion directamente,
            //throw new Exception("TERMINO EL JUEGO; TIEMPO MAXIMO EXCEDIDO"); RELOJ NO TIENE QUE SABER JUEGO
        }
    }

    public Tiempo tiempoTranscurrido() {
        return tiempoTranscurrido;
    }

}
