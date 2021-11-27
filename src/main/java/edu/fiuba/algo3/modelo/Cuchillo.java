package edu.fiuba.algo3.modelo;

public class Cuchillo extends Arma{

    private int contadorAtaques;

    public void Cuchillo(){
        contadorAtaques = 0;
    }

    @Override
    public void herir(Reloj reloj) {
        if (contadorAtaques == 0){
            reloj.incrementar(2);
        } else {
            reloj.incrementar(1);
        }
        contadorAtaques++;
    }
}