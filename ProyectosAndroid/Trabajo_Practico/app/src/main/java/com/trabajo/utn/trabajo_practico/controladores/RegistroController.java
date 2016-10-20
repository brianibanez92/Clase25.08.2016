package com.trabajo.utn.trabajo_practico.controladores;

import android.view.View;

import com.trabajo.utn.trabajo_practico.R;
import com.trabajo.utn.trabajo_practico.RegistroActivity;
import com.trabajo.utn.trabajo_practico.modelos.RegistroModel;
import com.trabajo.utn.trabajo_practico.utils.Utils;
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
            Utils.getLayout(v,RegistroActivity.class);
        }
    }
}
