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

public class HttpActivity extends AppCompatActivity {
    public static Bitmap bmp;
    public static String txtPost;
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
        HttpClientThreadPOST getTxt=new HttpClientThreadPOST(post);
        Thread threadTXT=getTxt;
        threadTXT.start();
        try {
            threadTXT.sleep(700);
            txt.setText(txtPost);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void cargarImagen(){
        ImageView img=(ImageView) findViewById(R.id.imgExample);
        HttpGET get=new HttpGET("http://jsequeiros.com/sites/default/files/imagen-cachorro-comprimir.jpg");
        HttpClientThreadGET getImage=new HttpClientThreadGET(get);

        Thread threadImg=getImage;
        threadImg.start();
        try {
            threadImg.sleep(700);
            img.setImageBitmap(bmp);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
