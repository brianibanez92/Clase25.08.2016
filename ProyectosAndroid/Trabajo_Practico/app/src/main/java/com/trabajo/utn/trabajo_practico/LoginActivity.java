package com.trabajo.utn.trabajo_practico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import android.support.v7.widget.LinearLayoutManager;


import com.trabajo.utn.trabajo_practico.modelos.clases.Categoria;
import com.trabajo.utn.trabajo_practico.vistas.adapters.CategoriaAdapter;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }



}
