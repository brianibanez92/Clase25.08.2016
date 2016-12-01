package ibanez.brian.esoquieroapp.Activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import ibanez.brian.esoquieroapp.Controllers.RegisterController;
import ibanez.brian.esoquieroapp.Core.Dialog;
import ibanez.brian.esoquieroapp.Core.Http.HttpManager;
import ibanez.brian.esoquieroapp.Core.Http.ModelsJSON.ResponseJSON;
import ibanez.brian.esoquieroapp.Models.RegisterModel;
import ibanez.brian.esoquieroapp.R;
import ibanez.brian.esoquieroapp.Views.RegisterView;

public class RegisterActivity extends AppCompatActivity implements Handler.Callback, DialogInterface.OnClickListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ActionBar myActionBar = getSupportActionBar();
        myActionBar.hide();

        RegisterModel registerModel = new RegisterModel();
        RegisterController registerController = new RegisterController(registerModel, this);
        RegisterView registerView = new RegisterView(registerModel, registerController, this);
        registerController.setRegisterView(registerView);

    }

    @Override
    public boolean handleMessage(Message message)
    {
        // Si ocurrio al obtener datos de internet.
        if (message.arg2 == HttpManager.ErrorHttp)
        {
            String errorHttpMessage = this.getString(R.string.ErrorHttpManager);

            // Lanzo un dialog para mostrar el error.
            String dialogTitle = this.getString(R.string.DialogTitleError);
            String dialogBtnAccept = this.getString(R.string.DialogBtnAccept);

            Dialog md = new Dialog(dialogTitle, errorHttpMessage, dialogBtnAccept, null, null);
            md.show(getSupportFragmentManager(), null);

            return false;
        }

        ResponseJSON modelJson = (ResponseJSON) message.obj;

        if (modelJson.error)
        {
            // Lanzo un dialog para mostrar el error.
            String dialogTitle = this.getString(R.string.DialogTitleError);
            String dialogBtnAccept = this.getString(R.string.DialogBtnAccept);

            Dialog md = new Dialog(dialogTitle, modelJson.message, dialogBtnAccept, null, null);
            md.show(getSupportFragmentManager(), null);
        }
        else
        {
            // Lanzo un dialog para mostrar el error.jgomez
            String dialogTitle = this.getString(R.string.DialogTitleSucess);
            String dialogBtnAccept = this.getString(R.string.DialogBtnAccept);

            Dialog md = new Dialog(dialogTitle, modelJson.message, dialogBtnAccept, null, this);
            md.show(getSupportFragmentManager(), null);
        }

        return false;
    }

    private void showDialog(String message)
    {

    }

    @Override
    public void onClick(DialogInterface dialog, int which)
    {
        if (which == AlertDialog.BUTTON_POSITIVE)
        {
            this.finish();
        }
    }

}
