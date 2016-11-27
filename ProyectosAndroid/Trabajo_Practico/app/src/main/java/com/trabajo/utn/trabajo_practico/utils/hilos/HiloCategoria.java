package com.trabajo.utn.trabajo_practico.utils.hilos;

import android.annotation.TargetApi;
import android.os.Build;

import com.trabajo.utn.trabajo_practico.modelos.CategoriaModel;
import com.trabajo.utn.trabajo_practico.vistas.CategoriaView;
import com.trabajo.utn.trabajo_practico.vistas.CategoriasView;

/**
 * Created by julian.moreno on 10/24/2016.
 */

public class HiloCategoria extends Thread{
    private CategoriaModel c;
    private CategoriasView holder;
    private int position;

    public HiloCategoria(CategoriaModel c, CategoriasView holder, int position){
        this.c=c;
        this.holder=holder;
        this.position=position;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void run(){
        holder.getTvNombre().setText(c.getNombre());
        holder.getTvDescripcion().setText(c.getDescripcion());
        holder.getIvFoto().setBackground(c.getFoto());
        holder.setIndex(position);
    }
}
