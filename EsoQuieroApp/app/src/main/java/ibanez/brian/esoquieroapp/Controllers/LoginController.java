package ibanez.brian.esoquieroapp.Controllers;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.view.View;

import ibanez.brian.esoquieroapp.Activities.LoginActivity;
import ibanez.brian.esoquieroapp.Core.Dialog;
import ibanez.brian.esoquieroapp.Core.Http.HttpManager;
import ibanez.brian.esoquieroapp.Models.LoginModel;
import ibanez.brian.esoquieroapp.R;
import ibanez.brian.esoquieroapp.Activities.RegisterActivity;
import ibanez.brian.esoquieroapp.Views.LoginView;

/**
 * Created by brian.ibanez on 26/09/2016.
 */
public class LoginController implements View.OnClickListener
{
    private LoginModel loginModel;
    private LoginView loginView;
    private LoginActivity loginActivity;

    public LoginController(LoginModel loginModel, LoginActivity loginActivity)
    {
        this.loginModel = loginModel;
        this.loginActivity = loginActivity;
    }

    public void setLoginView(LoginView loginView)
    {
        this.loginView = loginView;
    }

    @Override
    public void onClick(View view)
    {
        if (R.id.btEnter == view.getId())
        {
            this.loginView.updateModel();

            String dialogMsg = "";
            if (this.loginModel.getUsername().isEmpty())
            {
                dialogMsg = this.loginActivity.getString(R.string.LoginValidationUsername) + "\n";
            }

            if (this.loginModel.getPassword().isEmpty())
            {
                dialogMsg = dialogMsg + this.loginActivity.getString(R.string.LoginValidationPassword);
            }

            // Si la variable no tiene valor es por que no hay errores.
            if (dialogMsg.isEmpty())
            {
                // Llamo a la api.
                Handler.Callback callback = this.loginActivity;
                Handler handler = new Handler(this.loginActivity);

                Uri.Builder parameters = new Uri.Builder()
                        .appendQueryParameter("email", this.loginModel.getUsername())
                        .appendQueryParameter("password", this.loginModel.getPassword());

                HttpManager threadHttpManager = HttpManager.postLogin(handler, parameters);
                threadHttpManager.start();
            }
            else
            {
                // Lanzo un dialog para mostrar las validaciones.
                String dialogTitle = this.loginActivity.getString(R.string.DialogTitleError);
                String dialogBtnAccept = this.loginActivity.getString(R.string.DialogBtnAccept);

                Dialog md = new Dialog(dialogTitle, dialogMsg, dialogBtnAccept, null, null);
                md.show(this.loginActivity.getSupportFragmentManager(), null);
            }

        }
        else if(R.id.btRegister == view.getId())
        {
            // Boton Registrar. Lanzo el activity de Registrar.
            Intent i = new Intent(this.loginActivity, RegisterActivity.class);
            this.loginActivity.startActivity(i);
        }
    }
}
