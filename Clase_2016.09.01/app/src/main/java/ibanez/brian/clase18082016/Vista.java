package ibanez.brian.clase18082016;

import android.widget.Button;
import android.widget.TextView;

/**
 * Created by alumno on 25/08/2016.
 */
public class Vista {

    private Button btn1;
    private Button btn2;
    private TextView tv1;
    private Model model;

    public Vista(Model model, MainActivity ma, Controller controller)
    {
        this.model = model;
        this.btn1 = (Button)ma.findViewById(R.id.btn1);
        this.btn2 = (Button)ma.findViewById(R.id.btn2);
        this.tv1 = (TextView)ma.findViewById(R.id.tv1);
        this.tv1.setText(model.getContador().toString());

        this.btn1.setOnClickListener(controller);
        this.btn2.setOnClickListener(controller);
    }

    public void UploadView()
    {
        this.tv1.setText(model.getContador().toString());
    }

}
