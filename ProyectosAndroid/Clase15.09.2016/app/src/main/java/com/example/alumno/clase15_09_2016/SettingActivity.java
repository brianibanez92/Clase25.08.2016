package com.example.alumno.clase15_09_2016;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Mi toolbar");
        actionBar.setDisplayHomeAsUpEnabled(true);
        Intent i=getIntent();
        Bundle extras=i.getExtras();
        String strActivity1 = extras.getString("clave1");
        int intActivity1 = extras.getInt("clave2");
        Log.d("Home","clave1: "+strActivity1 + " clave2:"+intActivity1);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        if(android.R.id.home==menuItem.getItemId()){
            Log.d("Home",menuItem.toString() + "  ID:"+menuItem.getItemId());
            //Finalizar Activity
            this.finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

}
