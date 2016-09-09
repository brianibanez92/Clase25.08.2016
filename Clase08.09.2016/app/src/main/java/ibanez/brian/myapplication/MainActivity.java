package ibanez.brian.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Persona> personas = new ArrayList<Persona>();
        personas.add(new Persona("Pepe", "Perez"));
        personas.add(new Persona("Jorge", "Grassi"));
        personas.add(new Persona("Mariano", "Lopez"));
        personas.add(new Persona("Maxi", "Pipo"));
        personas.add(new Persona("Jose", "Peron"));
        personas.add(new Persona("Nicolas", "Gregorio"));
        personas.add(new Persona("Jujunsiu", "Moreno"));

        RecyclerView rv = (RecyclerView)findViewById(R.id.rvPersonas);
        MyAdapter ma = new MyAdapter(personas, this);

        rv.setAdapter(ma);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        rv.setLayoutManager(manager);

    }

    public void onClickMyViewHolder()
    {
        Log.d("MAIN ACTIVITY"," Se hizo click");
    }

}
