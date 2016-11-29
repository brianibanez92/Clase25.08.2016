package ibanez.brian.esoquieroapp.Controllers;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Handler;
import android.view.View;

import ibanez.brian.esoquieroapp.Core.Dialog;
import ibanez.brian.esoquieroapp.Core.Http.HttpManager;
import ibanez.brian.esoquieroapp.Models.CategoryModel;
import ibanez.brian.esoquieroapp.Activities.CategoryActivity;
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

        if (view.getId() == R.id.btNewCategoryCreate)
        {
            this.categoryView.updateModel();

            String dialogMsg = "";
            if (this.categoryModel.getCategoryName().isEmpty())
            {
                dialogMsg = this.categoryActivity.getString(R.string.stringCategoryValidationCategoryName) + "\n";
            }

            if (this.categoryModel.getDescription().isEmpty())
            {
                dialogMsg = dialogMsg + this.categoryActivity.getString(R.string.stringCategoryValidationDescription);
            }

            // Si la variable no tiene valor es por que no hay errores.
            if (dialogMsg.isEmpty())
            {
                SharedPreferences prefs = this.categoryActivity.getSharedPreferences("EsoQuiero", Context.MODE_PRIVATE);
                String apiKey = prefs.getString("apiKey", null);

                // Llamo a la api.
                Handler.Callback callback = this.categoryActivity;
                Handler handler = new Handler(this.categoryActivity);

                Uri.Builder parameters = new Uri.Builder()
                        .appendQueryParameter("categoria_id", String.valueOf(this.categoryModel.getId()))
                        .appendQueryParameter("titulo", this.categoryModel.getCategoryName())
                        .appendQueryParameter("descripcion", this.categoryModel.getDescription());

                HttpManager threadHttpManager = null;

                // Si no tiene id es una categoria nueva.
                if (this.categoryModel.getId() == 0)
                {
                    threadHttpManager = HttpManager.postCategory(handler, apiKey ,parameters);
                }
                else
                {
                    threadHttpManager = HttpManager.putCategory(handler, apiKey ,parameters);
                }

                threadHttpManager.start();
            }
            else
            {
                // Lanzo un dialog para mostrar las validaciones.
                String dialogTitle = this.categoryActivity.getString(R.string.DialogTitleError);
                String dialogBtnAccept = this.categoryActivity.getString(R.string.DialogBtnAccept);

                Dialog md = new Dialog(dialogTitle, dialogMsg, dialogBtnAccept, null);
                md.show(this.categoryActivity.getSupportFragmentManager(), null);
            }
        }

    }
}
