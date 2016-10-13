package ibanez.brian.clase06102016;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import java.io.IOException;

/**
 * Created by brian.ibanez on 06/10/2016.
 */
public class MiHilo extends Thread {

    private Handler handler;
    private String url;

    public MiHilo(Handler handler, String url){
        this.handler = handler;
        this.url = url;
    }

    @Override
    public void run() {

        Object mensaje = new Object();
        HttpManager hm = new HttpManager();
        try {

            mensaje = hm.obtenerInformacion(this.url);
        }
        catch (IOException ex){
            ex.printStackTrace();
        }

        // Emito el mensaje
        Message message = new Message();
        message.arg1 = 1;
        message.obj = mensaje;
        this.handler.sendMessage(message);

    }
}
