package com.trabajo.utn.trabajo_practico.modelos;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trabajo.utn.trabajo_practico.R;
import com.trabajo.utn.trabajo_practico.utils.hilos.categorias.HiloCategoria;
import com.trabajo.utn.trabajo_practico.vistas.CategoriasView;

import java.util.List;

/**
 * Created by julian.moreno on 10/16/2016.
 */

public class CategoriasModel extends RecyclerView.Adapter<CategoriasView>{
    private List<CategoriaModel> categorias;

    public CategoriasModel(List<CategoriaModel> categorias) {
        this.categorias=categorias;
    }

    @Override
    public CategoriasView onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.categoria_item,parent,false);
        CategoriasView myViewHolder=new CategoriasView(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(CategoriasView holder, int position) {
        CategoriaModel c= getCategorias().get(position);
        HiloCategoria hilo=new HiloCategoria(c,holder,position);
        hilo.start();
    }

    @Override
    public int getItemCount() {
        return getCategorias().size();
    }


    public List<CategoriaModel> getCategorias() {
        return categorias;
    }
}
