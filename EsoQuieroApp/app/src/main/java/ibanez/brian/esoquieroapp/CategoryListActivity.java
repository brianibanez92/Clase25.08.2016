package ibanez.brian.esoquieroapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import ibanez.brian.esoquieroapp.Controllers.CategoryListAdapter;
import ibanez.brian.esoquieroapp.Controllers.CategoryListController;
import ibanez.brian.esoquieroapp.Models.CategoryModel;
import ibanez.brian.esoquieroapp.Views.CategoryListView;

public class CategoryListActivity extends AppCompatActivity {

    private List<CategoryModel> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list);

        ActionBar myActionBar = getSupportActionBar();
        myActionBar.setTitle(R.string.CategoryListTitle);

        // Boton back.
        myActionBar.setDisplayHomeAsUpEnabled(true);

        // Obtengo la lista desde sharedPreferences.
        this.items = this.getList();

        // Si extra tiene valor es por que se creo una nueva categoria.
        Intent i = getIntent();
        Bundle extra = i.getExtras();
        if (extra != null) {

            CategoryModel categoryModel = new CategoryModel();
            categoryModel.setCategoryName(extra.getString("categoryName"));
            categoryModel.setDescription(extra.getString("description"));
            categoryModel.setFavorite(extra.getBoolean("favorite"));
            this.items.add(categoryModel);
        }

        RecyclerView rv = (RecyclerView) findViewById(R.id.rvCategoryList);
        CategoryListAdapter categoryListAdapter = new CategoryListAdapter(items, this);
        rv.setAdapter(categoryListAdapter);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        rv.setLayoutManager(manager);

        CategoryModel categoryModel = new CategoryModel("", "", false);
        CategoryListController categoryListController = new CategoryListController(categoryModel, this);
        CategoryListView categoryListView = new CategoryListView(categoryModel, categoryListController, this);
        categoryListController.setCategoryListView(categoryListView);

    }

    public void goToNewCategoryActivityCreate(){

        this.setList("items", this.items);

        Intent newCategoryActivity = new Intent(this, NewCategoryActivity.class);
        this.startActivity(newCategoryActivity);

    }

    public void goToNewCategoryActivityRead(CategoryModel categoryModel) {

        Intent i = new Intent(this, NewCategoryActivity.class);
        i.putExtra("categoryName", categoryModel.getCategoryName());
        i.putExtra("description", categoryModel.getDescription());
        i.putExtra("favorite", categoryModel.getFavorite());

        this.startActivity(i);

    }

    public void setList(String key, List<CategoryModel> list)
    {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        set(key, json);
    }

    public void set(String key, String value)
    {
        SharedPreferences sharedPreferences = this.getSharedPreferences("ITEMS", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Limpio lo almacenado para guardar los nuevos registros.
        editor.clear();
        editor.putString(key, value);
        editor.commit();
    }

    public List<CategoryModel> getList(){

        Gson gson = new Gson();
        List<CategoryModel> items = new ArrayList<CategoryModel>();
        SharedPreferences sharedPreferences = this.getSharedPreferences("ITEMS", Context.MODE_PRIVATE);
        String jsonPreferences = sharedPreferences.getString("items", "");
        Type type = new TypeToken<List<CategoryModel>>() {}.getType();
        items = gson.fromJson(jsonPreferences, type);

        return items;

    }

    /*private List<CategoryModel> getDataFromSharedPreferences(){

        Gson gson = new Gson();
        List<Product> productFromShared = new ArrayList<>();
        SharedPreferences sharedPref = this.sharedPreferences(PREFS_TAG, Context.MODE_PRIVATE);
        String jsonPreferences = sharedPref.getString("items", "");

        Type type = new TypeToken<List<CategoryModel>>() {}.getType();
        productFromShared = gson.fromJson(jsonPreferences, type);

        return preferences;
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_layout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (android.R.id.home == item.getItemId()){
            finish();

        } else if (R.id.menuLogOut == item.getItemId()) {
            //TODO: cerrar sesion

        } else if (R.id.menuCategory == item.getItemId()) {

            // TODO: no navega.
        } else if (R.id.menuFavorite == item.getItemId()) {

            //TODO : mostrar solo los favoritos??
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }


}
