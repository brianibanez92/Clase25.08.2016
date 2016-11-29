package ibanez.brian.clase18082016;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Model m = new Model();
        Controller c = new Controller(m);
        Vista v = new Vista(m, this, c);

        c.setView(v);





    }
}
