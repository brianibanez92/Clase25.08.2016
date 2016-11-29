package ibanez.brian.esoquieroapp.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import ibanez.brian.esoquieroapp.Controllers.CategoryController;
import ibanez.brian.esoquieroapp.Core.CategoryListAdapter;
import ibanez.brian.esoquieroapp.Core.Dialog;
import ibanez.brian.esoquieroapp.Core.Http.ModelsJSON.GETCategoryList;
import ibanez.brian.esoquieroapp.Core.Http.ModelsJSON.ItemCategoryJSON;
import ibanez.brian.esoquieroapp.Core.Http.ModelsJSON.POSTCategory;
import ibanez.brian.esoquieroapp.Core.Http.ModelsJSON.PUTCategory;
import ibanez.brian.esoquieroapp.Models.CategoryModel;
import ibanez.brian.esoquieroapp.R;
import ibanez.brian.esoquieroapp.Views.CategoryView;

public class CategoryActivity extends AppCompatActivity implements Handler.Callback
{

    public static final int PUTcategory = 2;
    public static final int POSTcategory = 1;
    private int itemPosition;
    private CategoryModel categoryModel;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        ActionBar myActionBar = getSupportActionBar();
        myActionBar.setTitle(R.string.tvNewCategoryTitle);

        // Botón back.
        myActionBar.setDisplayHomeAsUpEnabled(true);

        categoryModel = new CategoryModel();

        // Si hay información es por que se selecciono un item de la grilla.
        Intent i = getIntent();
        Bundle extra = i.getExtras();
        if (extra != null)
        {
            categoryModel.setId(extra.getInt("categoryId"));
            categoryModel.setCategoryName(extra.getString("categoryName"));
            categoryModel.setDescription(extra.getString("description"));
            categoryModel.setFavorite(extra.getBoolean("favorite"));
            this.itemPosition = extra.getInt("position");

        } else
        {
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
            SharedPreferences prefs = getPreferences(Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.clear();
            editor.putBoolean("rememberme", false);
            editor.commit();

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

    @Override
    public boolean handleMessage(Message message)
    {

        if (message.arg1 == POSTcategory)
        {
            POSTCategory modelJSON = (POSTCategory) message.obj;

            // Si hay error.
            if (modelJSON.error)
            {
                this.showError(modelJSON.message);
            }
            else
            {
                // Seteo el Id que retorno el servidor al model.
                categoryModel.setId(modelJSON.categoria_id);

                // Le paso la nueva categoria a la activity de listado.
                CategoryListActivity.addCategory(this.categoryModel, this.itemPosition);

                this.finish();
            }
        }
        else
        {
            PUTCategory modelJSON = (PUTCategory) message.obj;

            // Si hay error.
            if (modelJSON.error)
            {
                this.showError(modelJSON.message);
            }
            else
            {
                // Le paso la nueva categoria a la activity de listado.
                CategoryListActivity.addCategory(this.categoryModel, this.itemPosition);

                this.finish();
            }
        }

        return false;
    }

    private void showError(String message)
    {
        // Lanzo un dialog para mostrar el error.
        String dialogTitle = this.getString(R.string.DialogTitleError);
        String dialogBtnAccept = this.getString(R.string.DialogBtnAccept);

        Dialog md = new Dialog(dialogTitle, message, dialogBtnAccept, null);
        md.show(getSupportFragmentManager(), null);
    }

}