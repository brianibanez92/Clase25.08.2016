package ibanez.brian.esoquieroapp.Controllers;

import android.content.Intent;
import android.view.View;

import ibanez.brian.esoquieroapp.CategoryListActivity;
import ibanez.brian.esoquieroapp.Models.CategoryListModel;
import ibanez.brian.esoquieroapp.CategoryActivity;
import ibanez.brian.esoquieroapp.R;
import ibanez.brian.esoquieroapp.Views.CategoryListView;

/**
 * Created by brian.ibanez on 28/09/2016.
 */
public class CategoryListController implements View.OnClickListener {

    private CategoryListModel categoryListModel;
    private CategoryListView categoryListView;
    private CategoryListActivity categoryListActivity;

    public CategoryListController(CategoryListModel categoryListModel, CategoryListActivity categoryListActivity) {

        this.categoryListModel = categoryListModel;
        this.categoryListActivity = categoryListActivity;
    }

    public void setCategoryListView(CategoryListView categoryListView) {

        this.categoryListView = categoryListView;
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btAddCategory) {

            Intent newCategoryActivity = new Intent(this.categoryListActivity, CategoryActivity.class);
            this.categoryListActivity.startActivity(newCategoryActivity);

        }

    }

}
