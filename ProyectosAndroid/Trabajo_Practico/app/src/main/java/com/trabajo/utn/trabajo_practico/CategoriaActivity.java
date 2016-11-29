package com.trabajo.utn.trabajo_practico;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.trabajo.utn.trabajo_practico.controladores.CategoriaController;
import com.trabajo.utn.trabajo_practico.modelos.CategoriaModel;
import com.trabajo.utn.trabajo_practico.modelos.clases.Credencial;
import com.trabajo.utn.trabajo_practico.modelos.clases.Estado;
import com.trabajo.utn.trabajo_practico.vistas.CategoriaView;

import org.json.JSONObject;

/**
 * Created by julian.moreno on 10/16/2016.
 */

//Clase en la cual maneja la gestion(Alta-Modificacion) de las categorias
public class CategoriaActivity extends AppCompatActivity implements Handler.Callback{
    CategoriaController controller;
    CategoriaView view;
    private String apiKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categoria_agregar);

        Bundle extras = getIntent().getExtras();
        apiKey=extras.getString("apiKey");

        ActionBar myActionBar = getSupportActionBar();
        myActionBar.setDisplayHomeAsUpEnabled(true);

        CategoriaModel model=new CategoriaModel();
        controller=new CategoriaController(this);
        view=new CategoriaView(model,this,controller);
        controller.setView(view);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(android.R.id.home == id) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data) {
        if (requestCode == CategoriaController.CAMARA) {
            if (resultCode == Activity.RESULT_OK) {
                controller.setImage();
            }
        }
    }

    @Override
    public boolean handleMessage(Message message) {
        JSONObject json= (JSONObject)message.obj;
        Estado estado=new Estado(json,true);
        this.showEstadoNuevaCategoria(estado);
        return false;
    }

    public String getApiKey() {
        return apiKey;
    }

    private void showEstadoNuevaCategoria(final Estado estado){
        String mensaje=estado.getMensaje();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(mensaje)
                .setCancelable(false)
                .setNeutralButton("Aceptar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                if (estado.getError()){
                                    view.getTxtNombre().setText("");
                                    view.getTxtDescripcion().setText("");
                                }
                                Intent i=new Intent(CategoriaActivity.this, CategoriasActivity.class);
                                i.putExtra("apiKey",apiKey);
                                CategoriaActivity.this.startActivity(i);
                                CategoriaActivity.this.finish();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
