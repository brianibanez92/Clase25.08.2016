package ibanez.brian.esoquieroapp.Activities;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import ibanez.brian.esoquieroapp.Controllers.CategoryController;
import ibanez.brian.esoquieroapp.Models.CategoryModel;
import ibanez.brian.esoquieroapp.R;
import ibanez.brian.esoquieroapp.Views.CategoryView;

public class CategoryActivity extends AppCompatActivity
{

    private int itemPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        ActionBar myActionBar = getSupportActionBar();
        myActionBar.setTitle(R.string.tvNewCategoryTitle);

        // Botón back.
        myActionBar.setDisplayHomeAsUpEnabled(true);

        CategoryModel categoryModel;

        // Si hay informacion es por que se selecciono un item de la grilla.
        Intent i = getIntent();
        Bundle extra = i.getExtras();
        if (extra != null)
        {
            categoryModel = new CategoryModel();
            categoryModel.setCategoryName(extra.getString("categoryName"));
            categoryModel.setDescription(extra.getString("description"));
            categoryModel.setFavorite(extra.getBoolean("favorite"));
            this.itemPosition = extra.getInt("position");

        } else
        {
            categoryModel = new CategoryModel();
            this.itemPosition = -1;
        }

        CategoryController categoryController = new CategoryController(categoryModel, this);
        CategoryView categoryView = new CategoryView(categoryModel, categoryController, this);
        categoryController.setCategoryView(categoryView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_layout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Item menu BACK o item menu Categorias.
        if (android.R.id.home == item.getItemId() || R.id.menuCategory == item.getItemId())
        {
            this.finish();
        }
        else if (R.id.menuLogOut == item.getItemId())
        {
            LoginActivity.logOut();
            this.finish();
        }
        else
        {
            if (R.id.menuFavorite == item.getItemId())
            {
                //TODO : mostrar solo los favoritos??
            }
        }

        return super.onOptionsItemSelected(item);
    }

    public void addCategory(CategoryModel categoryModel)
    {

        // Le paso a la activity de lista de Categorias el nuevo item y la posicion en casod e ser actualizacion.
        CategoryListActivity.addCategory(categoryModel, this.itemPosition);
    }

}