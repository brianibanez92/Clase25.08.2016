package com.example.alumno.clase_4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Persona> lst=new ArrayList<>();
        lst.add(new Persona("Julian","Moreno"));
        lst.add(new Persona("Brian","Ibañez"));
        lst.add(new Persona("Juan","Perez"));

        RecyclerView rv=(RecyclerView)findViewById(R.id.rvPersona);
        MyAdapter myAdapter=new MyAdapter(lst);
        rv.setAdapter(myAdapter);
        RecyclerView.LayoutManager manager=new LinearLayoutManager(this);
        rv.setLayoutManager(manager);


    }
}
