package com.trabajo.utn.trabajo_practico.vistas;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.trabajo.utn.trabajo_practico.LoginActivity;
import com.trabajo.utn.trabajo_practico.R;
import com.trabajo.utn.trabajo_practico.controladores.LoginController;
import com.trabajo.utn.trabajo_practico.modelos.LoginModel;


/**
 * Created by julian.moreno on 9/22/2016.
 */
public class LoginView {


    private Button btnLogin;
    private Button btnRegister;
    private EditText txtUser;
    private EditText txtPassword;
    private CheckBox chkRemember;
    private LoginModel model;

    public LoginView(LoginModel model, LoginActivity ma, LoginController controller)
    {
        this.model = model;
        this.btnLogin = (Button)ma.findViewById(R.id.btnLogin);
        this.btnRegister = (Button)ma.findViewById(R.id.btnRegister);
        this.txtUser = (EditText)ma.findViewById(R.id.txtUser);
        this.txtPassword = (EditText)ma.findViewById(R.id.txtPassword);
        this.chkRemember = (CheckBox)ma.findViewById(R.id.chkRemember);


        this.btnLogin.setOnClickListener(controller);
        this.btnRegister.setOnClickListener(controller);
    }

}
