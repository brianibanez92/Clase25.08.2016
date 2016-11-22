package com.trabajo.utn.trabajo_practico.utils.hilos.categorias;

import android.annotation.TargetApi;
import android.os.Build;

import com.trabajo.utn.trabajo_practico.modelos.CategoriaModel;
import com.trabajo.utn.trabajo_practico.vistas.CategoriasView;

/**
 * Created by julian.moreno on 10/24/2016.
 */

public class HiloCategoria extends Thread{

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public HiloCategoria(CategoriaModel c, CategoriasView holder, int position){
        holder.getTvNombre().setText(c.getNombre());
        holder.getTvDescripcion().setText(c.getDescripcion());
        holder.getIvFoto().setBackground(c.getFoto());
        holder.setIndex(position);
    }
}
