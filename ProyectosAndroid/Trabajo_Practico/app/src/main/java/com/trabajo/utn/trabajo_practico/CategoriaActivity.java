package com.trabajo.utn.trabajo_practico;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.trabajo.utn.trabajo_practico.controladores.CategoriaController;
import com.trabajo.utn.trabajo_practico.modelos.CategoriaModel;
import com.trabajo.utn.trabajo_practico.vistas.CategoriaView;

/**
 * Created by julian.moreno on 10/16/2016.
 */

//Clase en la cual maneja la gestion(Alta-Modificacion) de las categorias
public class CategoriaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        CategoriaModel model=new CategoriaModel();
        CategoriaController controller=new CategoriaController();
        CategoriaView view=new CategoriaView();
       // controller.setView(view);
    }
}
