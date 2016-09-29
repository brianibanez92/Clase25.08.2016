package ibanez.brian.esoquieroapp.Controllers;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import ibanez.brian.esoquieroapp.CategoryListActivity;
import ibanez.brian.esoquieroapp.Models.CategoryModel;
import ibanez.brian.esoquieroapp.R;
import ibanez.brian.esoquieroapp.Views.CategoryListViewHolder;

/**
 * Created by brian.ibanez on 27/09/2016.
 */
public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListViewHolder> {

    private CategoryModel categoryModel;
    private CategoryListViewHolder categoryListViewHolder;
    private CategoryListActivity categoryListActivity;
    private List<CategoryModel> items;

    public CategoryListAdapter(List<CategoryModel> items, CategoryListActivity categoryListActivity){

        this.items = items;
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

        CategoryModel item = this.items.get(position);
        holder.getTvCategoryName().setText(item.getCategoryName());
        holder.getTvDescription().setText(item.getDescription());
        holder.getCbFavorite().setChecked(item.getFavorite());
        holder.setIndex(position);
    }

    @Override
    public int getItemCount() {

        return this.items.size();
    }

}
