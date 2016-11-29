package ibanez.brian.clase18082016;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = (TextView)super.findViewById(R.id.tvNombre);
        Button btn = (Button) super.findViewById(R.id.btnNuevo);

        MyListener ml = new MyListener();
        ml.setTextView(tv);

        btn.setOnClickListener(ml);

    }
}
