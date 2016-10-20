package com.trabajo.utn.trabajo_practico.vistas;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.trabajo.utn.trabajo_practico.R;

/**
 * Created by julian.moreno on 10/16/2016.
 */

public class CategoriasView extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView tvNombre;
    private TextView tvDescripcion;
    private ImageView ivFoto;
    private int index;

    public CategoriasView(View v) {
        super(v);
        setTvNombre((TextView)v.findViewById(R.id.txtNombre));
        setTvDescripcion((TextView)v.findViewById(R.id.txtDescripcion));
        setIvFoto((ImageView)v.findViewById(R.id.imgFoto));
        v.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.d("Se hizo click","Index: "+ getIndex());
    }

    public TextView getTvNombre() {
        return tvNombre;
    }

    public void setTvNombre(TextView tvNombre) {
        this.tvNombre = tvNombre;
    }

    public TextView getTvDescripcion() {
        return tvDescripcion;
    }

    public void setTvDescripcion(TextView tvDescripcion) {
        this.tvDescripcion = tvDescripcion;
    }

    public ImageView getIvFoto() {
        return ivFoto;
    }

    public void setIvFoto(ImageView ivFoto) {
        this.ivFoto = ivFoto;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
