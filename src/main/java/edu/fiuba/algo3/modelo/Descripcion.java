package edu.fiuba.algo3.modelo;

public class Descripcion {
    String nombre;
    String sexo;
    String hobby;
    String cabello;
    String seña;
    String vehiculo;

    public Descripcion(String nombre, String sexo, String Hobby, String cabello, String seña, String vehiculo){
            this.nombre = nombre;
            this.sexo = sexo;
            this.hobby = Hobby;
            this.cabello = cabello;
            this.seña = seña;
            this.vehiculo = vehiculo;
    }


    public boolean comparar(Descripcion descripcion) {
        //return sexo==descripcion.getSexo();
        if(this.sexo != "" && this.sexo != descripcion.getSexo()) {
            return false;
        }
        if(this.hobby != "" && this.hobby != descripcion.getHobby()) {
            return false;
        }
        if(this.cabello != "" && this.cabello != descripcion.getCabello()) {
            return false;
        }
        if(this.seña != "" && this.seña != descripcion.getSeña()) {
            return false;
        }
        if(this.vehiculo != "" && this.vehiculo != descripcion.getVehiculo()) {
            return false;
        }
        return true;
    }

    private String getVehiculo() {
        return vehiculo;
    }

    private String getSeña() {
        return seña;
    }

    private String getCabello() {
        return cabello;
    }

    private String getHobby() {
        return hobby;
    }

    private String getSexo() {
        return sexo;
    }
}
