package com.trabajo.utn.trabajo_practico;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.trabajo.utn.trabajo_practico.modelos.clases_pojo.Categoria;
import com.trabajo.utn.trabajo_practico.vistas.adapters.CategoriaAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by julian.moreno on 9/25/2016.
 */
public class CategoriasActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categoria_lista);
        this.createActionBar();
        this.createReciledView();
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
        if(android.R.id.background == id){

        }




        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    //Metodos privados
    private void createActionBar(){
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Lista de Categorias");
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
    private void createReciledView(){
        List<Categoria> lst=new ArrayList<Categoria>();
        lst.add(new Categoria("Azul","El destino mezcla las cartas, y nosotros las jugamos."));
        lst.add(new Categoria("Julian","Este mundo no le queda mas futuro.",R.drawable.img_m1));
        lst.add(new Categoria("Jose","Trabajar muy duro y como un esclavo."));
        lst.add(new Categoria("Jazmin","El mejor momento del día es ahora.",R.drawable.img_f1));
        lst.add(new Categoria("Fabio","Mi vida es como una casa abandonada."));

        RecyclerView rv=(RecyclerView)findViewById(R.id.rvCategorias);
        CategoriaAdapter myAdapter=new CategoriaAdapter(lst);
        rv.setAdapter(myAdapter);
        RecyclerView.LayoutManager manager=new LinearLayoutManager(this);
        rv.setLayoutManager(manager);
    }


}
