package ibanez.brian.clase06102016;

import android.os.Handler;
import android.os.Message;
import android.util.Xml;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

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
    public void run()
    {

        String xmlPersonas = "";
        List<Persona> personas = new ArrayList<>();
        HttpManager hm = new HttpManager();
        try {

            xmlPersonas = new String(hm.obtenerInformacion(this.url), "UTF-8");
            personas = Persona.getPersonsFromXML(xmlPersonas);
        }
        catch (IOException ex){
            ex.printStackTrace();
        }



        // Emito el mensaje
        Message message = new Message();
        message.arg1 = 1;
        message.obj = personas;
        this.handler.sendMessage(message);

    }
}
