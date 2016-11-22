package com.trabajo.utn.trabajo_practico.modelos;

import android.graphics.drawable.Drawable;

/**
 * Created by julian.moreno on 9/22/2016.
 */
public class CategoriaModel {
    private String nombre;
    private String descripcion;
    private Drawable foto;

    public CategoriaModel(){
        super();
    }
    public CategoriaModel(String nombre,String descripcion) {
        this();
        this.nombre=nombre;
        this.descripcion=descripcion;
    }
    public CategoriaModel(String nombre,String descripcion,Drawable fotoAux) {
        this(nombre,descripcion);
        this.setFoto(fotoAux);
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Drawable getFoto() {
        return foto;
    }

    public void setFoto(Drawable foto) {
        this.foto = foto;
    }
}
