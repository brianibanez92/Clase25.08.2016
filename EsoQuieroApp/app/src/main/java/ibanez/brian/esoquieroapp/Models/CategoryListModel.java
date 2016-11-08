package ibanez.brian.esoquieroapp.Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by brian.ibanez on 27/09/2016.
 */
public class CategoryListModel {

    List<CategoryModel> categories;

    public CategoryListModel()
    {
        this.categories = new ArrayList<CategoryModel>();
    }

    public CategoryListModel(List<CategoryModel> categories)
    {
        this.categories = categories;
    }

    public List<CategoryModel> getCategories()
    {
        return categories;
    }

    public void setCategories(List<CategoryModel> categories)
    {
        this.categories = categories;
    }

    public static CategoryListModel getCategoryListModelFromJSON(String jsonCategories) throws JSONException
    {
        CategoryListModel categoryListModel = new CategoryListModel();
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

            categoryListModel.categories.add(new CategoryModel(id, categoryName, description, false, createdDate));

        }

        return categoryListModel;
    }

}
