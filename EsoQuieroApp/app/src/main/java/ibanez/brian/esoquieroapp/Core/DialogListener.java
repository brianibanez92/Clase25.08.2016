package ibanez.brian.esoquieroapp.Core;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.util.Log;

/**
 * Created by brian.ibanez on 05/11/2016.
 */
public class DialogListener implements DialogInterface.OnClickListener
{

    @Override
    public void onClick(DialogInterface dialog, int which) {

        if (which == AlertDialog.BUTTON_NEGATIVE)
        {
            Log.d("CLICK EN EL NEGATIVO", "Botton " + which);
        }
        else if (which == AlertDialog.BUTTON_POSITIVE)
        {
            Log.d("CLICK EN EL POSITIVO", "Botton " + which);
        }
        else
        {
            Log.d("CLICK EN EL NEUTRAL", "Botton " + which);
        }

    }

}
