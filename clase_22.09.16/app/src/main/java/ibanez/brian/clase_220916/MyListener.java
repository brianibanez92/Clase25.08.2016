package ibanez.brian.clase_220916;

import android.content.DialogInterface;
import android.util.Log;

/**
 * Created by alumno on 22/09/2016.
 */
public class MyListener implements DialogInterface.OnClickListener {

    @Override
    public void onClick(DialogInterface dialog, int which) {

        Log.d("MENSAJE", "se hizo click en " + which);

    }

}
