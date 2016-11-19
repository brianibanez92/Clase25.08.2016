package com.trabajo.utn.trabajo_practico;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

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
        setContentView(R.layout.categoria_agregar);
        CategoriaModel model=new CategoriaModel();
        CategoriaController controller=new CategoriaController(this);
        CategoriaView view=new CategoriaView(model,this,controller);
        controller.setView(view);

        Intent i=getIntent();
        Bundle extras=i.getExtras();
        String name = extras.getString("txtName");
        String desc = extras.getString("txtDescripcion");
        int idFoto=extras.getInt("idFoto");

        view.getTxtNombre().setText(name);
        view.getTxtDescripcion().setText(desc);
        view.getFoto().setImageResource(idFoto);
    }

    /*@Override
    protected void onActivityResult(int requestCode,int resultCode) {
        Log.d("","");
        //if(requestCode==Controller.CAMARA){
            //if(resultCode==)

        //}

    }*/
}