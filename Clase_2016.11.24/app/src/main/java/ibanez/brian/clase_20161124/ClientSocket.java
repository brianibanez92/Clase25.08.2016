package ibanez.brian.clase_20161124;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * Created by brian.ibanez on 24/11/2016.
 */
public class ClientSocket extends Thread
{
    private Handler handler;
    private BufferedWriter bw;
    private String miMensaje;

    public ClientSocket(Handler handler, String miMensaje)
    {
        this.handler = handler;
        this.miMensaje = miMensaje;
    }

    @Override
    public void run()
    {
        Socket clientSocket = null;
        try
        {
            clientSocket = new Socket("192.168.2.61", 4097);

            OutputStream os = clientSocket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);
            sendMsg(miMensaje);

            InputStream is = clientSocket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            while(true) {

                String msgStr = br.readLine();
                if(msgStr == null)
                    break;

                Log.d("t", "Llego:" + msgStr);

                Message m = new Message();
                m.obj = msgStr;
                this.handler.sendMessage(m);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        try
        {
            clientSocket.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public void sendMsg(String s) {
        try {
            if (bw != null) {

                bw.write(s + "\n");

                bw.flush();

            }

        } catch (IOException e) {

            e.printStackTrace();

        }
    }
}
