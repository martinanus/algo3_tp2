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


    public boolean comparar(Descripcion descripcion) {
        if(!Objects.equals(this.sexo, "") && !Objects.equals(this.sexo, descripcion.getSexo())) {
            return false;
        }
        if(!Objects.equals(this.hobby, "") && !Objects.equals(this.hobby, descripcion.getHobby())) {
            return false;
        }
        if(!Objects.equals(this.cabello, "") && !Objects.equals(this.cabello, descripcion.getCabello())) {
            return false;
        }
        if(!Objects.equals(this.seña, "") && !Objects.equals(this.seña, descripcion.getSeña())) {
            return false;
        }
        if(!Objects.equals(this.vehiculo, "") && !Objects.equals(this.vehiculo, descripcion.getVehiculo())) {
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
