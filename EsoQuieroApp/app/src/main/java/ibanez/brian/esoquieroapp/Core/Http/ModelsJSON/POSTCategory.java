package ibanez.brian.esoquieroapp.Core.Http.ModelsJSON;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by brian.ibanez on 06/11/2016.
 */
public class POSTCategory
{
    public boolean error;
    public int categoria_id;
    public String message;

    private POSTCategory()
    {
    }

    public static POSTCategory getModelFromJSON(String json) throws JSONException
    {
        POSTCategory model = new POSTCategory();
        JSONObject jsonObj = new JSONObject(json);

        if(jsonObj.getBoolean("error"))
        {
            model.error = true;
            model.message = jsonObj.getString("message");
        }
        else
        {
            model.error = false;
            model.categoria_id = jsonObj.getInt("categoria_id");
        }

        return model;
    }

    /*{"error": false
        "message": "Categoria creada satisfactoriamente"
        "categoria_id": 3
    }
    Si es Negativo:
    {"error": true
        "message": "Required field(s) descripcion is missing or empty"
    }
    */

}
