package com.trabajo.utn.trabajo_practico;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.trabajo.utn.trabajo_practico.controladores.CategoriasController;
import com.trabajo.utn.trabajo_practico.modelos.CategoriasModel;
import com.trabajo.utn.trabajo_practico.modelos.clases_pojo.Categoria;
import com.trabajo.utn.trabajo_practico.utils.Utils;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by julian.moreno on 9/25/2016.
 */
//Activity encargada de mostrar las categorias
public class CategoriasActivity extends AppCompatActivity {
    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categorias_main);

        rv=(RecyclerView)findViewById(R.id.rvCategorias);
        CategoriasModel model=new CategoriasModel(getLst());
        rv.setAdapter(model);
        RecyclerView.LayoutManager manager=new LinearLayoutManager(this);
        rv.setLayoutManager(manager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.getLayout(rv,CategoriaActivity.class);
            }
        });

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

    private  List<Categoria> getLst() {
        List<Categoria> lst = new ArrayList<Categoria>();
        lst.add(new Categoria("Azul", "El destino mezcla las cartas, y nosotros las jugamos.",R.drawable.avatar));
        lst.add(new Categoria("Julian", "Este mundo no le queda mas futuro.", R.drawable.img_m1));
        lst.add(new Categoria("Jose", "Trabajar muy duro y como un esclavo."));
        return lst;
    }


}