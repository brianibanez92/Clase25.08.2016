package com.trabajo.utn.trabajo_practico.modelos;

import com.trabajo.utn.trabajo_practico.modelos.clases.Estado;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by julian.moreno on 9/22/2016.
 */
public class CategoriaModel {
    private Integer idCategoria;
    private String nombre;
    private String descripcion;
    private String rutaFoto;
    private Estado estado;

    public CategoriaModel(){
        super();
        estado=new Estado();
    }
    public CategoriaModel(String nombre,String descripcion) {
        this();
        this.nombre=nombre;
        this.descripcion=descripcion;
    }
    public CategoriaModel(String nombre,String descripcion,String rutaFoto) {
        this(nombre,descripcion);
        this.setRutaFoto(rutaFoto);
    }
    public CategoriaModel(JSONObject json){
        try {
                setIdCategoria(json.getInt("id"));
                setDescripcion(json.getString("desc"));
                setNombre(json.getString("titulo"));
                setRutaFoto(json.getString("url_foto"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
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

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
