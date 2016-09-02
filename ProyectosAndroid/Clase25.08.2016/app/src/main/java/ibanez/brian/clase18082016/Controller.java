package ibanez.brian.clase18082016;

import android.util.Log;
import android.view.View;

/**
 * Created by alumno on 18/08/2016.
 */
public class Controller implements View.OnClickListener {

    private Vista view;
    private Model model;

    public Controller(Model model)
    {
        this.model = model;
    }

    public void setView(Vista view)
    {
        this.view = view;
    }

    @Override
    public void onClick(View v)
    {

        if (v.getId() == R.id.btn1)
        {
            this.model.setContador(this.model.getContador() + 1);

        } else if (v.getId() == R.id.btn2)
        {
            this.model.setContador(0);
        }

        this.view.UploadView();

        Log.d("CLICK", "Se hizo click");

    }
}
