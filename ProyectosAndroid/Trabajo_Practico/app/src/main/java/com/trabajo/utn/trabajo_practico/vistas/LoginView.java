package com.trabajo.utn.trabajo_practico.vistas;

import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

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

    public LoginView(){}
    public LoginView(LoginModel model, LoginActivity ma, LoginController controller)
    {
        this.setModel(model);
        this.setBtnLogin((Button)ma.findViewById(R.id.btnLogin));
        this.setBtnRegister((Button)ma.findViewById(R.id.btnRegister));
        this.setTxtUser((EditText)ma.findViewById(R.id.txtUser));
        this.setTxtPassword((EditText)ma.findViewById(R.id.txtPassword));
        this.setChkRemember((CheckBox)ma.findViewById(R.id.chkRemember));


        this.getBtnLogin().setOnClickListener(controller);
        this.getBtnRegister().setOnClickListener(controller);
    }

    public Button getBtnLogin() {
        return btnLogin;
    }

    public void setBtnLogin(Button btnLogin) {
        this.btnLogin = btnLogin;
    }

    public Button getBtnRegister() {
        return btnRegister;
    }

    public void setBtnRegister(Button btnRegister) {
        this.btnRegister = btnRegister;
    }

    public EditText getTxtUser() {
        return txtUser;
    }

    public void setTxtUser(EditText txtUser) {
        this.txtUser = txtUser;
    }

    public EditText getTxtPassword() {
        return txtPassword;
    }

    public void setTxtPassword(EditText txtPassword) {
        this.txtPassword = txtPassword;
    }

    public CheckBox getChkRemember() {
        return chkRemember;
    }

    public void setChkRemember(CheckBox chkRemember) {
        this.chkRemember = chkRemember;
    }

    public LoginModel getModel() {
        return model;
    }

    public void setModel(LoginModel model) {
        this.model = model;
    }
}
