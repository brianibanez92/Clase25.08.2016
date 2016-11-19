package utn.com.ar.httpexamplejpg;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import utn.com.ar.httpexamplejpg.clases.HttpClientThread;
import utn.com.ar.httpexamplejpg.clases.HttpManager;

public class HttpActivity extends AppCompatActivity {

    public static Bitmap bmp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);

        ImageView img=(ImageView) findViewById(R.id.imgExample);

        HttpManager manager=new HttpManager("http://cs8.pikabu.ru/post_img/2016/11/03/7/1478171959133290035.gif");
        HttpClientThread client=new HttpClientThread(manager);
        Thread thread=client;

        thread.start();
        try {
            thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        img.setImageBitmap(bmp);

    }
}
