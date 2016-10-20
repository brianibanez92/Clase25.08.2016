package com.trabajo.utn.trabajo_practico.controladores;

import android.util.Log;
import android.view.View;

import com.trabajo.utn.trabajo_practico.CategoriasActivity;
import com.trabajo.utn.trabajo_practico.LoginActivity;
import com.trabajo.utn.trabajo_practico.R;
import com.trabajo.utn.trabajo_practico.RegistroActivity;
import com.trabajo.utn.trabajo_practico.modelos.LoginModel;
import com.trabajo.utn.trabajo_practico.utils.Utils;
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
            if(view.getTxtUser().getText().toString().isEmpty()){

            }else{
                Log.d("CLICK", "Usuario: "+view.getTxtUser().getText());
            }
        }
        if(R.id.btnRegister==v.getId()){
            Utils.getLayout(v,RegistroActivity.class);
        }
        if(R.id.btnLogin==v.getId()) {
            Utils.getLayout(v,CategoriasActivity.class);
        }
    }
}
