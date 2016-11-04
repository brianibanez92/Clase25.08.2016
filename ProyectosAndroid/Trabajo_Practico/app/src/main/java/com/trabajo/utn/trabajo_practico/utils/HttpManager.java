package com.trabajo.utn.trabajo_practico.utils;

import android.net.Uri;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
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
    public static int response;
    public static byte[] getBytesDataByPOST(Uri.Builder params,String url) throws IOException
    {
        HttpURLConnection conn;
        conn = crearHttpUrlConn(url);          //Crear conecion con la url recibida por parametros
        conn.setRequestMethod("POST");         //Settear el metodo a utilizar Get-Post-Put
        conn.setDoOutput(true);                //Habilitar el output por defecto es true

        String query = params.build().getEncodedQuery();

        OutputStream os = conn.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));


        writer.write(query);
        writer.flush();
        writer.close();
        os.close();

        response = conn.getResponseCode();
        if(response==200) {
            InputStream is = conn.getInputStream();
            return readFully(is);
        }
        else
            throw new IOException();
    }

    public static byte[] getBytesDataByGET(String url) throws IOException {
        HttpURLConnection conn;
        conn = crearHttpUrlConn(url);
        conn.setRequestMethod("GET");
        conn.connect();
        response = conn.getResponseCode();
        if(response==200) {
            InputStream is = conn.getInputStream();
            return readFully(is);
        }
        else
            throw new IOException();
    }


    private static byte[] readFully(InputStream inputStream) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length = 0;
        while ((length = inputStream.read(buffer)) != -1) {
            baos.write(buffer, 0, length);
        }
        inputStream.close();
        return baos.toByteArray();
    }
    private static HttpURLConnection crearHttpUrlConn(String strUrl) {
        URL url = null;
        try {
            url = new URL(strUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            return urlConnection;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}