package com.trabajo.utn.trabajo_practico;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.trabajo.utn.trabajo_practico.modelos.CategoriaModel;
import com.trabajo.utn.trabajo_practico.modelos.CategoriasModel;
import com.trabajo.utn.trabajo_practico.modelos.clases.Credencial;
import com.trabajo.utn.trabajo_practico.modelos.clases.Estado;
import com.trabajo.utn.trabajo_practico.utils.Utils;
import com.trabajo.utn.trabajo_practico.utils.enumerados.Metodo;
import com.trabajo.utn.trabajo_practico.utils.enumerados.URLS;
import com.trabajo.utn.trabajo_practico.utils.hilos.HiloHttp;
import com.trabajo.utn.trabajo_practico.utils.http.HttpManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by julian.moreno on 9/25/2016.
 */
//Activity encargada de mostrar las categorias
public class CategoriasActivity extends AppCompatActivity implements Handler.Callback{
    private static RecyclerView rv;
    private static CategoriasModel model;
    private String apiKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categorias_main);

        Bundle extras = getIntent().getExtras();
        apiKey = extras.getString("apiKey");

        if(apiKey==null){
            Log.d("USUARIO","USUARIO NO LOGEADO");
            Intent i=new Intent(this, LoginActivity.class);
            this.startActivity(i);
            this.finish();
        }else{
            ActionBar myActionBar = getSupportActionBar();
            myActionBar.setDisplayHomeAsUpEnabled(true);

            rv=(RecyclerView)findViewById(R.id.rvCategorias);
            model=new CategoriasModel();
            rv.setAdapter(model);
            RecyclerView.LayoutManager manager=new LinearLayoutManager(this);
            rv.setLayoutManager(manager);

            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context=view.getContext();
                    Intent i=new Intent(context, CategoriaActivity.class);
                    i.putExtra("apiKey",apiKey);
                    context.startActivity(i);
                }
            });
            obtenerCategorias();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(android.R.id.home == id) {this.finish();}
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean handleMessage(Message message) {
        try {
            JSONObject json=(JSONObject)message.obj;
            Estado estado=new Estado(json);
            if(estado.getError()){
                showError(this,estado);
            }
            JSONArray jsonArray= json.getJSONArray("categorias");

            for (int i=0;i<jsonArray.length();i++){
                JSONObject jsonObj=jsonArray.getJSONObject(i);
                CategoriaModel categoriaModel=new CategoriaModel(jsonObj);
                addCategoria(categoriaModel);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }
    private void obtenerCategorias(){
        HttpManager manager=new HttpManager(Metodo.GET, URLS.CATEGORIAS,apiKey);
        Handler handler=new Handler(this);
        HiloHttp hilo=new HiloHttp(handler,manager);
        hilo.start();
    }
    public static void addCategoria(CategoriaModel cat){
        model.addCategoria(cat);
        model.notifyItemInserted(model.getCategorias().size()-1);
    }
    private void showError(final CategoriasActivity activity, final Estado estado){
        String mensaje=estado.getMensaje();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(mensaje)
                .setCancelable(false)
                .setNeutralButton("Aceptar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                    Intent i=new Intent(activity, LoginActivity.class);
                                    activity.startActivity(i);
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
