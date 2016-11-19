package ibanez.brian.esoquieroapp.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;

import ibanez.brian.esoquieroapp.Controllers.LoginController;
import ibanez.brian.esoquieroapp.Core.Dialog;
import ibanez.brian.esoquieroapp.Core.Http.ModelsJSON.LoginModelJSON;
import ibanez.brian.esoquieroapp.Models.LoginModel;
import ibanez.brian.esoquieroapp.R;
import ibanez.brian.esoquieroapp.Views.LoginView;

public class LoginActivity extends AppCompatActivity implements Handler.Callback {

    private static SharedPreferences prefs;// = getPreferences(Context.MODE_PRIVATE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Si se recordo el usuario, entonces lanzo el activity de Lista de Categorias.
        prefs = this.getPreferences(Context.MODE_PRIVATE);
        String apiKey = prefs.getString("apiKey", null);
        if (apiKey != null)
        {
            Intent i = new Intent(this, CategoryListActivity.class);
            i.putExtra("apiKey", apiKey);
            this.startActivity(i);
            this.finish();
        }

        ActionBar myActionBar = getSupportActionBar();
        myActionBar.hide();

        LoginModel loginModel = new LoginModel();
        LoginController loginController = new LoginController(loginModel, this);
        LoginView loginView = new LoginView(loginModel, loginController, this);
        loginController.setLoginView(loginView);

    }

    /** Cierra la sesión.
     *  Actualiza el valor en shared preferences.
     */
    public static void logOut()
    {
        SharedPreferences.Editor editor = prefs.edit();
        editor.clear();
        editor.putString("apiKey", null);
        editor.commit();
    }

    @Override
    public boolean handleMessage(Message message)
    {
        LoginModelJSON loginModelJSON = (LoginModelJSON) message.obj;

        // Si hay error.
        if (loginModelJSON.error)
        {
            // Lanzo un dialog para mostrar el error.
            String dialogTitle = this.getString(R.string.DialogTitleError);
            String dialogBtnAccept = this.getString(R.string.DialogBtnAccept);

            Dialog md = new Dialog(dialogTitle, loginModelJSON.message, dialogBtnAccept, null);
            md.show(getSupportFragmentManager(), null);
        }
        else
        {
            // Si se tildo "Recordarme" se guardara en Shared Preferences.
            CheckBox cb = (CheckBox) this.findViewById(R.id.cbRememberMe);
            if (cb.isChecked())
            {
                SharedPreferences prefs = this.getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("apiKey", loginModelJSON.apiKey);
                editor.commit();
            }

            // Boton Ingresar. Lanzo el activity de Lista de Categorias.
            Intent i = new Intent(this, CategoryListActivity.class);
            i.putExtra("apiKey", loginModelJSON.apiKey);
            this.startActivity(i);

            //Finalizo el activity de Login.
            this.finish();
        }

        return false;
    }
}
