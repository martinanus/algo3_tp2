package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.interactuable.Interactuable;
import edu.fiuba.algo3.modelo.interactuable.Ladron;
import edu.fiuba.algo3.modelo.objeto.Objeto;
import edu.fiuba.algo3.modelo.tiempo.Reloj;
import edu.fiuba.algo3.modelo.tiempo.Tiempo;
import edu.fiuba.algo3.modelo.tiempo.TiempoExcedidoError;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
//boton que se puede descansar con un pais de la ciudad en la que esta es X
//cuando el policia descansa el policia recupera tiempo, lo que avanzo el reloj vuelve para atras
//Si la letra es a recupera media hora, tambien puede descansar en una ciudad que empieze con m
//Si la letra es b recupera una hora
// si la ciudad es otra no aplica .
//El boton de descansar se puede hacer si la letra de las ciudades es a y b .
public class AlgoThief {
    private ArrayList<Ciudad> ciudades;
    private ArrayList<Objeto> objetosRobados;
    private Computadora computadora;
    private ArrayList<Ladron> ladrones;
    private CargadorDatos cargadorDatos;
    private Reloj reloj;
    private Descripcion descripcionSospechoso;
    private Policia jugador;

    public AlgoThief(){
        descripcionSospechoso = new Descripcion();
        computadora = new Computadora();
        cargadorDatos = new CargadorDatos();
        this.ladrones = cargadorDatos.cargarLadrones(computadora);
        this.objetosRobados = cargadorDatos.cargarObjetosRobados();
        reloj = new Reloj(new Tiempo(154)); // Lunes 7 a.m. + 154 hs = Domingo 5 p.m. (17)
    }

    public void generarPartida() {
        Ladron ladron = ladrones.get( (int)(Math.random()* ladrones.size()) );
        this.ciudades = cargadorDatos.cargarCiudades();
        cargadorDatos.cargarPistas(ciudades);
        jugador.generarCaso(objetosRobados,ciudades,ladron, this); //refactor nombre
        this.jugador.reiniciarOrden();
    }


    public Interactuable visitar(String nombreEdificio) {
        try {
            return jugador.visitar(nombreEdificio,reloj);
        } catch(TiempoExcedidoError e) {
            this.finalizar();
            throw new CasoFinalizadoSinExitoError();
        }
    }

    public void viajar(String nombreCiudad) {
        for(Ciudad ciudad: ciudades){
            if(Objects.equals(ciudad.getNombre(), nombreCiudad )){
                try {
                    jugador.viajar(ciudad,reloj);
                } catch(TiempoExcedidoError e) {
                    this.finalizar();
                    throw new CasoFinalizadoSinExitoError();
                }
            }
        }
    }
    public Reloj getReloj(){
        return this.reloj;
    }

    public void cargarDescripcion(Descripcion descripcion) {
        this.descripcionSospechoso = descripcion;

    }

    public void generarOrdenDeArresto() {
        Ladron ladronSopechoso = new Ladron(descripcionSospechoso);
        try {
            jugador.emitirOrdenArresto(computadora,ladronSopechoso,reloj);
        } catch(TiempoExcedidoError e) {
            this.finalizar();
            throw new CasoFinalizadoSinExitoError();
        }
    }

    public void finalizar(Objeto objetoRobado) {
        this.objetosRobados.remove(objetoRobado);
        this.reloj = new Reloj(new Tiempo(154));
    }

    public void finalizar() {
        this.reloj = new Reloj(new Tiempo(154));
    }

    public String descripcionCiudad() {
        return jugador.getCiudadActual().getInformacion();
    }


    public void setPolicia(Policia unPolicia){
        this.jugador = unPolicia;
    }

    public String mostrarReloj() {
        return reloj.getDia() + ", " + Double.toString(reloj.getHoraActual()) + "hs";
    }


    public String mostrarCiudadActual() {
        return jugador.mostrarCiudadActual();
    }

    public String mostrarCiudadesDisponibles() {
        return jugador.mostrarCiudadesDisponibles();
    }
    public ArrayList<Ciudad> obtenerCiudades(){
        return ciudades;
    }

    public ArrayList<Ciudad> mostrarCiudadesDestino() {
        return  jugador.getCiudadActual().mostrarCiudadesDestino();
    }

    public String descripcionCaso()
    {
        return jugador.getDescripcionCaso();
    }

    public String getMensajeOrden() {
        return this.jugador.mostrarOrden();
    }

    public String getRangoPolicia() {
        return this.jugador.mostrarRango();
    }

    public String getNombrePolicia() {
        return this.jugador.getNombre();
    }


    public String getNombreLadron() {
        return this.jugador.getNombreLadron();
    }
}
