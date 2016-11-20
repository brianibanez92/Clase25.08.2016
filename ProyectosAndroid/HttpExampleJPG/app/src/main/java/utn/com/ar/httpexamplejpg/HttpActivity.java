package utn.com.ar.httpexamplejpg;

import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import utn.com.ar.httpexamplejpg.clases.HttpClientThreadGET;
import utn.com.ar.httpexamplejpg.clases.HttpClientThreadPOST;
import utn.com.ar.httpexamplejpg.clases.HttpGET;
import utn.com.ar.httpexamplejpg.clases.HttpPOST;
import utn.com.ar.httpexamplejpg.model.Credencial;

public class HttpActivity extends AppCompatActivity {
    public static Bitmap bmp;
    public static Credencial credencial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);
        this.cargarImagen();
        this.cargarCredencial();
    }

    private void cargarCredencial(){
        TextView txt=(TextView)findViewById(R.id.txtExample);

        Uri.Builder params=new Uri.Builder();
        params.appendQueryParameter("email","usuario1@gmail.com");
        params.appendQueryParameter("password", "123");

        HttpPOST post=new HttpPOST("http://lkdml.myq-see.com/login",params);
        HttpClientThreadPOST get=new HttpClientThreadPOST(post);

        get.start();
        try {
            get.sleep(700);
            txt.setText(credencial.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void cargarImagen(){
        ImageView img=(ImageView) findViewById(R.id.imgExample);
        HttpGET imageHttp=new HttpGET("http://jsequeiros.com/sites/default/files/imagen-cachorro-comprimir.jpg");
        HttpClientThreadGET get=new HttpClientThreadGET(imageHttp);

        get.start();
        try {
            get.sleep(700);
            img.setImageBitmap(bmp);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
