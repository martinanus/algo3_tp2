package edu.fiuba.algo3.modelo;

public class Jugador {
    private Ciudad ciudad;
    private Mision mision;

    public Jugador(Ciudad ciudad) {
        this.ciudad = ciudad;
        mision = new Mision();
    }

    public Pista visitar(String edificio ,Reloj reloj ){
        Pista pista =  ciudad.visitar(edificio,reloj);
        Boolean plazo = mision.plazoExcedido(reloj);
        return pista;
    }

}
