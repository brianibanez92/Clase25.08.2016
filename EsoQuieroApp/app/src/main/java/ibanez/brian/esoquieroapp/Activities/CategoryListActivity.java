package ibanez.brian.esoquieroapp.Activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Menu;
import android.view.MenuItem;

import ibanez.brian.esoquieroapp.Core.CategoryListAdapter;
import ibanez.brian.esoquieroapp.Controllers.CategoryListController;
import ibanez.brian.esoquieroapp.Core.Dialog;
import ibanez.brian.esoquieroapp.Core.Http.HttpManager;
import ibanez.brian.esoquieroapp.Core.Http.ModelsJSON.ItemCategoryJSON;
import ibanez.brian.esoquieroapp.Core.Http.ModelsJSON.GETCategoryList;
import ibanez.brian.esoquieroapp.Core.SwipeHelper;
import ibanez.brian.esoquieroapp.Models.CategoryListModel;
import ibanez.brian.esoquieroapp.Models.CategoryModel;
import ibanez.brian.esoquieroapp.R;
import ibanez.brian.esoquieroapp.Views.CategoryListView;

public class CategoryListActivity extends AppCompatActivity implements Handler.Callback
{
    private static CategoryListModel categoryListModel;
    private static CategoryListAdapter categoryListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list);

        // Agrego el boton back.
        ActionBar myActionBar = getSupportActionBar();
        myActionBar.setTitle(R.string.CategoryListTitle);
        myActionBar.setDisplayHomeAsUpEnabled(true);

        // Implemento la interfaz directamente en mi activity
        Handler.Callback callback = this;
        Handler handler = new Handler(this);

        // Obtengo el apiKey.
        SharedPreferences prefs = getSharedPreferences("EsoQuiero", Context.MODE_PRIVATE);
        String apiKey = prefs.getString("apiKey", null);

        HttpManager httpManager = HttpManager.getCategories(handler, apiKey);
        httpManager.start();

        categoryListModel = new CategoryListModel();
        CategoryListController categoryListController = new CategoryListController(categoryListModel, this);
        CategoryListView categoryListView = new CategoryListView(categoryListModel, categoryListController, this);
        categoryListController.setCategoryListView(categoryListView);

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
            SharedPreferences prefs = getSharedPreferences("EsoQuiero", Context.MODE_PRIVATE);
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

    // Agrega un item a la lista.
    public static void addCategory(CategoryModel categoryModel, int position)
    {
        if(position != -1)
        {
            // Modificacion
            CategoryModel category = categoryListModel.getCategories().get(position);
            category.setCategoryName(categoryModel.getCategoryName());
            category.setDescription(categoryModel.getDescription());
            category.setFavorite(categoryModel.getFavorite());

            categoryListAdapter.notifyItemChanged(position);
        }
        else
        {
            // Nuevo
            categoryListModel.getCategories().add(categoryModel);

            // Notifica al Adapter que se agrego un item.
            categoryListAdapter.notifyItemInserted(categoryListModel.getCategories().size() - 1);
        }
    }

    @Override
    public boolean handleMessage(Message message)
    {
        GETCategoryList modelJSON = (GETCategoryList) message.obj;

        // Si hay error.
        if (modelJSON.error)
        {
            // Lanzo un dialog para mostrar el error.
            String dialogTitle = this.getString(R.string.DialogTitleError);
            String dialogBtnAccept = this.getString(R.string.DialogBtnAccept);

            Dialog md = new Dialog(dialogTitle, modelJSON.message, dialogBtnAccept, null);
            md.show(getSupportFragmentManager(), null);
        }
        else
        {
            // Agrego los items al model.
            for (ItemCategoryJSON item : modelJSON.categorias)
            {
                categoryListModel.getCategories().add(new CategoryModel(item.id, item.categoryName, item.description, false, item.createdAt));
            }

            // Creo el RecyclerView.
            RecyclerView rv = (RecyclerView) findViewById(R.id.rvCategoryList);
            categoryListAdapter = new CategoryListAdapter(categoryListModel, this);
            rv.setAdapter(categoryListAdapter);
            RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
            rv.setLayoutManager(manager);

            ItemTouchHelper.Callback callback = new SwipeHelper(categoryListAdapter);
            ItemTouchHelper helper = new ItemTouchHelper(callback);
            helper.attachToRecyclerView(rv);
        }

        return false;
    }
}
