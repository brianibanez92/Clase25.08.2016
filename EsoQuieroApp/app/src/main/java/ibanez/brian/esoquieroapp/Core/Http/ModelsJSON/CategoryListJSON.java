package ibanez.brian.esoquieroapp.Core.Http.ModelsJSON;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import ibanez.brian.esoquieroapp.Core.Http.ModelsJSON.CategoryJSON;
import ibanez.brian.esoquieroapp.Models.CategoryModel;

/**
 * Created by brian.ibanez on 06/11/2016.
 */
public class CategoryListJSON
{
    public boolean error;
    public List<CategoryJSON> categorias;

    private CategoryListJSON()
    {
    }

    public static CategoryListJSON getModelFromJSON(String jsonCategories) throws JSONException
    {
        CategoryListJSON categoryListModel = new CategoryListJSON();
        JSONObject jsonObj = new JSONObject(jsonCategories);
        JSONArray personas = jsonObj.getJSONArray("categorias");

        for (int i=0; i<personas.length(); i++)
        {
            JSONObject c = personas.getJSONObject(i);
            int id = c.getInt("id");
            String categoryName = c.getString("titulo");
            String description = c.getString("desc");
            Date createdDate = null;
            //"url_foto": null

            try
            {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
                String dateInString = c.getString("createdAt");
                createdDate = formatter.parse(dateInString);

            } catch (ParseException e)
            {
                e.printStackTrace();
            }

            categoryListModel.categorias.add(new CategoryModel(id, categoryName, description, false, createdDate));

        }

        return categoryListModel;
    }

}
