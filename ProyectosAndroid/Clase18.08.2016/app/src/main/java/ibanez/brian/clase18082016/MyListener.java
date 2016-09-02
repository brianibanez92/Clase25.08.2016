package ibanez.brian.clase18082016;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by alumno on 18/08/2016.
 */
public class MyListener implements View.OnClickListener {

    private TextView tv;

    public MyListener(){

    }

    public void setTextView(TextView tv){

        this.tv = tv;

    }

    @Override
    public void onClick(View v) {

        Log.d("CLICK", "Se hizo click");
        this.tv.setText("APRETASTE EL BOTON!!!!");

    }
}
