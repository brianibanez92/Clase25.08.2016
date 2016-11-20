package utn.com.ar.httpexamplejpg.clases;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import utn.com.ar.httpexamplejpg.HttpActivity;
import utn.com.ar.httpexamplejpg.model.Credencial;

/**
 * Created by julian.moreno on 11/19/2016.
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
                    HttpActivity.mensaje=new Mensaje(json);
                    break;
                case credencial:
                    HttpActivity.credencial=new Credencial(json);
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
