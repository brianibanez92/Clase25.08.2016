package utn.com.ar.httpexamplejpg.clases;

import android.graphics.drawable.Drawable;

/**
 * Created by julian.moreno on 11/26/2016.
 */

public class Categoria {
    private String nombre;
    private String descripcion;
    private Drawable foto;

    public Categoria(){
        super();
    }
    public Categoria(String nombre,String descripcion) {
        this();
        this.nombre=nombre;
        this.descripcion=descripcion;
    }
    public Categoria(String nombre,String descripcion,Drawable fotoAux) {
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
