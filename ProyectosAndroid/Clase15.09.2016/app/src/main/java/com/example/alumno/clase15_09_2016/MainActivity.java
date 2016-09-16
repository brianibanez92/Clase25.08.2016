package com.example.alumno.clase15_09_2016;


import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Mi toolbar");
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_layout, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        if(R.id.setting==menuItem.getItemId()){
            Log.d("setting",menuItem.toString() + "  ID:"+menuItem.getItemId());
            return  true;
        }else if(R.id.opcion1==menuItem.getItemId()){
            Log.d("Opcion 1",menuItem.toString() + "  ID:"+menuItem.getItemId());
            return  true;
        }else if(R.id.opcion2==menuItem.getItemId()){
            Log.d("Opcion 2",menuItem.toString() + "  ID:"+menuItem.getItemId());
            return  true;
        }else if(android.R.id.home==menuItem.getItemId()){
            Log.d("Home",menuItem.toString() + "  ID:"+menuItem.getItemId());
            //Finalizar Activity
            this.finish();

        }
        return super.onOptionsItemSelected(menuItem);
    }
}
