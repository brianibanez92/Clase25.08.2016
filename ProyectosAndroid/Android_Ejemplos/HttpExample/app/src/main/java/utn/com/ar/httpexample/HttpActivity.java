package utn.com.ar.httpexample;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import utn.com.ar.httpexample.clases.HttpClientThread;
import utn.com.ar.httpexample.clases.HttpManager;

public class HttpActivity extends AppCompatActivity {
    public static Bitmap bmp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);

        ImageView img=(ImageView) findViewById(R.id.imgImage);

        HttpManager manager=new HttpManager("http://jsequeiros.com/sites/default/files/imagen-cachorro-comprimir.jpg");
        HttpClientThread client=new HttpClientThread(manager);
        Thread thread=client;

        thread.start();

        img.setImageBitmap(bmp);

    }
}
