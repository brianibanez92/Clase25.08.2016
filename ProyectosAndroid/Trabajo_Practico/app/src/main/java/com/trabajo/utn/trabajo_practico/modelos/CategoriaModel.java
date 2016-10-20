package com.trabajo.utn.trabajo_practico.modelos;

/**
 * Created by julian.moreno on 9/22/2016.
 */
public class CategoriaModel {
    private String nombre;
    private String descripcion;
    private int idFoto;

    public CategoriaModel(){
        super();
    }
    public CategoriaModel(String nombre,String descripcion) {
        this();
        this.nombre=nombre;
        this.descripcion=descripcion;
    }
    public CategoriaModel(String nombre,String descripcion,int idFoto) {
        this(nombre,descripcion);
        this.idFoto=idFoto;
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

    public int getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(int idFoto) {
        this.idFoto = idFoto;
    }
}
