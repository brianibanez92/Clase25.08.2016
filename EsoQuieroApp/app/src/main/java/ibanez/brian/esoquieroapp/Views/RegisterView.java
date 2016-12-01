package ibanez.brian.esoquieroapp.Views;

import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;

import ibanez.brian.esoquieroapp.Activities.RegisterActivity;
import ibanez.brian.esoquieroapp.Controllers.RegisterController;
import ibanez.brian.esoquieroapp.Models.RegisterModel;
import ibanez.brian.esoquieroapp.R;

/**
 * Created by brian.ibanez on 30/11/2016.
 */
public class RegisterView
{
    private EditText etRegisterName;
    private EditText etRegisterSurname;
    private EditText etRegisterUsername;
    private EditText etRegisterPassword;
    private EditText etRegisterRepeatPassword;
    private Button btRegisterRegisterMe;

    private RegisterModel registerModel;

    public RegisterView(RegisterModel registerModel, RegisterController registerController, RegisterActivity registerActivity)
    {
        this.registerModel = registerModel;

        this.etRegisterName = (EditText) registerActivity.findViewById(R.id.etRegisterName);
        this.etRegisterSurname = (EditText) registerActivity.findViewById(R.id.etRegisterSurname);
        this.etRegisterUsername = (EditText) registerActivity.findViewById(R.id.etRegisterUsername);
        this.etRegisterPassword = (EditText) registerActivity.findViewById(R.id.etRegisterPassword);
        this.etRegisterRepeatPassword = (EditText) registerActivity.findViewById(R.id.etRegisterRepeatPassword);
        this.btRegisterRegisterMe = (Button) registerActivity.findViewById(R.id.btRegisterRegisterMe);

        this.btRegisterRegisterMe.setOnClickListener(registerController);
    }

    public void updateModel()
    {
        this.registerModel.setName(this.etRegisterName.getText().toString());
        this.registerModel.setSurname(this.etRegisterSurname.getText().toString());
        this.registerModel.setUsername(this.etRegisterUsername.getText().toString());
        this.registerModel.setPassword(this.etRegisterPassword.getText().toString());
        this.registerModel.setRepeatPassword(this.etRegisterRepeatPassword.getText().toString());
    }

}
