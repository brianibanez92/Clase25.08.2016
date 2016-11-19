package ibanez.brian.clase06102016;

import android.util.Log;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by brian.ibanez on 06/10/2016.
 */
public class HttpManager {

    public byte[] obtenerInformacion (String urlString) throws IOException{

        URL url = new URL(urlString);

        HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setRequestProperty("AUTHORIZATION", "c607392e8abdddd075a90f48af8434ab");

        try{
            httpURLConnection.connect();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }


        int response = httpURLConnection.getResponseCode();
        Log.d("http", "Reponse code: " + response);

        InputStream is = httpURLConnection.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        if (response == 200){

            byte[] buffer = new byte[1024];
            int lenght = 0;

            while ((lenght = is.read(buffer)) != -1){

                baos.write(buffer, 0, lenght);

            }

            is.close();

        }

        return baos.toByteArray();
    }

}
