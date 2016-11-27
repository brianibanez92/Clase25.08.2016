package utn.com.ar.httpexamplejpg.clases;

import android.net.Uri;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * Created by julian.moreno on 11/19/2016.
 */

public class HttpPOST extends HttpManager{
    private Uri.Builder postParams;
    private String authorizacionKey;

    public HttpPOST(String url) {
        super(url);
    }
    public HttpPOST(String url,Uri.Builder param) {
        this(url);
        postParams=param;
    }
    public HttpPOST(String url,Uri.Builder param,String authorizacionKey) {
        this(url,param);
        this.authorizacionKey=authorizacionKey;
    }

    public byte[] getBytesDataByPOST() throws IOException {
        byte[] response=new byte[1024];
        InputStream is;
        conn.setRequestMethod("POST");

        if(authorizacionKey!=null){
            conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            conn.setRequestProperty("AUTHORIZATION",this.authorizacionKey);
        }
        conn.setDoOutput(true); //significa que la aplicación tiene la intención de escribir datos en la conexión de URL
        String query = getPostParams().build().getEncodedQuery(); //parsear los paramentros a lenguaje protocolo HTTP

        OutputStream os = conn.getOutputStream(); //flujo salida
        BufferedWriter writer = new BufferedWriter(new
                OutputStreamWriter(os,"UTF-8"));
                writer.write(query);
        writer.flush();     //Esta forzando que todos los datos sean transferidos.
        writer.close();
        os.close();

        is = conn.getInputStream();
        is.read(response);

        return response;
    }

    public Uri.Builder getPostParams() {
        return postParams;
    }

    public void setPostParams(Uri.Builder postParams) {
        this.postParams = postParams;
    }
}
