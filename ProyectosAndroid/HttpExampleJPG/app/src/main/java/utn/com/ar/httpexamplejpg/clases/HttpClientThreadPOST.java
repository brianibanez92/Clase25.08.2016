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

    public HttpClientThreadPOST(HttpPOST auxHttpPOST){
        httpPOST=auxHttpPOST;
    }

    @Override
    public void run(){
        try {
            byte[] bytes=httpPOST.getBytesDataByPOST();
            JSONObject json=new JSONObject(new String(bytes,"UTF-8"));
            HttpActivity.credencial=new Credencial(json);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
