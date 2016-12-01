package ibanez.brian.esoquieroapp.Core;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
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

    public ImageView getIvItem() {
        return ivItem;
    }

    public void setIvItem(ImageView ivItem) {
        this.ivItem = ivItem;
    }

    private ImageView ivItem;

    private int index;
    private int categoryId;

    public CategoryListViewHolder(View itemView, CategoryListActivity categoryListActivity)
    {
        super(itemView);
        this.tvCategoryName = (TextView)itemView.findViewById(R.id.tvCategoryName);
        this.tvDescription = (TextView)itemView.findViewById(R.id.tvDescription);
        this.cbFavorite = (CheckBox) itemView.findViewById(R.id.cbFavorite);
        this.ivItem = (ImageView)  itemView.findViewById(R.id.ivItem);

        this.categoryListActivity = categoryListActivity;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        Bundle extras = new Bundle();
        Intent i = new Intent(this.categoryListActivity, CategoryActivity.class);

        extras.putInt("categoryId", this.categoryId);
        extras.putString("categoryName", this.tvCategoryName.getText().toString());
        extras.putString("description", this.tvDescription.getText().toString());
        extras.putBoolean("favorite", this.cbFavorite.isChecked());
        extras.putInt("position", this.index);

        this.ivItem.buildDrawingCache();
        Bitmap image = this.ivItem.getDrawingCache();
        extras.putParcelable("imagebitmap", image);

        i.putExtras(extras);
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
