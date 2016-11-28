package com.trabajo.utn.trabajo_practico.modelos;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.api.client.json.Json;
import com.trabajo.utn.trabajo_practico.CategoriaActivity;
import com.trabajo.utn.trabajo_practico.CategoriasActivity;
import com.trabajo.utn.trabajo_practico.R;
import com.trabajo.utn.trabajo_practico.utils.hilos.HiloCategoria;
import com.trabajo.utn.trabajo_practico.vistas.CategoriasView;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by julian.moreno on 10/16/2016.
 */

public class CategoriasModel extends RecyclerView.Adapter<CategoriasView>{
    private List<CategoriaModel> categorias;

    public CategoriasModel() {categorias=new ArrayList<>();}
    public CategoriasModel(JSONArray lista){
        CategoriaModel cat;
        for(int i=0;i<lista.length();i++){
            //cat=new CategoriaModel()
        }
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

    public void addCategoria(CategoriaModel categoria){
        categorias.add(categoria);
    }
}
