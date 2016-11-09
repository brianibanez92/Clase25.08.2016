package com.trabajo.utn.trabajo_practico.utils;

import android.net.Uri;

import java.io.IOException;

/**
 * Created by alumno on 03/11/2016.
 */
public class CallServiceLogin implements Runnable {
    @Override
    public void run() {
        Uri.Builder params = new Uri.Builder();
        params.appendQueryParameter("email", "julian.a.moreno@hotmail.com");
        params.appendQueryParameter("password", "123");

        try {
            HttpManager.getBytesDataByPOST(params, Urls.url_Login);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
