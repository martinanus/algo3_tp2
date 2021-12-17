package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.interactuable.ArmaDeFuego;
import edu.fiuba.algo3.modelo.interactuable.Cuchillo;
import edu.fiuba.algo3.modelo.interactuable.Ladron;
import edu.fiuba.algo3.modelo.objeto.Objeto;

import java.util.ArrayList;
import java.util.Iterator;


public class Caso {
    private AlgoThief algoThief;
    private Objeto objeto;
    private Ladron ladron;
    private ArrayList<Ciudad> ciudadesVisitaLadron;

    public Caso(Objeto objeto, ArrayList<Ciudad> ciudadesVisitaLadron,Ladron ladron, AlgoThief algoThief) {
        this.objeto = objeto;
        this.ciudadesVisitaLadron = ciudadesVisitaLadron;
        this.ladron = ladron;
        this.algoThief = algoThief;
        this.cargarEdificios();
        this.cargarPistasLadron();
    }
    private void  cargarEdificios(){
        Iterator<Ciudad> iterador = ciudadesVisitaLadron.iterator();
        Ciudad ciudadActual = iterador.next(); //Devuelve Primera ciudad
        while(iterador.hasNext()){
            Ciudad ciudadProxima = iterador.next(); //1eraIter-Segunda ciudad -2doIteracion le da 3eraCiudad
            ciudadActual.llenarPistas(ciudadProxima);
            ciudadActual = ciudadProxima;  //Segunda ciudad 2-daItera la pisamos con ciudad3
        }

        Edificio banco = new Edificio(new ArmaDeFuego(),"banco");
        Edificio biblioteca = new Edificio(ladron,"biblioteca");
        Edificio puerto = new Edificio(new Cuchillo(),"puerto");
        ciudadActual.agregarEdificio(banco);
        ciudadActual.agregarEdificio(biblioteca);
        ciudadActual.agregarEdificio(puerto);
    }

    private void cargarPistasLadron() {
        for (int i = 0; i < ciudadesVisitaLadron.size() - 1; i++)
            ciudadesVisitaLadron.get(i).llenarPistaLadron(ladron);
    }


    public Ciudad getCiudadOrigen() {
        return ciudadesVisitaLadron.get(0);
    }

    public void finalizar() {
        this.algoThief.finalizar(this.objeto, this.ladron);
    }

    public void finalizarSinExito() {
        this.algoThief.finalizar();
    }
}