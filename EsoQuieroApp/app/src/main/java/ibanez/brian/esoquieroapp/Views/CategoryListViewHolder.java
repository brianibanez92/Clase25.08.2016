package ibanez.brian.esoquieroapp.Views;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import ibanez.brian.esoquieroapp.CategoryListActivity;
import ibanez.brian.esoquieroapp.Models.CategoryModel;
import ibanez.brian.esoquieroapp.R;

/**
 * Created by brian.ibanez on 27/09/2016.
 */
public class CategoryListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private CategoryListActivity categoryListActivity;
    private TextView tvCategoryName;
    private TextView tvDescription;
    private CheckBox cbFavorite;
    private int index;

    public CategoryListViewHolder(View itemView, CategoryListActivity categoryListActivity) {

        super(itemView);
        this.tvCategoryName = (TextView)itemView.findViewById(R.id.tvCategoryName);
        this.tvDescription = (TextView)itemView.findViewById(R.id.tvDescription);
        this.cbFavorite = (CheckBox) itemView.findViewById(R.id.cbFavorite);
        this.categoryListActivity = categoryListActivity;
        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setCategoryName(this.tvCategoryName.getText().toString());
        categoryModel.setDescription(this.tvDescription.getText().toString());
        categoryModel.setFavorite(this.cbFavorite.isChecked());
        this.categoryListActivity.goToNewCategoryActivityRead(categoryModel);

    }

    public TextView getTvCategoryName() {

        return tvCategoryName;
    }

    public void setTvCategoryName(TextView tvCategoryName) {

        this.tvCategoryName = tvCategoryName;
    }

    public TextView getTvDescription() {

        return tvDescription;
    }

    public void setTvDescription(TextView tvDescription) {

        this.tvDescription = tvDescription;
    }

    public CheckBox getCbFavorite() {

        return cbFavorite;
    }

    public void setCbFavorite(CheckBox cbFavorite) {

        this.cbFavorite = cbFavorite;
    }

    public int getIndex() {

        return index;
    }

    public void setIndex(int index) {

        this.index = index;
    }

}
