package ibanez.brian.esoquieroapp.Core.Http.ModelsJSON;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by brian.ibanez on 01/12/2016.
 */
public class ResponseJSON
{
    public boolean error;
    public String message;

    protected ResponseJSON()
    {
    }

    public static ResponseJSON getModelFromJSON(String json) throws JSONException
    {
        ResponseJSON model = new ResponseJSON();
        JSONObject jsonObj = new JSONObject(json);

        model.error = jsonObj.getBoolean("error");
        model.message = jsonObj.getString("message");

        return model;
    }

}
