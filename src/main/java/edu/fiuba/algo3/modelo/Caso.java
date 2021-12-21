package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.interactuable.ArmaDeFuego;
import edu.fiuba.algo3.modelo.interactuable.Cuchillo;
import edu.fiuba.algo3.modelo.interactuable.Ladron;
import edu.fiuba.algo3.modelo.objeto.Objeto;

import java.lang.reflect.Array;
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

    public Caso(AlgoThief juego) {
        this.algoThief = juego;
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

    public void completarListasCiudadeDestino(ArrayList<Ciudad> ciudades){
        ArrayList<Ciudad> ciudadesCopia = new ArrayList<>(ciudades);
        for(int i =0;i<ciudadesVisitaLadron.size()-1;i++){
            if(i<1){
                ciudadesVisitaLadron.get(i).getCiudadesDestino().add(ciudadesVisitaLadron.get(i+1));
                ciudadesVisitaLadron.get(i+1).getCiudadesDestino().add(ciudadesVisitaLadron.get(i));
            }
            else{
                ciudadesVisitaLadron.get(i).getCiudadesDestino().add(ciudadesVisitaLadron.get(i+1));
                ciudadesVisitaLadron.get(i+1).getCiudadesDestino().add(ciudadesVisitaLadron.get(i));
            }
            ciudadesCopia.remove(ciudadesVisitaLadron.get(i));
        }
        ciudadesCopia.remove(ciudadesVisitaLadron.get(ciudadesVisitaLadron.size()-1 ));

        ArrayList<Ciudad> ciudadesUsadas = new ArrayList<>();
        for(Ciudad ciudadLadron: ciudadesVisitaLadron){
                Ciudad ciudad1 = generarCiudadRandom(ciudadesCopia,ciudadesUsadas);
                Ciudad ciudad2 = generarCiudadRandom(ciudadesCopia,ciudadesUsadas);
                Ciudad ciudad3 = generarCiudadRandom(ciudadesCopia,ciudadesUsadas);
                ciudadLadron.agregarCiudadDestino(ciudad1);
                ciudad1.agregarCiudadDestino(ciudadLadron);
                ciudadLadron.agregarCiudadDestino(ciudad2);
                ciudad2.agregarCiudadDestino(ciudadLadron);
            if(ciudadLadron.getCiudadesDestino().size()<=3) {
                ciudadLadron.agregarCiudadDestino(ciudad3);
                ciudad3.agregarCiudadDestino(ciudadLadron);
            }
            ciudadesUsadas.clear();
        }
        ArrayList<Ciudad> listaConPocasCiudades= new ArrayList<>();
        for (Ciudad ciudad: ciudades){
            if(ciudad.getCiudadesDestino().size()<=1){
                listaConPocasCiudades.add(ciudad);
            }
        }
        llenarCiudadesConPocasDestinos(listaConPocasCiudades);

    }

    public void llenarCiudadesConPocasDestinos(ArrayList<Ciudad> listaConPocasCiudades) {
        for(int i =0;i<listaConPocasCiudades.size()-1;i++){
            if(i<1){
                listaConPocasCiudades.get(i).getCiudadesDestino().add(listaConPocasCiudades.get(i+1));
                listaConPocasCiudades.get(i+1).getCiudadesDestino().add(listaConPocasCiudades.get(i));
            }
            else{
                listaConPocasCiudades.get(i).getCiudadesDestino().add(listaConPocasCiudades.get(i+1));
                listaConPocasCiudades.get(i+1).getCiudadesDestino().add(listaConPocasCiudades.get(i));
            }
        }
    }

    public  Ciudad generarCiudadRandom(ArrayList<Ciudad> ciudadesCopia, ArrayList<Ciudad> ciudadesUsadas) {
        Ciudad ciudadRandom = ciudadesCopia.get((int)(Math.random()* ciudadesCopia.size()));
        while(ciudadesUsadas.contains(ciudadRandom)){
            ciudadRandom = ciudadesCopia.get((int)(Math.random()* ciudadesCopia.size()));
        }
        ciudadesUsadas.add(ciudadRandom);
        return ciudadRandom;
    }
    public ArrayList<Ciudad> ciudadesLadron(){
        return ciudadesVisitaLadron;
    }


}

/**                     4
 * for(int i =0;i<ciudadesVisitaLadron.size()-1;i++){
 *     if(i<0){
 *         ciudadesVisitaLadron.get(i).getCiudadesDestino().add(ciudadesVisitaLadron.get(i+1);
 *         ciudadesVisitaLadron.get(i+1).getCiudadesDestino().add(ciudadesVisitaLadron.get(i);
 *     }
 *     else{
 *         ciudadesVisitaLadron.get(i).getCiudadesDestino().add(ciudadesVisitaLadron.get(i+1);
 *         ciudadesVisitaLadron.get(i+1).getCiudadesDestino().add(ciudadesVisitaLadron.get(i);
 *     }
 *     corrida si i=0:
 *     agrego ciudestino.get(0).add(1)
 *     agrego ciudestino.get(1).add(0)
 *     corrida si i=1:
 *     agrego ciudestino.get(1).add(2)
 *     agrego ciudestino.get(2).add(1)
 *     corrido si i=2:
 *     agrego ciudestino.get(2).add(3)
 *     agrego ciudestino.get(3).add(2)
 * }
 *Hasta ahora "conectamos todas las ciudades que recorrio el ladron entre si"
 * Ahora necesitamos poder llenar la lista de ciudades destino de todas las ciudades:
 * for(int i =0;i<ciudades.size()-1;i++){
 *     if(ciudades.get(i).getCiudadesDestino().size()<4){ //si tiene menos de 4 seguimos completando.
 *         ciudad.get(i).getCiudadesDestino().add( ciudades.get(i+1) )
 *         ciudad.get(i+1).getCiudadesDestino().add(ciudades.get(i+1) )
 *     }
 *
 * }
 *
 *
 *
 *
 */
