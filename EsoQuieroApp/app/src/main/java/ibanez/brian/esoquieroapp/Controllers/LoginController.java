package ibanez.brian.esoquieroapp.Controllers;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.view.View;

import ibanez.brian.esoquieroapp.Activities.LoginActivity;
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

            // Llamo a la api.
            Handler.Callback callback = this.loginActivity;
            Handler handler = new Handler(this.loginActivity);

            Uri.Builder parameters = new Uri.Builder()
                    .appendQueryParameter("email", this.loginModel.getUsername())
                    .appendQueryParameter("password", this.loginModel.getPassword());

            HttpManager threadHttpManager = HttpManager.postLoginHttp(handler, parameters);
            threadHttpManager.start();

        }
        else if(R.id.btRegister == view.getId())
        {
            // Boton Registrar. Lanzo el activity de Registrar.
            Intent i = new Intent(this.loginActivity, RegisterActivity.class);
            this.loginActivity.startActivity(i);
        }
    }
}
