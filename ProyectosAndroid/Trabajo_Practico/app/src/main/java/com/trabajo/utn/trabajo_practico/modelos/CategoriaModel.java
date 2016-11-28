package com.trabajo.utn.trabajo_practico.modelos;

/**
 * Created by julian.moreno on 9/22/2016.
 */
public class CategoriaModel {
    private String nombre;
    private String descripcion;
    private String rutaFoto;

    public CategoriaModel(){
        super();
    }
    public CategoriaModel(String nombre,String descripcion) {
        this();
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.setRutaFoto("default.jpg");
    }
    public CategoriaModel(String nombre,String descripcion,String rutaFoto) {
        this(nombre,descripcion);
        this.setRutaFoto(rutaFoto);
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

    public String getRutaFoto() {
        return rutaFoto;
    }

    public void setRutaFoto(String rutaFoto) {
        this.rutaFoto = rutaFoto;
    }
}
