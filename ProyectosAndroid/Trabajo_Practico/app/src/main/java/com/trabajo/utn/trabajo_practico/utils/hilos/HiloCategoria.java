package com.trabajo.utn.trabajo_practico.utils.hilos;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.widget.ImageView;

import com.trabajo.utn.trabajo_practico.CategoriaActivity;
import com.trabajo.utn.trabajo_practico.CategoriasActivity;
import com.trabajo.utn.trabajo_practico.R;
import com.trabajo.utn.trabajo_practico.modelos.CategoriaModel;
import com.trabajo.utn.trabajo_practico.vistas.CategoriaView;
import com.trabajo.utn.trabajo_practico.vistas.CategoriasView;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by julian.moreno on 10/24/2016.
 */

public class HiloCategoria extends Thread{
    private CategoriaModel c;
    private Bitmap image;
    private CategoriasView holder;
    private int position;

    public HiloCategoria(CategoriaModel c, CategoriasView holder, int position){
        this.c=c;
        this.holder=holder;
        this.position=position;
        cargarImagen();
    }


    @Override
    public void run(){
        //solo ejecuta una acción especifica desde un thread que estés ejecutando sobre una view (un componente, ya sea TextView u otro) del hilo principal
        ((CategoriasActivity)holder.itemView.getContext()).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                holder.getTvNombre().setText(c.getNombre());
                holder.getTvDescripcion().setText(c.getDescripcion());
                if(c.getRutaFoto()!=null) {holder.getIvFoto().setImageBitmap(image);}
            }
        });
    }


    private void cargarImagen(){
        if(c.getRutaFoto()!=null){
            File imgFile = new File(c.getRutaFoto());
            if (imgFile.exists()) {
                image = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            }
        }
    }
}
