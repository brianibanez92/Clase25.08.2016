package utn.com.ar.httpexamplejpg;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import utn.com.ar.httpexamplejpg.clases.HttpClientThreadGET;
import utn.com.ar.httpexamplejpg.clases.HttpClientThreadPOST;
import utn.com.ar.httpexamplejpg.clases.HttpGET;
import utn.com.ar.httpexamplejpg.clases.HttpPOST;
import utn.com.ar.httpexamplejpg.clases.Mensaje;
import utn.com.ar.httpexamplejpg.clases.TipoPost;
import utn.com.ar.httpexamplejpg.model.Credencial;

public class HttpActivity extends AppCompatActivity {
    public static Bitmap bmp;
    public static Mensaje mensaje;
    public static Credencial credencial;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);
        ImageView img=(ImageView) findViewById(R.id.imgExample);
        ImageView img2=(ImageView) findViewById(R.id.imgExample2);

        String res=img.getBackground().toString();




       // this.cargarImagen();
        //this.cargarCredencial();
        //this.darAltaUsuario();
        //this.cargarCategoria();
    }
    //87a31bba514e17335a2dc383568d200a
    private void cargarCategoria() {
        TextView txt=(TextView)findViewById(R.id.txtRegistro);
        ImageView img=(ImageView) findViewById(R.id.imgExample);

        Uri.Builder params=new Uri.Builder();
        params.appendQueryParameter("titulo","Cabezales");
        params.appendQueryParameter("descripcion", "Pepe");
        params.appendQueryParameter("url_foto",null);

        HttpPOST post=new HttpPOST("http://lkdml.myq-see.com/categorias",params,"87a31bba514e17335a2dc383568d200a");
        HttpClientThreadPOST alta=new HttpClientThreadPOST(post,TipoPost.categoria);
        try {
            alta.start();
            alta.sleep(2000);
//            txt.setText("Error al dar de alta:"+mensaje.isError());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void darAltaUsuario() {
        TextView txt=(TextView)findViewById(R.id.txtRegistro);
        Uri.Builder params=new Uri.Builder();
        params.appendQueryParameter("nombre","Julians");
        params.appendQueryParameter("apellido", "Morenish");
        params.appendQueryParameter("usuario","J.Moreno");
        params.appendQueryParameter("email", "Moreno@gmail.com");
        params.appendQueryParameter("password", "123");

        HttpPOST post=new HttpPOST("http://lkdml.myq-see.com/register",params);
        HttpClientThreadPOST alta=new HttpClientThreadPOST(post,TipoPost.usuario);
        try {
            alta.start();
            alta.sleep(2000);
            txt.setText("Error al dar de alta:"+mensaje.isError());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private void cargarCredencial(){
        TextView txt=(TextView)findViewById(R.id.txtCredencial);

        Uri.Builder params=new Uri.Builder();
        params.appendQueryParameter("email","Moreno@gmail.com");
        params.appendQueryParameter("password", "123");

        HttpPOST post=new HttpPOST("http://lkdml.myq-see.com/login",params);
        HttpClientThreadPOST get=new HttpClientThreadPOST(post,TipoPost.credencial);

        get.start();
        try {
            get.sleep(2000);
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
            get.sleep(2000);
            img.setImageBitmap(bmp);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
