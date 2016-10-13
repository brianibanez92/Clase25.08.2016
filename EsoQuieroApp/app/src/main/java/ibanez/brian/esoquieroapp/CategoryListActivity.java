package ibanez.brian.esoquieroapp;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import ibanez.brian.esoquieroapp.Controllers.CategoryListController;
import ibanez.brian.esoquieroapp.Models.CategoryListModel;
import ibanez.brian.esoquieroapp.Models.CategoryModel;
import ibanez.brian.esoquieroapp.Views.CategoryListView;

public class CategoryListActivity extends AppCompatActivity {

    private static CategoryListModel categoryListModel = new CategoryListModel();
    CategoryListAdapter categoryListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list);

        ActionBar myActionBar = getSupportActionBar();
        myActionBar.setTitle(R.string.CategoryListTitle);

        // Boton back.
        myActionBar.setDisplayHomeAsUpEnabled(true);

        CategoryListModel categoryListModel = this.categoryListModel;
        CategoryListController categoryListController = new CategoryListController(categoryListModel, this);
        CategoryListView categoryListView = new CategoryListView(categoryListModel, categoryListController, this);
        categoryListController.setCategoryListView(categoryListView);

        RecyclerView rv = (RecyclerView) findViewById(R.id.rvCategoryList);
        this.categoryListAdapter = new CategoryListAdapter(categoryListModel, this);
        rv.setAdapter(categoryListAdapter);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        rv.setLayoutManager(manager);

    }

    @Override
    protected void onResume() {

        super.onResume();

        // Notifica al Adapter que se agrego un item.
        //this.categoryListAdapter.notifyItemInserted(categoryListModel.getCategories().size() - 1);

    }

    // Agrega un item a la lista.
    public static void addCategory(CategoryModel categoryModel, int position) {

        if(position != -1)
        {
            // Modificacion
            CategoryModel category = categoryListModel.getCategories().get(position);
            categoryListModel.getCategories().remove(category);
            categoryListModel.getCategories().add(position, categoryModel);
        }
        else
        {
            // Nuevo
            categoryListModel.getCategories().add(categoryModel);
        }

    }

}
