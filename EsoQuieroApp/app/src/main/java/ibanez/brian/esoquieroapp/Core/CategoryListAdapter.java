package ibanez.brian.esoquieroapp.Core;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ibanez.brian.esoquieroapp.Activities.CategoryListActivity;
import ibanez.brian.esoquieroapp.Core.Http.HttpManager;
import ibanez.brian.esoquieroapp.Models.CategoryListModel;
import ibanez.brian.esoquieroapp.Models.CategoryModel;
import ibanez.brian.esoquieroapp.R;

/**
 * Created by brian.ibanez on 27/09/2016.
 */
public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListViewHolder> {

    private CategoryListModel categoryListModel;
    private CategoryListViewHolder categoryListViewHolder;
    private CategoryListActivity categoryListActivity;

    public CategoryListAdapter(CategoryListModel categoryListModel, CategoryListActivity categoryListActivity){

        this.categoryListModel = categoryListModel;
        this.categoryListActivity = categoryListActivity;
    }

    public void setCategoryListViewHolder(CategoryListViewHolder categoryListViewHolder){
        this.categoryListViewHolder = categoryListViewHolder;
    }

    @Override
    public CategoryListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent, false);
        CategoryListViewHolder mvh = new CategoryListViewHolder(v, this.categoryListActivity);
        return mvh;
    }

    @Override
    public void onBindViewHolder(CategoryListViewHolder holder, int position) {

        CategoryModel item = this.categoryListModel.getCategories().get(position);
        holder.getTvCategoryName().setText(item.getCategoryName());
        holder.getTvDescription().setText(item.getDescription());
        holder.getCbFavorite().setChecked(item.getFavorite());

        holder.getIvItem().setImageURI(item.getUri());

        // Seteo enabled al  checkboxpara que no se pueda checkear/descheckear.
        holder.getCbFavorite().setEnabled(false);

        holder.setCategoryId(item.getId());
        holder.setIndex(position);
    }

    @Override
    public int getItemCount() {

        return this.categoryListModel.getCategories().size();
    }

    /**
     * Elimina el item de la lista.
     * @param position: posicion del item.
     */
    public void removeItem(int position)
    {
        // Obtengo el id de la categoria.
        int categoryId = this.categoryListModel.getCategories().get(position).getId();

        Handler.Callback callback = this.categoryListActivity;
        Handler handler = new Handler(this.categoryListActivity);

        // Obtengo el apiKey.
        SharedPreferences prefs = this.categoryListActivity.getSharedPreferences("EsoQuiero", Context.MODE_PRIVATE);
        String apiKey = prefs.getString("apiKey", null);

        // Elimino la categoria a traves de la API.
        HttpManager httpManager = HttpManager.deleteCategory(handler, apiKey,  String.valueOf(categoryId));
        httpManager.start();

        // Elimino la categoria del model y del recycler view.
        this.categoryListModel.getCategories().remove(position);
        this.notifyItemRemoved(position);

    }
}
