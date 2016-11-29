package ibanez.brian.clase_220916;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MiDialog md = new MiDialog();
        md.show(getSupportFragmentManager(), "text");
    }
}
