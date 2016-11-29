package ibanez.brian.esoquieroapp.Views;

import android.support.design.widget.FloatingActionButton;
import android.widget.Button;

import ibanez.brian.esoquieroapp.Activities.CategoryListActivity;
import ibanez.brian.esoquieroapp.Controllers.CategoryListController;
import ibanez.brian.esoquieroapp.Models.CategoryListModel;
import ibanez.brian.esoquieroapp.R;

/**
 * Created by brian.ibanez on 28/09/2016.
 */
public class CategoryListView {

    private FloatingActionButton btAddCategory;

    public CategoryListView(CategoryListModel categoryListModel, CategoryListController categoryListController, CategoryListActivity categoryListActivity)
    {
        this.btAddCategory = (FloatingActionButton) categoryListActivity.findViewById(R.id.btAddCategory);
        this.btAddCategory.setOnClickListener(categoryListController);
    }

}
