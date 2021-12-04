package edu.fiuba.algo3.modelo;

public class Tiempo {
    private double horas;

    public Tiempo(double horas){
        this.horas = horas;
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
        if(this.horas > horas){
            return true;
        }
        return false;
    }
}

