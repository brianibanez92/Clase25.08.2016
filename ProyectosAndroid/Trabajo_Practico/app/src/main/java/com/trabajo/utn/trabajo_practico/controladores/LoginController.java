package com.trabajo.utn.trabajo_practico.controladores;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.trabajo.utn.trabajo_practico.LoginActivity;
import com.trabajo.utn.trabajo_practico.MenuActivity;
import com.trabajo.utn.trabajo_practico.R;
import com.trabajo.utn.trabajo_practico.modelos.LoginModel;
import com.trabajo.utn.trabajo_practico.vistas.LoginView;


/**
 * Created by julian.moreno on 9/22/2016.
 */
public class LoginController implements View.OnClickListener  {


    private LoginView view;
    private LoginModel model;
    LoginActivity loginActivity;

    public LoginController(LoginModel model,LoginActivity activity)
    {
        this.model = model;
        this.loginActivity=activity;
    }

    public void setView(LoginView view)
    {
        this.view = view;
    }

    @Override
    public void onClick(View v) {
        if(R.id.btnLogin==v.getId()){
            loginActivity.getActivityMenu();
        }
    }

}
