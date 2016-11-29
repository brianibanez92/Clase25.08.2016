package ibanez.brian.esoquieroapp.Core.Http.ModelsJSON;

import java.util.Date;

/**
 * Created by brian.ibanez on 26/11/2016.
 */
public class ItemCategoryJSON
{
    public int id;
    public String categoryName;
    public String description;
    public String url_foto;
    public Date createdAt;

    public ItemCategoryJSON(int id, String categoryName, String description, Date createdAt, String url_foto)
    {
        this.id = id;
        this.categoryName = categoryName;
        this.description = description;
        this.createdAt = createdAt;
        this.url_foto = url_foto;
    }
}
