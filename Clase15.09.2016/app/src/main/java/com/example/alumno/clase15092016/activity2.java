package com.example.alumno.clase15092016;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Mi Toolbar Activity2");
        actionBar.setDisplayHomeAsUpEnabled(true); // Boton "back".

        Intent i = getIntent();
        Bundle extra = i.getExtras();

        String saludo = extra.getString("saludo");
        int numero = extra.getInt("numero");

        TextView tv = (TextView)findViewById(R.id.actv2TvHello);

        tv.setText(saludo + " - " + numero);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (android.R.id.home == item.getItemId()) {
            // finalizo la actividad.
            Log.d("ACTIVIDAD 2", "Se toco el boton BACK");
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
