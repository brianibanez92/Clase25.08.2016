package ibanez.brian.esoquieroapp.Views;

import android.widget.Button;

import ibanez.brian.esoquieroapp.CategoryListActivity;
import ibanez.brian.esoquieroapp.Controllers.CategoryListController;
import ibanez.brian.esoquieroapp.Models.CategoryListModel;
import ibanez.brian.esoquieroapp.R;

/**
 * Created by brian.ibanez on 28/09/2016.
 */
public class CategoryListView {

    private Button btAddCategory;

    public CategoryListView(CategoryListModel categoryListModel, CategoryListController categoryListController, CategoryListActivity categoryListActivity) {

        this.btAddCategory = (Button) categoryListActivity.findViewById(R.id.btAddCategory);
        this.btAddCategory.setOnClickListener(categoryListController);

    }

}
