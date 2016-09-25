package com.trabajo.utn.trabajo_practico.vistas.adapters;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

import com.trabajo.utn.trabajo_practico.R;
import com.trabajo.utn.trabajo_practico.modelos.clases.Categoria;
import com.trabajo.utn.trabajo_practico.vistas.holders.CategoriasViewHolder;

/**
 * Created by julian.moreno on 9/25/2016.
 */
public class CategoriaAdapter extends RecyclerView.Adapter<CategoriasViewHolder>{
     private List<Categoria> categorias;

     public CategoriaAdapter(List<Categoria> categorias) {
          this.categorias = categorias;
     }

     @Override
     public CategoriasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
          View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.categoria_item,parent,false);
          CategoriasViewHolder myViewHolder=new CategoriasViewHolder(v);
          return myViewHolder;
     }

     @Override
     public void onBindViewHolder(CategoriasViewHolder holder, int position) {
          Categoria p=categorias.get(position);
          holder.tvNombre.setText(p.getNombre());
          holder.tvDescripcion.setText(p.getDescripcion());
          holder.index=position;
     }

     @Override
     public int getItemCount() {
          return categorias.size();
     }
}
