package ibanez.brian.esoquieroapp.Controllers;

import android.view.View;

import ibanez.brian.esoquieroapp.CategoryListActivity;
import ibanez.brian.esoquieroapp.Models.CategoryModel;
import ibanez.brian.esoquieroapp.R;
import ibanez.brian.esoquieroapp.Views.CategoryListView;

/**
 * Created by brian.ibanez on 28/09/2016.
 */
public class CategoryListController implements View.OnClickListener {

    private CategoryModel categoryModel;
    private CategoryListView categoryListView;
    private CategoryListActivity categoryListActivity;

    public CategoryListController(CategoryModel categoryModel, CategoryListActivity categoryListActivity) {

        this.categoryModel = categoryModel;
        this.categoryListActivity = categoryListActivity;
    }

    public void setCategoryListView(CategoryListView categoryListView) {

        this.categoryListView = categoryListView;
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btAddCategory) {
            this.categoryListActivity.goToNewCategoryActivityCreate();
        }

    }

}
