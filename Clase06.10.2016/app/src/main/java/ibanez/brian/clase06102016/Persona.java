package ibanez.brian.clase06102016;

import android.util.Xml;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by brian.ibanez on 13/10/2016.
 */
public class Persona {

    private String name;
    private String surname;
    private String phoneNumber;
    private String img;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public static List<Persona> getPersonsFromXML(String xmlPersonas) throws IOException
    {
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

        return personas;
    }

    public static List<Persona> getPersonsFromJSON(String jsonPersonas) throws JSONException {


        List<Persona> pl = new ArrayList<>();
        JSONObject jsonObj = new JSONObject(jsonPersonas);
        JSONArray personas = jsonObj.getJSONArray("personas");

        for (int i=0; i<personas.length(); i++)
        {
            JSONObject c = personas.getJSONObject(i);
            String name = c.getString("name");
            String surname = c.getString("surname");
            String phone = c.getString("phone");
            String img = c.getString("img");

            Persona p = new Persona();
            p.name = name;
            p.surname = surname;
            p.phoneNumber = phone;
            p.img = img;
            pl.add(p);
        }

        return pl;
    }

}
