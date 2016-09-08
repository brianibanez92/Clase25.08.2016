package com.example.alumno.clase_4;

/**
 * Created by alumno on 08/09/2016.
 */
public class Persona {
    private String nombre;
    private String apellido;

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public void setNombre(String texto1) {
        this.nombre = texto1;
    }
    public String getNombre() {
        return nombre;
    }
    public void setApellido(String texto2) {
        this.apellido = texto2;
    }
    public String getApellido() {
        return apellido;
    }
}