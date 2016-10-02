package com.trabajo.utn.trabajo_practico;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import android.support.v7.widget.LinearLayoutManager;


import com.trabajo.utn.trabajo_practico.controladores.LoginController;
import com.trabajo.utn.trabajo_practico.modelos.LoginModel;
import com.trabajo.utn.trabajo_practico.modelos.clases.Categoria;
import com.trabajo.utn.trabajo_practico.vistas.LoginView;
import com.trabajo.utn.trabajo_practico.vistas.adapters.CategoriaAdapter;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        LoginModel model=new LoginModel();
        LoginController controller=new LoginController(model,this);
        LoginView view=new LoginView(model,this,controller);
        controller.setView(view);
    }

    public void getActivityMenu(){
        Intent i=new Intent(this,MenuActivity.class);
        startActivity(i);
    }

}
