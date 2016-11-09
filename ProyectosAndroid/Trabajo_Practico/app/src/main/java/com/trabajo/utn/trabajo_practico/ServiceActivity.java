package com.trabajo.utn.trabajo_practico;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.trabajo.utn.trabajo_practico.modelos.clases_pojo.Usuario;
import com.trabajo.utn.trabajo_practico.utils.HttpManager;

import java.io.IOException;

/**
 * Created by julian.moreno on 11/8/2016.
 */

public class ServiceActivity extends AppCompatActivity  {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.call_service);
        TextView txtUser=(TextView)this.findViewById(R.id.txtState);
    }
}
