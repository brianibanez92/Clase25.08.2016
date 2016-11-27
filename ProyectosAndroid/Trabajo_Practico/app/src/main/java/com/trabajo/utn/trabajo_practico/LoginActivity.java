package com.trabajo.utn.trabajo_practico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.trabajo.utn.trabajo_practico.controladores.LoginController;
import com.trabajo.utn.trabajo_practico.modelos.LoginModel;
import com.trabajo.utn.trabajo_practico.modelos.clases.Credencial;
import com.trabajo.utn.trabajo_practico.vistas.LoginView;

public class LoginActivity extends AppCompatActivity {
    private Credencial credencial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        LoginModel model=new LoginModel();
        LoginController controller=new LoginController(model,this);
        LoginView view=new LoginView(model,this,controller);
        controller.setView(view);
    }

    public Credencial getCredencial() {
        return credencial;
    }

    public void setCredencial(Credencial credencial) {
        this.credencial = credencial;
    }
}
