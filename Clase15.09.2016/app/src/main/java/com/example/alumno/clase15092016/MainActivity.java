package com.example.alumno.clase15092016;

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



        return super.onOptionsItemSelected(item);
    }
}
