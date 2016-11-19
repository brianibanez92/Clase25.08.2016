package utn.com.ar.httpexample.clases;

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
    private String url;
    private HttpURLConnection conn;
    private int responseCode;

    public HttpManager(String url)
    {
        setConn(crearHttpUrlConn(url));
    }

    private HttpURLConnection crearHttpUrlConn(String strUrl)
    {
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

    public boolean isReady(){
        return getConn() !=null;
    }

    public byte[] getBytesDataByGET() throws IOException {
        getConn().setRequestMethod("GET");
        getConn().connect();
        responseCode = getConn().getResponseCode();
        if(responseCode==200) {
            InputStream is = getConn().getInputStream();
            return readFully(is);
        }
        else
            throw new IOException();
    }

    private byte[] readFully(InputStream inputStream) throws
            IOException
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length = 0;
        while ((length = inputStream.read(buffer)) != -1) {
            baos.write(buffer, 0, length);
        }
        inputStream.close();
        return baos.toByteArray();
    }

    public String getStrDataByGET() throws IOException {
        byte[] bytes = getBytesDataByGET();
        return new String(bytes,"UTF-8");
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public HttpURLConnection getConn() {
        return conn;
    }

    public void setConn(HttpURLConnection conn) {
        this.conn = conn;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }
}
