package ibanez.brian.esoquieroapp.Controllers;

import android.net.Uri;
import android.os.Handler;
import android.view.View;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ibanez.brian.esoquieroapp.Activities.RegisterActivity;
import ibanez.brian.esoquieroapp.Core.Dialog;
import ibanez.brian.esoquieroapp.Core.Http.HttpManager;
import ibanez.brian.esoquieroapp.Models.RegisterModel;
import ibanez.brian.esoquieroapp.R;
import ibanez.brian.esoquieroapp.Views.RegisterView;

/**
 * Created by brian.ibanez on 30/11/2016.
 */
public class RegisterController implements View.OnClickListener
{
    private RegisterActivity registerActivity;
    private RegisterModel registerModel;
    private RegisterView registerView;

    public RegisterController(RegisterModel registerModel, RegisterActivity registerActivity)
    {
        this.registerModel = registerModel;
        this.registerActivity = registerActivity;
    }

    public void setRegisterView(RegisterView registerView)
    {
        this.registerView = registerView;
    }

    @Override
    public void onClick(View view)
    {

        if (R.id.btRegisterRegisterMe == view.getId()) {
            this.registerView.updateModel();

            String dialogMsg = "";
            if (this.registerModel.getName().isEmpty()) {
                dialogMsg = this.registerActivity.getString(R.string.RegisterValidationName) + "\n";
            }

            if (this.registerModel.getSurname().isEmpty()) {
                dialogMsg = dialogMsg + this.registerActivity.getString(R.string.RegisterValidationSurname) + "\n";
            }

            if (this.registerModel.getUsername().isEmpty())
            {
                dialogMsg = dialogMsg + this.registerActivity.getString(R.string.RegisterValidationUsername) + "\n";
            }
            else
            {
                if(!emailValidator(this.registerModel.getUsername()))
                {
                    dialogMsg = dialogMsg + this.registerActivity.getString(R.string.RegisterValidationMailValid) + "\n";
                }
            }

            if (this.registerModel.getPassword().isEmpty()) {
                dialogMsg = dialogMsg + this.registerActivity.getString(R.string.RegisterValidationPassword) + "\n";
            }

            if (this.registerModel.getRepeatPassword().isEmpty()) {
                dialogMsg = dialogMsg + this.registerActivity.getString(R.string.RegisterValidationRepeatPassword) + "\n";
            }

            if (!this.registerModel.getPassword().isEmpty() && !this.registerModel.getRepeatPassword().isEmpty()) {
                if (!this.registerModel.getPassword().equals(this.registerModel.getRepeatPassword())) {
                    dialogMsg = dialogMsg + this.registerActivity.getString(R.string.RegisterValidationPasswordEquals) + "\n";
                }
            }

            // Si la variable no tiene valor es por que no hay errores.
            if (dialogMsg.isEmpty()) {
                // Llamo a la api.
                Handler.Callback callback = this.registerActivity;
                Handler handler = new Handler(this.registerActivity);

                Uri.Builder parameters = new Uri.Builder()
                        .appendQueryParameter("nombre", this.registerModel.getName())
                        .appendQueryParameter("apellido", this.registerModel.getSurname())
                        .appendQueryParameter("usuario", this.registerModel.getUsername())
                        .appendQueryParameter("email", this.registerModel.getUsername())
                        .appendQueryParameter("password", this.registerModel.getPassword());

                HttpManager threadHttpManager = HttpManager.postRegister(handler, parameters);
                threadHttpManager.start();
            } else {
                // Lanzo un dialog para mostrar las validaciones.
                String dialogTitle = this.registerActivity.getString(R.string.DialogTitleError);
                String dialogBtnAccept = this.registerActivity.getString(R.string.DialogBtnAccept);

                Dialog md = new Dialog(dialogTitle, dialogMsg, dialogBtnAccept, null);
                md.show(this.registerActivity.getSupportFragmentManager(), null);
            }
        }
    }

    public static boolean emailValidator(String email)
    {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
