package edu.fiuba.algo3.modelo;

public class Jugador {
    private Ciudad ciudad;
    private Mision mision;
    private Rango rango;
    protected int velocidad;

    public Jugador(Ciudad ciudad) {
        this.ciudad = ciudad;
        mision = new Mision();
    }

    /*public Jugador(Ciudad ciudad, Rango rango) {
        this.ciudad = ciudad;
        mision = new Mision();
        this.rango = rango;
    }*/

    public Pista visitar(Edificio edificio ,Reloj reloj ){
        Pista pista =  ciudad.visitar(edificio,reloj);
        Boolean plazo = mision.plazoExcedido(reloj);
        return pista;
    }

    public void viajar(Ciudad ciudad, Reloj reloj) {
        this.ciudad = ciudad;
        double tiempo = this.ciudad.viajar(velocidad);
        reloj.incrementar(tiempo);
    }
}
