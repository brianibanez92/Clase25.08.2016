package com.trabajo.utn.trabajo_practico.controladores;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import com.trabajo.utn.trabajo_practico.LoginActivity;
import com.trabajo.utn.trabajo_practico.R;
import com.trabajo.utn.trabajo_practico.RegistroActivity;
import com.trabajo.utn.trabajo_practico.modelos.LoginModel;
import com.trabajo.utn.trabajo_practico.utils.Utils;
import com.trabajo.utn.trabajo_practico.utils.enumerados.Metodo;
import com.trabajo.utn.trabajo_practico.utils.enumerados.URLS;
import com.trabajo.utn.trabajo_practico.utils.hilos.HiloHttp;
import com.trabajo.utn.trabajo_practico.utils.http.HttpManager;
import com.trabajo.utn.trabajo_practico.vistas.LoginView;


/**
 * Created by julian.moreno on 9/22/2016.
 */
public class LoginController implements View.OnClickListener  {
    private LoginView view;
    private LoginModel model;
    private LoginActivity loginActivity;

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
        if(R.id.btnRegister==v.getId()){
            Utils.getLayout(v,RegistroActivity.class);
        }
        if(R.id.btnLogin==v.getId()) {
            if(validarCampos(v)){
                Uri.Builder params=new Uri.Builder();
                params.appendQueryParameter("email",view.getTxtUser().getText().toString());
                params.appendQueryParameter("password", view.getTxtPassword().getText().toString());

                HttpManager manager=new HttpManager(Metodo.POST,URLS.LOGIN,params);
                Handler handler=new Handler(this.loginActivity);
                HiloHttp hilo=new HiloHttp(handler,manager);
                hilo.start();
            }
        }
    }
    private boolean validarCampos(View v){
            boolean result=true;
            if(view.getTxtUser().getText().toString().isEmpty()) {
                view.getTxtUser().setError("required");
                result=false;
            }
            if(view.getTxtPassword().getText().toString().isEmpty()) {
                view.getTxtPassword().setError("required");
                result=false;
            }
       return result; 
    }
}
