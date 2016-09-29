package ibanez.brian.esoquieroapp.Controllers;

import android.view.View;

import ibanez.brian.esoquieroapp.LoginActivity;
import ibanez.brian.esoquieroapp.Models.LoginModel;
import ibanez.brian.esoquieroapp.R;
import ibanez.brian.esoquieroapp.Views.LoginView;

/**
 * Created by brian.ibanez on 26/09/2016.
 */
public class LoginController implements View.OnClickListener {

    private LoginModel loginModel;
    private LoginView loginView;
    private LoginActivity loginActivity;

    public LoginController(LoginModel loginModel, LoginActivity loginActivity) {

        this.loginModel = loginModel;
        this.loginActivity = loginActivity;

    }

    public void setLoginView(LoginView loginView){

        this.loginView = loginView;
    }

    @Override
    public void onClick(View view) {

        if (R.id.btEnter == view.getId()){

            this.loginActivity.goToCategoryListActivity();

        }


    }

}
