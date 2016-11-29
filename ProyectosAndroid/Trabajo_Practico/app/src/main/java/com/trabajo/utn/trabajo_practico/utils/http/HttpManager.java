package com.trabajo.utn.trabajo_practico.utils.http;

import android.net.Uri;

import com.trabajo.utn.trabajo_practico.utils.enumerados.Metodo;
import com.trabajo.utn.trabajo_practico.utils.enumerados.URLS;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by alumno on 03/11/2016.
 */
public class HttpManager {
    private int responseCode;
    private String authorizacionKey;
    private HttpURLConnection conn;
    private Uri.Builder params;
    private Metodo metodo;
    private URLS url;

    //Constructores
    public HttpManager(Metodo metodo, URLS url) {
        super();
        this.metodo=metodo;
        this.url=url;
        conn=crearHttpUrlConn();

    }
    public HttpManager(Metodo metodo, URLS url,String authorizacionKey) {
        this(metodo,url);
        this.authorizacionKey=authorizacionKey;
    }
    public HttpManager(Metodo metodo,URLS url,Uri.Builder params){
        this(metodo,url);
        this.params=params;
    }
    public HttpManager(Metodo metodo,URLS url,Uri.Builder params,String authorizacionKey){
        this(metodo,url,params);
        this.authorizacionKey=authorizacionKey;
    }

    //Metodos Publicos
    public byte[] getBytesData() throws IOException {
        byte[] response=new byte[1024];
        InputStream is;
        conn.setRequestMethod(this.metodo.toString());

        if(authorizacionKey!=null){
            conn.setRequestProperty("AUTHORIZATION",this.authorizacionKey);
        }

        if(params!=null){
            conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            conn.setDoOutput(true); //significa que la aplicación tiene la intención de escribir datos en la conexión de URL
            String query = params.build().getEncodedQuery(); //parsear los paramentros a lenguaje protocolo HTTP

            OutputStream os = conn.getOutputStream(); //flujo salida
            BufferedWriter writer = new BufferedWriter(new
                    OutputStreamWriter(os,"UTF-8"));
            writer.write(query);
            writer.flush();     //Esta forzando que todos los datos sean transferidos.
            writer.close();
            os.close();
        }
        responseCode=conn.getResponseCode();
        is = conn.getInputStream();
        is.read(response);

        return response;
    }
    //Metodos Privados
    private HttpURLConnection crearHttpUrlConn() {
        HttpURLConnection urlConnection=null;
        try {
            URL urlAux = new URL(getUrl().getURL());
            urlConnection= (HttpURLConnection) urlAux.openConnection();
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return urlConnection;
    }

    //Getter
    public int getResponseCode() {
        return responseCode;
    }

    public URLS getUrl() {
        return url;
    }

    public void setUrl(URLS url) {
        this.url = url;
    }
}