package ibanez.brian.esoquieroapp.Models;

import android.net.Uri;

import java.util.Date;

/**
 * Created by brian.ibanez on 28/09/2016.
 */
public class CategoryModel {

    private int id;
    private String categoryName;
    private String description;
    private boolean favorite;
    private Date createdDate;
    private Uri uri;

    public CategoryModel()
    {
    }

    public CategoryModel(int id, String categoryName, String description, boolean favorite, Date createdDate, Uri uri)
    {
        this.id = id;
        this.categoryName = categoryName;
        this.description = description;
        this.favorite = favorite;
        this.createdDate = createdDate;
        this.uri = uri;
    }

    public String getCategoryName()
    {
        return categoryName;
    }

    public void setCategoryName(String categoryName)
    {
        this.categoryName = categoryName;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public boolean getFavorite()
    {
        return this.favorite;
    }

    public void setFavorite(boolean favorite) { this.favorite = favorite; }

    public int getId()
    {
        return this.id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public Date getCreatedDate()
    {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate)
    {
        this.createdDate = createdDate;
    }

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }

}
