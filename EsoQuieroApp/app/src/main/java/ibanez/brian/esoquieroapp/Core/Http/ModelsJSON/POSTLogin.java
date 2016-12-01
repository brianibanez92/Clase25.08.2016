package ibanez.brian.esoquieroapp.Core.Http.ModelsJSON;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by brian.ibanez on 03/11/2016.
 */
public class POSTLogin extends ResponseJSON
{
    public String name;
    public String email;
    public String apiKey;
    public Date createdAt;

    private POSTLogin()
    {
    }

    public static POSTLogin getModelFromJSON(String json) throws JSONException
    {
        POSTLogin POSTLogin = new POSTLogin();
        JSONObject jsonObj = new JSONObject(json);

        POSTLogin.error = jsonObj.getBoolean("error");

        // Si tiene errores.
        if (POSTLogin.error)
        {
            POSTLogin.message = jsonObj.getString("message");
        }
        else
        {
            POSTLogin.name = jsonObj.getString("name");
            POSTLogin.email = jsonObj.getString("email");
            POSTLogin.apiKey = jsonObj.getString("apiKey");

            try
            {
                Date createdDate = null;
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
                String dateInString = jsonObj.getString("createdAt");
                createdDate = formatter.parse(dateInString);
                POSTLogin.createdAt = createdDate;

            } catch (ParseException e)
            {
                //e.printStackTrace();
                throw new JSONException(e.getMessage());
            }
        }

        return POSTLogin;
    }

}
