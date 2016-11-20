package utn.com.ar.httpexamplejpg.clases;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by julian.moreno on 11/19/2016.
 */

public class HttpGET extends HttpManager {

    public HttpGET(String url) {
        super(url);
    }

    public byte[] getBytesDataByGET() throws IOException {
        conn.setRequestMethod("GET");
        conn.connect();
        responseCode = conn.getResponseCode();
        if (responseCode == 200) {
            InputStream is = conn.getInputStream();
            return readFully(is);
        } else
            throw new IOException();
    }
    public String getStrDataByGET() throws IOException {
        byte[] bytes = getBytesDataByGET();
        return new String(bytes, "UTF-8");
    }

}
