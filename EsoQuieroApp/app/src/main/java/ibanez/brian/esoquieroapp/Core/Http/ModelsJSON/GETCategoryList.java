package ibanez.brian.esoquieroapp.Core.Http.ModelsJSON;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by brian.ibanez on 06/11/2016.
 */
public class GETCategoryList extends ResponseJSON
{
    public List<ItemCategoryJSON> categorias;

    private GETCategoryList()
    {
        this.categorias = new ArrayList<>();
    }

    public static GETCategoryList getModelFromJSON(String jsonCategories) throws JSONException
    {
        GETCategoryList modelJSON = new GETCategoryList();
        JSONObject jsonObj = new JSONObject(jsonCategories);
        JSONArray personas = jsonObj.getJSONArray("categorias");

        // Valido que tenga al menos un item.
        if (personas.length() > 0)
        {
            for (int i = 0; i < personas.length(); i++)
            {
                JSONObject c = personas.getJSONObject(i);
                int id = c.getInt("id");
                String categoryName = c.getString("titulo");
                String description = c.getString("desc");
                String url_foto = c.getString("url_foto");
                Date createdDate = null;

                try
                {
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
                    String dateInString = c.getString("createdAt");
                    createdDate = formatter.parse(dateInString);

                } catch (Exception e)
                {
                    e.printStackTrace();
                }

                modelJSON.categorias.add(new ItemCategoryJSON(id, categoryName, description, createdDate, url_foto));
            }
        }

        return modelJSON;
    }
}