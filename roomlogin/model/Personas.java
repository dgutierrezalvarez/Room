package com.company.roomlogin.model;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Personas {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String nombre;
    public String portada;

    public Personas(String nombre, String portada) {
        this.nombre = nombre;
        this.portada = portada;
    }
    @NonNull
    @Override
    public String toString() {
        return "PERSONA = " + nombre + " " + portada;
    }

}
