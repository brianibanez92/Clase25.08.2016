package com.trabajo.utn.trabajo_practico;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.trabajo.utn.trabajo_practico.controladores.LoginController;
import com.trabajo.utn.trabajo_practico.controladores.RegistroController;
import com.trabajo.utn.trabajo_practico.modelos.LoginModel;
import com.trabajo.utn.trabajo_practico.modelos.RegistroModel;
import com.trabajo.utn.trabajo_practico.modelos.clases.Credencial;
import com.trabajo.utn.trabajo_practico.modelos.clases.Estado;
import com.trabajo.utn.trabajo_practico.vistas.LoginView;
import com.trabajo.utn.trabajo_practico.vistas.RegistroView;

import org.json.JSONObject;

/**
 * Created by julian.moreno on 10/2/2016.
 */
public class RegistroActivity extends AppCompatActivity implements Handler.Callback{
    private RegistroView view;
    private RegistroController controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);

        ActionBar myActionBar = getSupportActionBar();
        myActionBar.setDisplayHomeAsUpEnabled(true);

        RegistroModel model=new RegistroModel();
        controller = new RegistroController (model, this);
        view = new RegistroView (model, this, controller);
        controller.setView(view);
    }

    @Override
    public boolean handleMessage(Message message) {
        JSONObject json= (JSONObject)message.obj;
        Estado estado=new Estado(json);
        showEstadoNuevoUsuario(estado);
        return false;
    }

    private void showEstadoNuevoUsuario(final Estado estado){
        String mensaje=estado.getMensaje();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(mensaje)
                .setCancelable(false)
                .setNeutralButton("Aceptar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                if (!estado.getError()){
                                    Intent i = new Intent(RegistroActivity.this, LoginActivity.class);
                                    RegistroActivity.this.startActivity(i);
                                    RegistroActivity.this.finish();
                                }
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
