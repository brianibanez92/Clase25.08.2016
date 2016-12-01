package com.trabajo.utn.trabajo_practico.vistas;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.trabajo.utn.trabajo_practico.CategoriaActivity;
import com.trabajo.utn.trabajo_practico.CategoriasActivity;
import com.trabajo.utn.trabajo_practico.R;
import com.trabajo.utn.trabajo_practico.controladores.CategoriasController;
import com.trabajo.utn.trabajo_practico.modelos.CategoriasModel;

/**
 * Created by julian.moreno on 10/16/2016.
 */

public class CategoriasView extends RecyclerView.ViewHolder implements View.OnClickListener{

    private TextView tvNombre;
    private TextView tvDescripcion;
    private ImageView ivFoto;
    private int index;
    private String apiKey;


    public CategoriasView(View v,String apiKey) {
        super(v);
        setTvNombre((TextView)v.findViewById(R.id.txtNombre));
        setTvDescripcion((TextView)v.findViewById(R.id.txtDescripcion));
        setIvFoto((ImageView)v.findViewById(R.id.imgFoto));
        this.apiKey=apiKey;
        v.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        Context context=v.getContext();
        Intent i=new Intent(context, CategoriaActivity.class);

        i.putExtra("txtName",this.getTvNombre().getText());
        i.putExtra("txtDescripcion",this.getTvDescripcion().getText());
        i.putExtra("apiKey",this.apiKey);
        i.putExtra("idCategoria",index);
        i.putExtra("operacion","UPDATE");

        context.startActivity(i);
    }
}
