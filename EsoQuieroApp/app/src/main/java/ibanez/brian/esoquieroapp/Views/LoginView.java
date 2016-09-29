package ibanez.brian.esoquieroapp.Views;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.TextView;

import ibanez.brian.esoquieroapp.Controllers.LoginController;
import ibanez.brian.esoquieroapp.LoginActivity;
import ibanez.brian.esoquieroapp.Models.LoginModel;
import ibanez.brian.esoquieroapp.R;

/**
 * Created by brian.ibanez on 26/09/2016.
 */
public class LoginView {

    private EditText etUsername;
    private EditText etPassword;
    private CheckBox cbRememberMe;
    private Button btRegister;
    private Button btEnter;
    private LoginModel loginModel;

    public LoginView(LoginModel loginModel, LoginController loginController, LoginActivity loginActivity){

        this.loginModel = loginModel;
        this.etUsername = (EditText) loginActivity.findViewById(R.id.etUsername);
        this.etPassword = (EditText) loginActivity.findViewById(R.id.etPassword);
        this.cbRememberMe = (CheckBox) loginActivity.findViewById(R.id.cbRememberMe);
        this.btEnter = (Button) loginActivity.findViewById(R.id.btEnter);
        this.btRegister = (Button) loginActivity.findViewById(R.id.btRegister);

        this.btEnter.setOnClickListener(loginController);
        this.btRegister.setOnClickListener(loginController);

    }

}
