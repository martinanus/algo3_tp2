package edu.fiuba.algo3.modelo;

public class Jugador {
    private Ciudad ciudadActual;
    private Mision mision;
    private Rango rango;
    protected int velocidad;

    public Jugador(Ciudad ciudad) {
        ciudadActual = ciudad;
        mision = new Mision();
    }

    public Jugador(Ciudad ciudad, Rango rango) {
        ciudadActual = ciudad;
        mision = new Mision();
        this.rango = rango;
    }

    public Pista visitar(Edificio edificio ,Reloj reloj ){
        Pista pista =  ciudadActual.visitar(edificio,reloj);
        Boolean plazo = mision.plazoExcedido(reloj);
        return pista;
    }

    public void viajar(Ciudad ciudadDestino, Reloj reloj) {
        rango.viajar(ciudadActual,ciudadDestino, reloj);
        this.ciudadActual = ciudadDestino;
    }

    public void duerme(Reloj reloj) {
        reloj.incrementar(8); //duerme 8hs
    }

    public void herir(Arma arma, Reloj reloj) {
        arma.herir(reloj);
    }
}
