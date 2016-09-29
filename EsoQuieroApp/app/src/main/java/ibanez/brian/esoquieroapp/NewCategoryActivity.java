package ibanez.brian.esoquieroapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import ibanez.brian.esoquieroapp.Controllers.NewCategoryController;
import ibanez.brian.esoquieroapp.Models.CategoryModel;
import ibanez.brian.esoquieroapp.Models.NewCategoryModel;
import ibanez.brian.esoquieroapp.Views.NewCategoryView;

public class NewCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_category);

        ActionBar myActionBar = getSupportActionBar();
        myActionBar.setTitle(R.string.tvNewCategoryTitle);

        // Boton back.
        myActionBar.setDisplayHomeAsUpEnabled(true);

        NewCategoryModel newCategoryModel;

        Intent i = getIntent();
        Bundle extra = i.getExtras();
        if (extra != null) {

            newCategoryModel = new NewCategoryModel();
            newCategoryModel.setCategoryName(extra.getString("categoryName"));
            newCategoryModel.setDescription(extra.getString("description"));
            newCategoryModel.setFavorite(extra.getBoolean("favorite"));

        } else{

            newCategoryModel= new NewCategoryModel();

        }

        NewCategoryController newCategoryController = new NewCategoryController(newCategoryModel, this);
        NewCategoryView newCategoryView = new NewCategoryView(newCategoryModel, newCategoryController, this);
        newCategoryController.setNewCategoryView(newCategoryView);

    }

    public void goToCategoryListActivity(NewCategoryModel newCategoryModel) {

        Intent i = new Intent(this, CategoryListActivity.class);
        i.putExtra("categoryName", newCategoryModel.getCategoryName());
        i.putExtra("description", newCategoryModel.getDescription());
        i.putExtra("favorite", newCategoryModel.getFavorite());
        startActivity(i);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_layout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Item menu BACK o item menu Categorias.
        if (android.R.id.home == item.getItemId() || R.id.menuCategory == item.getItemId()){

            Intent i = new Intent(this, CategoryListActivity.class);
            this.startActivity(i);

        } else if (R.id.menuLogOut == item.getItemId()) {
            //TODO: cerrar sesion

        } else if (R.id.menuFavorite == item.getItemId()) {

            //TODO : mostrar solo los favoritos??
        }

        return super.onOptionsItemSelected(item);
    }

}
