package edu.fiuba.algo3.modelo;

public class Ciudad {
    private Edificio edificio;

    public Ciudad(Edificio edificio) {
        this.edificio = edificio;
    }

    public Pista  visitar(String edificioNombre ,Reloj reloj){
        //"this.edificio.nombre() = edificio"
        return edificio.visitar(reloj);
    }

}
