package com.trabajo.utn.trabajo_practico;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;

import com.trabajo.utn.trabajo_practico.controladores.CategoriaController;
import com.trabajo.utn.trabajo_practico.modelos.CategoriaModel;
import com.trabajo.utn.trabajo_practico.vistas.CategoriaView;

/**
 * Created by julian.moreno on 10/16/2016.
 */

//Clase en la cual maneja la gestion(Alta-Modificacion) de las categorias
public class CategoriaActivity extends AppCompatActivity {
    CategoriaController controller;
    CategoriaView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categoria_agregar);

        CategoriaModel model=new CategoriaModel();
        controller=new CategoriaController(this);
        view=new CategoriaView(model,this,controller);
        controller.setView(view);
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data) {
        if (requestCode == CategoriaController.CAMARA) {
            if (resultCode == Activity.RESULT_OK) {
                controller.setImage();
            }
        }
    }
}
