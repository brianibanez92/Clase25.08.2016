package ibanez.brian.clase06102016;

import android.util.Log;
import android.util.Xml;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
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
public class HttpManager13 {

    public static List<Persona> obtenerInformacion (String urlString) throws IOException{

        URL url = new URL(urlString);

        HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
        httpURLConnection.setRequestMethod("GET");

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

        String xmlPersonas = new String(baos.toByteArray(), "UTF-8");
        List<Persona> personas = new ArrayList<Persona>();
        XmlPullParser parse = Xml.newPullParser();

        try
        {
            parse.setInput(new StringReader(xmlPersonas));
            int event = parse.getEventType();

            while (event != XmlPullParser.END_DOCUMENT)
            {
                switch (event)
                {
                    case XmlPullParser.START_TAG:
                    {
                        String tag = parse.getName();
                        if(tag.equals("persona"))
                        {
                            Persona p = new Persona();
                            p.setName(parse.getAttributeValue(null, "name"));
                            p.setSurname(parse.getAttributeValue(null, "surname"));
                            p.setImg(parse.getAttributeValue(null, "img"));
                            p.setPhoneNumber(parse.nextText());

                            personas.add(p);
                        }
                    }
                }

                event = parse.next();

            }

        } catch (XmlPullParserException e)
        {
            e.printStackTrace();
        }

        //return baos.toByteArray();

        return personas;
    }
    public static List<Persona> obtenerInformacionJson(String persona)throws JSONException{
        List<Persona> pl=new ArrayList<>();
        JSONObject jsonObj=new JSONObject(persona);
        JSONArray personas=jsonObj.getJSONArray("personas");

        for(int i=0;i<personas.length();i++){
            JSONObject c=personas.getJSONObject(i);
            String name=c.getString("name");
            String surname=c.getString("surname");
            String phone=c.getString("phone");
            String img=c.getString("img");

            Persona p=new Persona(name,surname,phone,img);

            pl.add(p);
        }
        return pl;
    }
}