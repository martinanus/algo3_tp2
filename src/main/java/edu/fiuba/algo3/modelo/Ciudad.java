package edu.fiuba.algo3.modelo;

public class Ciudad {
    private Edificio edificio;
    private String nombreCiudad;

    public Ciudad(Edificio edificio) {
        this.edificio = edificio;
    }

    public Ciudad(Edificio edificio, String nombreCiudad) {
        this.edificio = edificio;
        this.nombreCiudad = nombreCiudad;
    }

    public Pista visitar(String edificioNombre ,Reloj reloj){
        //"this.edificio.nombre() = edificio"
        return edificio.visitar(reloj);
    }

}
