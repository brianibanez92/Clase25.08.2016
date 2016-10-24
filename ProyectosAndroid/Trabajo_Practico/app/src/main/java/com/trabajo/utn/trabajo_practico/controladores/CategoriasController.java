package com.trabajo.utn.trabajo_practico.controladores;

import android.content.Intent;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;

import com.trabajo.utn.trabajo_practico.CategoriaActivity;
import com.trabajo.utn.trabajo_practico.CategoriasActivity;
import com.trabajo.utn.trabajo_practico.LoginActivity;
import com.trabajo.utn.trabajo_practico.modelos.CategoriaModel;
import com.trabajo.utn.trabajo_practico.modelos.CategoriasModel;
import com.trabajo.utn.trabajo_practico.modelos.LoginModel;
import com.trabajo.utn.trabajo_practico.vistas.CategoriaView;
import com.trabajo.utn.trabajo_practico.vistas.CategoriasView;
import com.trabajo.utn.trabajo_practico.vistas.LoginView;

/**
 * Created by julian.moreno on 10/16/2016.
 */

public class CategoriasController{
    CategoriasModel model;
    CategoriasView view;

    public CategoriasController(CategoriasModel model,CategoriasView view)
    {
        this.model = model;
        this.view=view;
    }

    public void setView(CategoriasView view)
    {
        this.view = view;
    }
}
