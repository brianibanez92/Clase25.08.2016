package com.trabajo.utn.trabajo_practico.utils.hilos.http;

import com.trabajo.utn.trabajo_practico.utils.httpUtils.HttpPOST;
import com.trabajo.utn.trabajo_practico.utils.httpUtils.TipoPost;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by Los_morenos on 21/11/2016.
 */

public class HttpClientThreadPOST extends Thread {
    private HttpPOST httpPOST;
    private TipoPost tipo;

    public HttpClientThreadPOST(HttpPOST auxHttpPOST,TipoPost tipo){
        httpPOST=auxHttpPOST;
        this.tipo=tipo;
    }

    @Override
    public void run(){
        try {
            byte[] bytes=httpPOST.getBytesDataByPOST();
            JSONObject json=new JSONObject(new String(bytes,"UTF-8"));
            switch (tipo){
                case usuario:
                    //HttpActivity.mensaje=new Mensaje(json);
                    break;
                case credencial:
                    //HttpActivity.credencial=new Credencial(json);
                    break;
                case categoria:

                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

