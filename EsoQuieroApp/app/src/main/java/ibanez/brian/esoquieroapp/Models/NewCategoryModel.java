package ibanez.brian.esoquieroapp.Models;

/**
 * Created by brian.ibanez on 28/09/2016.
 */
public class NewCategoryModel {

    private String categoryName;
    private String description;
    private boolean favorite;

    public NewCategoryModel(){

    }

    public NewCategoryModel(String categoryName, String description, boolean favorite){

        this.categoryName = categoryName;
        this.description = description;
        this.favorite = favorite;

    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getFavorite() {
        return this.favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

}
