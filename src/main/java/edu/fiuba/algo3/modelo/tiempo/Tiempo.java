package edu.fiuba.algo3.modelo.tiempo;

import java.util.HashMap;

public class Tiempo {
    private double horas;

    private static final int HoraInicial = 7;

    private Hora horaActual;

    private Dia diaActual;

    private HashMap<String, Dia> dias;

    public Tiempo(double horas){
        this.horas = horas;

        this.horaActual = new Hora(HoraInicial);
        this.diaActual = new Dia("Lunes", 0, 23);
        this.dias = new HashMap<String, Dia>() {{
            put("Martes", new Dia("Martes", 24, 47));
            put("Miercoles", new Dia("Miercoles", 48, 71));
            put("Jueves", new Dia("Jueves", 72, 95));
            put("Viernes", new Dia("Viernes", 96, 119));
            put("Sabado", new Dia("Sabado", 120, 143));
            put("Domingo", new Dia("Domingo", 144, 167));
        }};
    }
    public void incrementar(Tiempo tiempo) {
        this.horas = tiempo.incrementar(this.horas);
    }

    private double incrementar(double horas) {
        return this.horas + horas;
    }

    // Overriding equals() to compare two Tiempo objects
    @Override
    public boolean equals(Object o) {

        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Tiempo or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Tiempo)) {
            return false;
        }

        // typecast o to Tiempo so that we can compare data members
        Tiempo c = (Tiempo) o;

        // Compare the data members and return accordingly
        return Double.compare(this.horas, c.horas) == 0;
    }


    public boolean esMayor(Tiempo tiempoMaximo) {
        return ! tiempoMaximo.esMayor(this.horas);
    }

    private boolean esMayor(double horas) {
        return this.horas > horas;
    }
    public double getTiempo(){
        return this.horas;
    }

    public void actualizar() {
        verificarDia(horas + HoraInicial);
        this.diaActual.actualizar(horas + HoraInicial, this.horaActual);
    }

    private void verificarDia(double horas) {
        for (Dia dia : dias.values()) {
            if (dia.contieneHoras(horas))
                this.diaActual = dia;
        }
    }

    public void horaDeDormir(Reloj reloj) {
        if (this.horaActual.esHoraDeDormir())
            reloj.incrementar(new Tiempo(8));
    }

    public String getDia() {
        return this.diaActual.getNombre();
    }

    public double getHoraActual() {
        return this.horaActual.getValor();
    }
}

