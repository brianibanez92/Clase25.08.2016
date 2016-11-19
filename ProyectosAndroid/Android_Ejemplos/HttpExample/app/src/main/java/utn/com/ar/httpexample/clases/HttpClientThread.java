package utn.com.ar.httpexample.clases;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;

import utn.com.ar.httpexample.HttpActivity;

/**
 * Created by julian.moreno on 11/19/2016.
 */
public class HttpClientThread extends Thread {
    private HttpManager httpManager;

    public HttpClientThread(HttpManager manager){
        httpManager=manager;
    }

    @Override
    public void run(){
        try {
            byte[] data=httpManager.getBytesDataByGET();
            Bitmap bmp = BitmapFactory.decodeByteArray(data, 0, data.length);
            HttpActivity.bmp=bmp;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
