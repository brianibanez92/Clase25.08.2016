package com.trabajo.utn.trabajo_practico.modelos.clases_pojo;

import com.trabajo.utn.trabajo_practico.R;

/**
 * Created by julian.moreno on 9/25/2016.
 */
public class Categoria {
    private String nombre;
    private String descripcion;
    private int idFoto;

    public Categoria(){
        super();
    }
    public Categoria(String nombre,String descripcion) {
        this();
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.idFoto=R.drawable.avatar;
    }
    public Categoria(String nombre,String descripcion,int idFoto) {
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
