package ibanez.brian.esoquieroapp.Views;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import ibanez.brian.esoquieroapp.Controllers.NewCategoryController;
import ibanez.brian.esoquieroapp.Models.NewCategoryModel;
import ibanez.brian.esoquieroapp.NewCategoryActivity;
import ibanez.brian.esoquieroapp.R;

/**
 * Created by brian.ibanez on 28/09/2016.
 */
public class NewCategoryView {

    private NewCategoryModel newCategoryModel;
    private NewCategoryController newCategoryController;
    private NewCategoryActivity newCategoryActivity;

    private EditText etNewCategoryName;
    private EditText etNewCategoryDescription;
    private CheckBox cbNewCategoryFavorite;
    private Button btNewCategoryCreate;

    public NewCategoryView(NewCategoryModel newCategoryModel, NewCategoryController newCategoryController, NewCategoryActivity newCategoryActivity) {

        this.newCategoryModel = newCategoryModel;
        this.newCategoryController = newCategoryController;
        this.newCategoryActivity = newCategoryActivity;

        // Seteo las view.
        this.etNewCategoryName = (EditText) newCategoryActivity.findViewById(R.id.etNewCategoryName);
        this.etNewCategoryDescription = (EditText) newCategoryActivity.findViewById(R.id.etNewCategoryDescription);
        this.cbNewCategoryFavorite = (CheckBox) newCategoryActivity.findViewById(R.id.cbNewCategoryFavorite);
        this.btNewCategoryCreate = (Button) newCategoryActivity.findViewById(R.id.btNewCategoryCreate);

        // Seteo los valores de las view.
        this.etNewCategoryName.setText(this.newCategoryModel.getCategoryName());
        this.etNewCategoryDescription.setText(this.newCategoryModel.getDescription());
        this.cbNewCategoryFavorite.setChecked(this.newCategoryModel.getFavorite());

        this.btNewCategoryCreate.setOnClickListener(newCategoryController);

    }

    public EditText getEtNewCategoryName() {
        return etNewCategoryName;
    }

    public void setEtNewCategoryName(EditText etNewCategoryName) {
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

    public void setCbNewCategoryFavorite(CheckBox cbNewCategoryFavorite) {
        this.cbNewCategoryFavorite = cbNewCategoryFavorite;
    }

}
