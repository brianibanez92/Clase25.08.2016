package ibanez.brian.clase06102016;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Xml;
import android.widget.ImageView;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Handler.Callback {

    public static final int MENSAJE_ACTUALIZAR = 1;
    private MiHilo miHilo;
    private MiHilo miHilo2;
    private TextView textView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.textView = (TextView)this.findViewById(R.id.tvHello);

        // Implemento la interfaz directamente en mi activity
        Handler.Callback callback = this;
        Handler handler = new Handler(this);

        miHilo = new MiHilo(handler, "http://192.168.2.36:8080/personas.xml");
        miHilo.start();

        //miHilo2 = new MiHilo(handler, "https://image.freepik.com/foto-gratis/hrc-tigre-siberiano-2-jpg_21253111.jpg");
        //miHilo2.start();

    }



    @Override
    protected void onStop() {
        super.onStop();

        miHilo.interrupt();


    }

    @Override
    public boolean handleMessage(Message message) {

        byte [] obj = (byte[]) message.obj;
        if (MENSAJE_ACTUALIZAR == message.arg1){

            String xml = new String(obj);
            this.textView.setText(xml);

            XmlPullParser parse = Xml.newPullParser();

            try
            {
                List<Persona> personas;

                parse.setInput(new StringReader(xml));
                int event = parse.getEventType();

                while (event != XmlPullParser.END_DOCUMENT)
                {
                    switch (event)
                    {

                        case XmlPullParser.START_DOCUMENT:
                        {
                        }

                        case XmlPullParser.START_TAG:
                        {
                            String tag = parse.getName();
                            if(tag.equals("personas"))
                            {
                                personas = new ArrayList<Persona>();
                            }

                            if(tag.equals("persona"))
                            {

                            }

                        }

                        case XmlPullParser.END_TAG:
                        {

                        }

                    }
                }

            } catch (XmlPullParserException e)
            {
                e.printStackTrace();
            }

        }
        else
        {
            Bitmap imgBitMap = BitmapFactory.decodeByteArray(obj, 0, obj.length);

            this.imageView.setImageBitmap(imgBitMap);
        }

        return false;
    }
}
