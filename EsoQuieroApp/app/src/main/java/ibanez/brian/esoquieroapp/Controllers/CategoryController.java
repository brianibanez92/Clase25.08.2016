package ibanez.brian.esoquieroapp.Controllers;

import android.view.View;

import ibanez.brian.esoquieroapp.CategoryListActivity;
import ibanez.brian.esoquieroapp.Models.CategoryModel;
import ibanez.brian.esoquieroapp.CategoryActivity;
import ibanez.brian.esoquieroapp.R;
import ibanez.brian.esoquieroapp.Views.CategoryView;

/**
 * Created by brian.ibanez on 28/09/2016.
 */
public class CategoryController implements View.OnClickListener {

    private CategoryModel categoryModel;
    private CategoryView categoryView;
    private CategoryActivity categoryActivity;

    public CategoryController(CategoryModel categoryModel, CategoryActivity categoryActivity) {

        this.categoryModel = categoryModel;
        this.categoryActivity = categoryActivity;

    }

    public void setCategoryView(CategoryView categoryView) {

        this.categoryView = categoryView;

    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btNewCategoryCreate) {

            //TODO: realizar las validaciones.
            this.categoryModel.setCategoryName(this.categoryView.getEtNewCategoryName().getText().toString());
            this.categoryModel.setDescription(this.categoryView.getEtNewCategoryDescription().getText().toString());
            this.categoryModel.setFavorite(this.categoryView.getCbNewCategoryFavorite().isChecked());

            // Le paso al activity de Category el model.
            this.categoryActivity.addCategory(this.categoryModel);

            // Cierro el activity de Categoria.
            this.categoryActivity.finish();

        }

    }
}
