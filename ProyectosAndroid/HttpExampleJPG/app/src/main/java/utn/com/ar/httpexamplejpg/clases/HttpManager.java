package utn.com.ar.httpexamplejpg.clases;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by julian.moreno on 11/19/2016.
 */
public class HttpManager {
        protected String url;
        protected HttpURLConnection conn;
        protected int responseCode;

        public HttpManager(String url) {
            conn=crearHttpUrlConn(url);
        }

        public boolean isReady() {
        return conn != null;
    }
        private HttpURLConnection crearHttpUrlConn(String strUrl) {
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
        protected byte[] readFully(InputStream inputStream) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length = 0;
        while ((length = inputStream.read(buffer)) != -1) {
            baos.write(buffer, 0, length);
        }
        inputStream.close();
        return baos.toByteArray();
    }
}
