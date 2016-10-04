package com.trabajo.utn.trabajo_practico.vistas.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

import com.trabajo.utn.trabajo_practico.R;
import com.trabajo.utn.trabajo_practico.modelos.clases_pojo.Categoria;
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
          Categoria c=categorias.get(position);
          holder.tvNombre.setText(c.getNombre());
          holder.tvDescripcion.setText(c.getDescripcion());
          if(c.getIdFoto()!=0){holder.ivFoto.setImageResource(c.getIdFoto());}
          holder.index=position;
     }

     @Override
     public int getItemCount() {
          return categorias.size();
     }
}
