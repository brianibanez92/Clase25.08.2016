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

        HttpManager manager=new HttpManager("http://jsequeiros.com/sites/default/files/imagen-cachorro-comprimir.jpg");
        HttpClientThread client=new HttpClientThread(manager);
        Thread thread=client;

        thread.start();

        img.setImageBitmap(bmp);

    }
}
