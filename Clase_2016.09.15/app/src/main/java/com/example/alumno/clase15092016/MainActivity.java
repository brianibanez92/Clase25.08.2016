package com.example.alumno.clase15092016;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.io.Console;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Mi Toolbar");

        // Boton "back".
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_layout, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (R.id.opcion1 == item.getItemId()){

            Log.d("OPCION 1 ", "NOMBRE " + item.toString() + " -- ID"  + item.getItemId());

        } else if (R.id.opcion2 == item.getItemId()){

            Log.d("OPCION 2 ", "NOMBRE " + item.toString() + " -- ID"  + item.getItemId());

        } else if (R.id.opcion3 == item.getItemId()){

            Log.d("OPCION 3 ", "NOMBRE " + item.toString() + " -- ID"  + item.getItemId());

        }

        if (android.R.id.home == item.getItemId()){
            Log.d("BOTON MENU ", "NOMBRE " + item.toString() + " -- ID"  + item.getItemId());

            // Finalizo el activity.
            this.finish();

        }

        // Si apreto el icono me lleva a otra activity.
        if (R.id.icono == item.getItemId()){

            Intent i = new Intent(this, activity2.class);
            i.putExtra("saludo", "Hola actividad dos!!!");
            i.putExtra("numero", 777);
            startActivity(i);
        }



        return super.onOptionsItemSelected(item);
    }
}
