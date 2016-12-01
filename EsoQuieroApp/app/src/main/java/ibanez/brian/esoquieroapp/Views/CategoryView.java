package ibanez.brian.esoquieroapp.Views;

import android.graphics.Bitmap;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import ibanez.brian.esoquieroapp.Controllers.CategoryController;
import ibanez.brian.esoquieroapp.Models.CategoryModel;
import ibanez.brian.esoquieroapp.Activities.CategoryActivity;
import ibanez.brian.esoquieroapp.R;

/**
 * Created by brian.ibanez on 28/09/2016.
 */
public class CategoryView
{

    private CategoryModel categoryModel;
    private CategoryController categoryController;
    private CategoryActivity categoryActivity;

    private EditText etNewCategoryName;
    private EditText etNewCategoryDescription;
    private CheckBox cbNewCategoryFavorite;
    private Button btNewCategoryCreate;

    private ImageView ivCategoryImg;

    public CategoryView(CategoryModel categoryModel, CategoryController categoryController, CategoryActivity categoryActivity) {

        this.categoryModel = categoryModel;
        this.categoryController = categoryController;
        this.categoryActivity = categoryActivity;

        // Seteo las view.
        this.etNewCategoryName = (EditText) categoryActivity.findViewById(R.id.etNewCategoryName);
        this.etNewCategoryDescription = (EditText) categoryActivity.findViewById(R.id.etNewCategoryDescription);
        this.cbNewCategoryFavorite = (CheckBox) categoryActivity.findViewById(R.id.cbNewCategoryFavorite);
        this.btNewCategoryCreate = (Button) categoryActivity.findViewById(R.id.btNewCategoryCreate);

        this.ivCategoryImg = (ImageView) categoryActivity.findViewById(R.id.ivCategoryImg);

        // Seteo los valores de las view.
        this.etNewCategoryName.setText(this.categoryModel.getCategoryName());
        this.etNewCategoryDescription.setText(this.categoryModel.getDescription());
        this.cbNewCategoryFavorite.setChecked(this.categoryModel.getFavorite());

        this.btNewCategoryCreate.setOnClickListener(categoryController);
        this.ivCategoryImg.setOnClickListener(categoryController);

    }

    public EditText getEtNewCategoryName() {
        return etNewCategoryName;
    }

    public void setEtNewCategoryName(EditText etNewCategoryName)
    {
        this.etNewCategoryName = etNewCategoryName;
    }

    public EditText getEtNewCategoryDescription() {
        return etNewCategoryDescription;
    }

    public void setEtNewCategoryDescription(EditText etNewCategoryDescription) {
        this.etNewCategoryDescription = etNewCategoryDescription;
    }

    public CheckBox getCbNewCategoryFavorite() {
        return cbNewCategoryFavorite;
    }

    public void setCbNewCategoryFavorite(CheckBox cbNewCategoryFavorite)
    {
        this.cbNewCategoryFavorite = cbNewCategoryFavorite;
    }

    public void updateModel()
    {
        this.categoryModel.setCategoryName(this.etNewCategoryName.getText().toString());
        this.categoryModel.setDescription(this.etNewCategoryDescription.getText().toString());
        this.categoryModel.setFavorite(this.cbNewCategoryFavorite.isChecked());
    }

    public ImageView getIvCategoryImg()
    {
        return ivCategoryImg;
    }

    public void setBitMap(Bitmap bmp)
    {
        this.ivCategoryImg.setImageBitmap(bmp);
    }

}
