package ibanez.brian.esoquieroapp.Core.Http;

import com.google.gson.Gson;

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
public class LoginJSON
{
    public boolean error;
    public String name;
    public String email;
    public String apiKey;
    public Date createdDate;
    public String message;

    private LoginJSON()
    {
    }

}
