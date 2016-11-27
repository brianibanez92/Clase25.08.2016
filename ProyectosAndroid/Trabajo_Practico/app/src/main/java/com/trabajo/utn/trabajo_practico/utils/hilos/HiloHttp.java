package com.trabajo.utn.trabajo_practico.utils.hilos;

import com.trabajo.utn.trabajo_practico.modelos.clases.Credencial;
import com.trabajo.utn.trabajo_practico.modelos.clases.Statics;
import com.trabajo.utn.trabajo_practico.utils.http.HttpManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by julian.moreno on 11/27/2016.
 */

public class HiloHttp extends Thread {
    private HttpManager manager;

    public HiloHttp(HttpManager manager){
        this.manager=manager;
    }

    @Override
    public void run(){
        byte[] bytes= null;
        JSONObject json;
        try {
            bytes = manager.getBytesData();
            json=new JSONObject(new String(bytes,"UTF-8"));
            Statics.credencial=new Credencial(json);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

