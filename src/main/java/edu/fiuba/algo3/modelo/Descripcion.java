package edu.fiuba.algo3.modelo;

import java.util.Objects;

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

    public Descripcion() {

    }


    public boolean comparar(Descripcion descripcion) {
        if(!Objects.equals(descripcion.getSexo(), "") && !Objects.equals(this.sexo, descripcion.getSexo())) {
            return false;
        }
        if(!Objects.equals(descripcion.getHobby(), "") && !Objects.equals(this.hobby, descripcion.getHobby())) {
            return false;
        }
        if(!Objects.equals(descripcion.getCabello(), "") && !Objects.equals(this.cabello, descripcion.getCabello())) {
            return false;
        }
        if(!Objects.equals(descripcion.getSeña(), "") && !Objects.equals(this.seña, descripcion.getSeña())) {
            return false;
        }
        if(!Objects.equals(descripcion.getVehiculo(), "") && !Objects.equals(this.vehiculo, descripcion.getVehiculo())) {
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
