package com.trabajo.utn.trabajo_practico;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;


import com.trabajo.utn.trabajo_practico.controladores.LoginController;
import com.trabajo.utn.trabajo_practico.modelos.LoginModel;
import com.trabajo.utn.trabajo_practico.modelos.clases.Credencial;
import com.trabajo.utn.trabajo_practico.vistas.LoginView;

import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity implements Handler.Callback{
    private Credencial credencial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        EditText txt1=(EditText)this.findViewById(R.id.txtUser);
        EditText txt2=(EditText)this.findViewById(R.id.txtPassword);
        txt1.setText("diablo3@gmail.com");
        txt2.setText("123");

        LoginModel model = new LoginModel();
        LoginController controller = new LoginController(model, this);
        LoginView view = new LoginView(model, this, controller);
        controller.setView(view);
    }

    @Override
    public boolean handleMessage(Message message) {
        JSONObject json= (JSONObject)message.obj;
        this.credencial=new Credencial(json);
        showEstadoLogin(this,this.credencial);
        return false;
    }

    private void showEstadoLogin(final LoginActivity activity, final Credencial credencial){
        String mensaje=credencial.getEstado().getError()?credencial.getEstado().getMensaje():"Bienvenido: "+credencial.getName();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(mensaje)
                .setCancelable(false)
                .setNeutralButton("Aceptar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                if(!credencial.getEstado().getError()) {
                                    Intent i=new Intent(activity, CategoriasActivity.class);
                                    i.putExtra("apiKey",credencial.getApiKey());
                                    activity.startActivity(i);
                                }
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
