package com.trabajo.utn.trabajo_practico.controladores;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import com.trabajo.utn.trabajo_practico.CategoriaActivity;
import com.trabajo.utn.trabajo_practico.CategoriasActivity;
import com.trabajo.utn.trabajo_practico.R;
import com.trabajo.utn.trabajo_practico.RegistroActivity;
import com.trabajo.utn.trabajo_practico.modelos.RegistroModel;
import com.trabajo.utn.trabajo_practico.utils.Utils;
import com.trabajo.utn.trabajo_practico.utils.enumerados.Metodo;
import com.trabajo.utn.trabajo_practico.utils.enumerados.URLS;
import com.trabajo.utn.trabajo_practico.utils.hilos.HiloHttp;
import com.trabajo.utn.trabajo_practico.utils.http.HttpManager;
import com.trabajo.utn.trabajo_practico.vistas.RegistroView;

/**
 * Created by julian.moreno on 9/22/2016.
 */
public class RegistroController implements View.OnClickListener{
    private RegistroView view;
    private RegistroModel model;
    RegistroActivity registroActivity;

    public RegistroController(RegistroModel model,RegistroActivity activity)
    {
        this.model = model;
        this.registroActivity=activity;
    }

    public void setView(RegistroView view)
    {
        this.view = view;
    }

    @Override
    public void onClick(View v) {
        if(R.id.btnRegister==v.getId()){
            if(validarCampos(v)){
                Uri.Builder params=new Uri.Builder();
                params.appendQueryParameter("nombre",view.getTxtNombre().getText().toString());
                params.appendQueryParameter("apellido", view.getTxtApellido().getText().toString());
                params.appendQueryParameter("usuario",view.getTxtUsername().getText().toString());
                params.appendQueryParameter("email",view.getTxtEmail().getText().toString());
                params.appendQueryParameter("password",view.getTxtContraseña().getText().toString());

                HttpManager manager=new HttpManager(Metodo.POST,URLS.REGISTRO,params);
                Handler handler=new Handler(this.registroActivity);
                HiloHttp hilo=new HiloHttp(handler,manager);
                hilo.start();
            }
        }
    }
    private boolean validarCampos(View v){
        boolean result=true;
        String contraseña=view.getTxtContraseña().getText().toString();
        String validacionContraseña=view.getTxtContraseñaValidador().getText().toString();

        if(view.getTxtNombre().getText().toString().isEmpty()) {
            view.getTxtNombre().setError("required");
            result=false;
        }
        if(view.getTxtApellido().getText().toString().isEmpty()) {
            view.getTxtApellido().setError("required");
            result=false;
        }
        if(view.getTxtEmail().getText().toString().isEmpty()) {
            view.getTxtEmail().setError("required");
            result=false;
        }
        if(view.getTxtUsername().getText().toString().isEmpty()) {
            view.getTxtUsername().setError("required");
            result=false;
        }
        if(contraseña.isEmpty()) {
            view.getTxtContraseña().setError("required");
            result=false;
        }
        if(validacionContraseña.isEmpty()) {
            view.getTxtContraseñaValidador().setError("required");
            result=false;
        }
        if(result && !contraseña.equals(validacionContraseña)){
            view.getTxtContraseña().setText("");
            view.getTxtContraseñaValidador().setText("");
            view.getTxtContraseña().setError("unequal passwords");
            result=false;
        }
        return result;
    }

}
