package ibanez.brian.esoquieroapp.Core;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import ibanez.brian.esoquieroapp.Activities.CategoryActivity;
import ibanez.brian.esoquieroapp.Activities.CategoryListActivity;
import ibanez.brian.esoquieroapp.R;

/**
 * Created by brian.ibanez on 27/09/2016.
 */
public class CategoryListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
    private CategoryListActivity categoryListActivity;
    private TextView tvCategoryName;
    private TextView tvDescription;
    private CheckBox cbFavorite;
    private int index;
    private int categoryId;

    public CategoryListViewHolder(View itemView, CategoryListActivity categoryListActivity)
    {
        super(itemView);
        this.tvCategoryName = (TextView)itemView.findViewById(R.id.tvCategoryName);
        this.tvDescription = (TextView)itemView.findViewById(R.id.tvDescription);
        this.cbFavorite = (CheckBox) itemView.findViewById(R.id.cbFavorite);
        this.categoryListActivity = categoryListActivity;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        Intent i = new Intent(this.categoryListActivity, CategoryActivity.class);
        i.putExtra("categoryId", this.categoryId);
        i.putExtra("categoryName", this.tvCategoryName.getText().toString());
        i.putExtra("description", this.tvDescription.getText().toString());
        i.putExtra("favorite", this.cbFavorite.isChecked());
        i.putExtra("position", this.index);
        this.categoryListActivity.startActivity(i);
    }

    public TextView getTvCategoryName()
    {
        return tvCategoryName;
    }

    public TextView getTvDescription()
    {
        return tvDescription;
    }

    public CheckBox getCbFavorite()
    {
        return cbFavorite;
    }

    public void setIndex(int index)
    {
        this.index = index;
    }

    public void setCategoryId(int categoryId)
    {
        this.categoryId = categoryId;
    }

}
