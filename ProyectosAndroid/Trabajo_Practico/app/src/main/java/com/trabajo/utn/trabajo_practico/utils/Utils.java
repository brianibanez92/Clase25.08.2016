package com.trabajo.utn.trabajo_practico.utils;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.trabajo.utn.trabajo_practico.RegistroActivity;

/**
 * Created by julian.moreno on 10/16/2016.
 */

public class Utils {
    public static void getLayout(View view, Class activity){
        Intent i;
        Context context=view.getContext();
        i=new Intent(context, activity);
        context.startActivity(i);
    }
}
