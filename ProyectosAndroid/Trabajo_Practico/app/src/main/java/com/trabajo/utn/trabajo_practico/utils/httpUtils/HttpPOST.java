package com.trabajo.utn.trabajo_practico.utils.httpUtils;

import android.net.Uri;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * Created by Los_morenos on 21/11/2016.
 */

public class HttpPOST extends HttpManager {
    private Uri.Builder postParams;

    public HttpPOST(String url) {
        super(url);
    }
    public HttpPOST(String url,Uri.Builder param) {
        this(url);
        postParams=param;
    }

    public byte[] getBytesDataByPOST() throws IOException {
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        String query = getPostParams().build().getEncodedQuery();
        OutputStream os = conn.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new
                OutputStreamWriter(os,"UTF-8"));
        writer.write(query);
        writer.flush();
        writer.close();
        os.close();
        InputStream is = conn.getInputStream();
        return readFully(is);
    }

    public Uri.Builder getPostParams() {
        return postParams;
    }

}
