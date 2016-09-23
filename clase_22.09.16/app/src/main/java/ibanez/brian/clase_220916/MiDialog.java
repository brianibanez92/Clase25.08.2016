package ibanez.brian.clase_220916;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.NonNull;

/**
 * Created by alumno on 22/09/2016.
 */
public class MiDialog extends android.support.v4.app.DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle bundle) {

        MyListener ml = new MyListener();

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Mi Titulo");
        builder.setMessage("mensaje!!!!");

        builder.setNegativeButton("Aceptar", ml);

        return builder.create();
    }
}
