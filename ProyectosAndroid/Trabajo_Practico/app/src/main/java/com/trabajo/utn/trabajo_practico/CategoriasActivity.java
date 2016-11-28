package com.trabajo.utn.trabajo_practico;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import com.trabajo.utn.trabajo_practico.utils.Utils;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by julian.moreno on 9/25/2016.
 */
//Activity encargada de mostrar las categorias
public class CategoriasActivity extends AppCompatActivity {
    private static RecyclerView rv;
    private static CategoriasModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categorias_main);

        Bundle extras = getIntent().getExtras();
        final String apiKey = extras.getString("apiKey");

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
        if(android.R.id.home == id) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }


    public static void addCategoria(CategoriaModel cat){
        model.addCategoria(cat);
        model.notifyItemInserted(model.getCategorias().size()-1);
    }
}
