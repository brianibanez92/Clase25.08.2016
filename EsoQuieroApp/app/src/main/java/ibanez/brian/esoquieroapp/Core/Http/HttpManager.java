package ibanez.brian.esoquieroapp.Core.Http;

import android.net.Uri;
import android.os.Handler;
import android.os.Message;

import com.google.gson.Gson;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by brian.ibanez on 29/10/2016.
 */
public class HttpManager extends Thread
{
    private HttpURLConnection httpURLConnection;
    private Handler handler;
    private ApiServices method;
    private Uri.Builder parameters;

    private HttpManager()
    {
    }

    public static HttpManager postLoginHttp(Handler handler, Uri.Builder parameters)
    {
        HttpManager httpManager = new HttpManager();

        try
        {
            URL url = new URL("http://lkdml.myq-see.com/login");

            httpManager.httpURLConnection = (HttpURLConnection) url.openConnection();
            httpManager.httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpManager.httpURLConnection.setRequestMethod("POST");
            httpManager.httpURLConnection.setDoOutput(true);

            httpManager.handler = handler;
            httpManager.method = ApiServices.PostLogin;
            httpManager.parameters= parameters;

            return httpManager;
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }

        return null;
    }

    public static HttpManager getCategories(Handler handler, String apiKey)
    {
        HttpManager httpManager = new HttpManager();

        try
        {
            URL url = new URL("http://lkdml.myq-see.com/categorias?id=1");

            httpManager.httpURLConnection = (HttpURLConnection) url.openConnection();
            httpManager.httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpManager.httpURLConnection.setRequestMethod("GET");
            httpManager.httpURLConnection.setRequestProperty("AUTHORIZATION", apiKey);
            httpManager.httpURLConnection.setDoOutput(true);

            httpManager.handler = handler;
            httpManager.method = ApiServices.PostLogin;

            return httpManager;
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public void run()
    {
        byte[] result = null;
        Message message = new Message();

        try
        {
            switch (this.method)
            {
                case PostLogin:
                    result = this.post();
                    //message.arg1 =
                    message.obj = new Gson().fromJson(new String(result, "UTF-8"), LoginJSON.class);
                    break;

                case GetCategories:
                    result = this.get();
                    //message.arg1 =
                    message.obj = new Gson().fromJson(new String(result, "UTF-8"), CategoryListJSON.class);
                    break;

                default:
                    throw new Exception("");

            }

            // Emito el mensaje
            this.handler.sendMessage(message);

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public byte[] post()
    {
        byte[] result = null;
        try
        {
            String query = this.parameters.build().getEncodedQuery();
            OutputStream os = this.httpURLConnection.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
            writer.write(query);
            writer.flush();
            writer.close();
            os.close();

            int response = this.httpURLConnection.getResponseCode();
            if(response == 200) {

                InputStream is = this.httpURLConnection.getInputStream();
                result = getByteArray(is);

            }
            else
            {
                throw new IOException();
            }

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

        return result;
    }

    private byte[] get () throws IOException
    {
        try
        {
            this.httpURLConnection.connect();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

        byte[] result = null;
        int response = this.httpURLConnection.getResponseCode();

        if(response == 200)
        {
            InputStream is = this.httpURLConnection.getInputStream();
            result = getByteArray(is);
        }
        else
        {
            throw new IOException();
        }

        return result;
    }

    private byte[] getByteArray(InputStream is) throws IOException
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int lenght = 0;

        while ((lenght = is.read(buffer)) != -1)
        {
            baos.write(buffer, 0, lenght);
        }

        is.close();

        return baos.toByteArray();
    }

    public enum ApiServices
    {
        PostLogin,
        GetCategories
    }
}