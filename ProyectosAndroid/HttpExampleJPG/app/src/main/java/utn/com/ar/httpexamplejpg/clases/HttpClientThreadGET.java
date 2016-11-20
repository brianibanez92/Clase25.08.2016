package utn.com.ar.httpexamplejpg.clases;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;

import utn.com.ar.httpexamplejpg.HttpActivity;

/**
 * Created by julian.moreno on 11/19/2016.
 */

public class HttpClientThreadGET extends Thread {
    private HttpGET httpGET;

    public HttpClientThreadGET(HttpGET auxHttpGET){
        httpGET=auxHttpGET;
    }

    @Override
    public void run(){
        try {
            byte[] data=httpGET.getBytesDataByGET();
            Bitmap bmp = BitmapFactory.decodeByteArray(data, 0, data.length);
            HttpActivity.bmp=bmp;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

