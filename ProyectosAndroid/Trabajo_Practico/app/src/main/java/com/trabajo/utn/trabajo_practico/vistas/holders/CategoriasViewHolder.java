package com.trabajo.utn.trabajo_practico.vistas.holders;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.trabajo.utn.trabajo_practico.R;


/**
 * Created by julian.moreno on 9/25/2016.
 */
public class CategoriasViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView tvNombre;
    public TextView tvDescripcion;
    public ImageView ivFoto;
    public int index;

    public CategoriasViewHolder(View v) {
        super(v);
        tvNombre=(TextView)v.findViewById(R.id.txtNombre);
        tvDescripcion=(TextView)v.findViewById(R.id.txtDescripcion);
        ivFoto=(ImageView)v.findViewById(R.id.imgFoto);
        v.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.d("Se hizo click","Index: "+index);
    }

}
