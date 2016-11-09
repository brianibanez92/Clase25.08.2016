package com.trabajo.utn.trabajo_practico;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.trabajo.utn.trabajo_practico.controladores.LoginController;
import com.trabajo.utn.trabajo_practico.modelos.LoginModel;
import com.trabajo.utn.trabajo_practico.utils.Utils;
import com.trabajo.utn.trabajo_practico.vistas.LoginView;

public class LoginActivity extends AppCompatActivity  implements Handler.Callback{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        LoginModel model=new LoginModel();
        LoginController controller=new LoginController(model,this);
        LoginView view=new LoginView(model,this,controller);
        controller.setView(view);
    }

    @Override
    public boolean handleMessage(Message message) {
        Intent i = new Intent(this, CategoriasActivity.class);
        this.startActivity(i);
        return false;
    }
}
