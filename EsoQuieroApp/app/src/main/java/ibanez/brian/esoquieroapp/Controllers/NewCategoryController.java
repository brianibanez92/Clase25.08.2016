package ibanez.brian.esoquieroapp.Controllers;

import android.view.View;

import ibanez.brian.esoquieroapp.Models.NewCategoryModel;
import ibanez.brian.esoquieroapp.NewCategoryActivity;
import ibanez.brian.esoquieroapp.R;
import ibanez.brian.esoquieroapp.Views.NewCategoryView;

/**
 * Created by brian.ibanez on 28/09/2016.
 */
public class NewCategoryController implements View.OnClickListener {

    private NewCategoryModel newCategoryModel;
    private NewCategoryView newCategoryView;
    private NewCategoryActivity newCategoryActivity;

    public NewCategoryController(NewCategoryModel newCategoryModel, NewCategoryActivity newCategoryActivity) {

        this.newCategoryModel = newCategoryModel;
        this.newCategoryActivity = newCategoryActivity;

    }

    public void setNewCategoryView(NewCategoryView newCategoryView) {

        this.newCategoryView = newCategoryView;

    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btNewCategoryCreate) {

            //TODO: realizar las validaciones.
            this.newCategoryModel.setCategoryName(this.newCategoryView.getEtNewCategoryName().getText().toString());
            this.newCategoryModel.setDescription(this.newCategoryView.getEtNewCategoryDescription().getText().toString());
            this.newCategoryModel.setFavorite(this.newCategoryView.getCbNewCategoryFavorite().isChecked());

            this.newCategoryActivity.goToCategoryListActivity(this.newCategoryModel);

        }

    }
}
