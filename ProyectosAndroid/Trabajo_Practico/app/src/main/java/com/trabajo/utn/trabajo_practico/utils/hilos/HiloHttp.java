package com.trabajo.utn.trabajo_practico.utils.hilos;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.trabajo.utn.trabajo_practico.utils.http.HttpManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by julian.moreno on 11/27/2016.
 */

public class HiloHttp extends Thread {
    private HttpManager manager;
    private Handler handler;

    public HiloHttp(Handler handler,HttpManager manager){
        this.manager=manager;
        this.handler=handler;
    }

    @Override
    public void run(){
        byte[] bytes= null;
        Message message = new Message();
        try {
            bytes = manager.getBytesData();
            message.obj = new JSONObject(new String(bytes, "UTF-8"));

            handler.sendMessage(message);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

