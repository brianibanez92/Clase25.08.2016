package com.trabajo.utn.trabajo_practico.controladores;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.util.Log;
import android.view.View;

import com.trabajo.utn.trabajo_practico.CategoriasActivity;
import com.trabajo.utn.trabajo_practico.LoginActivity;
import com.trabajo.utn.trabajo_practico.R;
import com.trabajo.utn.trabajo_practico.RegistroActivity;
import com.trabajo.utn.trabajo_practico.modelos.LoginModel;
import com.trabajo.utn.trabajo_practico.modelos.clases.Statics;
import com.trabajo.utn.trabajo_practico.utils.Utils;
import com.trabajo.utn.trabajo_practico.utils.enumerados.Metodo;
import com.trabajo.utn.trabajo_practico.utils.enumerados.URLS;
import com.trabajo.utn.trabajo_practico.utils.hilos.HiloHttp;
import com.trabajo.utn.trabajo_practico.utils.http.HttpManager;
import com.trabajo.utn.trabajo_practico.vistas.LoginView;

import static com.trabajo.utn.trabajo_practico.modelos.clases.Statics.credencial;


/**
 * Created by julian.moreno on 9/22/2016.
 */
public class LoginController implements View.OnClickListener  {
    private LoginView view;
    private LoginModel model;
    private LoginActivity loginActivity;

    public LoginController(){super();}

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
            if(view.getTxtUser().getText().toString().isEmpty()) {
                view.getTxtUser().setError("required");
            }
            if(view.getTxtPassword().getText().toString().isEmpty()) {
                view.getTxtPassword().setError("required");
            }
        }
        if(R.id.btnRegister==v.getId()){
            Utils.getLayout(v,RegistroActivity.class);
        }
        if(R.id.btnLogin==v.getId()) {
            Uri.Builder params=new Uri.Builder();
            params.appendQueryParameter("email",view.getTxtUser().getText().toString());
            params.appendQueryParameter("password", view.getTxtPassword().getText().toString());

            HttpManager manager=new HttpManager(Metodo.POST,URLS.LOGIN.getURL(),params);
            HiloHttp hilo=new HiloHttp(manager);
            hilo.start();
            try {
                hilo.sleep(500);
                PopUp(v,credencial.isError(),"Bienvenido: "+credencial.getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void PopUp(final View v,final boolean error,final String mensaje){
        AlertDialog.Builder builder = new AlertDialog.Builder(this.loginActivity);
        builder.setTitle(mensaje)
                .setCancelable(false)
                .setNeutralButton("Aceptar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                if(!error) {
                                    Utils.getLayout(v, CategoriasActivity.class);
                                }
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
