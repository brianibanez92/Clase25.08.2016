package ibanez.brian.esoquieroapp.Core.Http.ModelsJSON;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ibanez.brian.esoquieroapp.Models.CategoryListModel;
import ibanez.brian.esoquieroapp.Models.CategoryModel;

/**
 * Created by brian.ibanez on 03/11/2016.
 */
public class LoginModelJSON
{
    public boolean error;
    public String name;
    public String email;
    public String apiKey;
    public Date createdAt;
    public String message;

    private LoginModelJSON()
    {
    }

    public static LoginModelJSON getModelFromJSON(String json) throws JSONException
    {
        LoginModelJSON loginModelJSON = new LoginModelJSON();
        JSONObject jsonObj = new JSONObject(json);

        loginModelJSON.error = jsonObj.getBoolean("error");

        // Si tiene errores.
        if (loginModelJSON.error)
        {
            loginModelJSON.message = jsonObj.getString("message");
        }
        else
        {
            loginModelJSON.name = jsonObj.getString("name");
            loginModelJSON.email = jsonObj.getString("email");
            loginModelJSON.apiKey = jsonObj.getString("apiKey");

            try
            {
                Date createdDate = null;
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
                String dateInString = jsonObj.getString("createdAt");
                createdDate = formatter.parse(dateInString);
                loginModelJSON.createdAt = createdDate;

            } catch (ParseException e)
            {
                //e.printStackTrace();
                throw new JSONException(e.getMessage());
            }
        }

        return loginModelJSON;
    }

}
