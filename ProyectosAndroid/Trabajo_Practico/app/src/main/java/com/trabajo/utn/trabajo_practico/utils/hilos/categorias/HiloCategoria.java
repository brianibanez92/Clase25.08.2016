package com.trabajo.utn.trabajo_practico.utils.hilos.categorias;

import com.trabajo.utn.trabajo_practico.modelos.clases_pojo.Categoria;
import com.trabajo.utn.trabajo_practico.vistas.CategoriasView;

/**
 * Created by julian.moreno on 10/24/2016.
 */

public class HiloCategoria extends Thread{

    public HiloCategoria(Categoria c,CategoriasView holder,int position){
        holder.getTvNombre().setText(c.getNombre());
        holder.getTvDescripcion().setText(c.getDescripcion());
        holder.getIvFoto().setImageResource(c.getIdFoto());
        holder.setIndex(position);
    }
}
