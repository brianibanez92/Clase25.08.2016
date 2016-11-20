package utn.com.ar.httpexamplejpg.clases;

import java.io.IOException;

import utn.com.ar.httpexamplejpg.HttpActivity;

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
            HttpActivity.txtPost=new String(bytes,"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
