package ibanez.brian.esoquieroapp.Core.Http.ModelsJSON;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by brian.ibanez on 28/11/2016.
 */
public class PUTCategory
{
    public boolean error;
    public String message;

    private PUTCategory()
    {
    }

    public static PUTCategory getModelFromJSON(String json) throws JSONException
    {
        PUTCategory PUTLogin = new PUTCategory();
        JSONObject jsonObj = new JSONObject(json);

        PUTLogin.error = jsonObj.getBoolean("error");
        PUTLogin.message = jsonObj.getString("message");

        return PUTLogin;
    }

    /*
    { "error": false "message": "Categoria actualizada correctamente" }
    en caso contrario: { "error": true "message": "Fallo la actualización, intente nuevamente."
        */

}
