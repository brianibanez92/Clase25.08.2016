package ibanez.brian.esoquieroapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ibanez.brian.esoquieroapp.Controllers.LoginController;
import ibanez.brian.esoquieroapp.Models.LoginModel;
import ibanez.brian.esoquieroapp.Views.LoginView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ActionBar myActionBar = getSupportActionBar();
        myActionBar.hide();

        LoginModel loginModel = new LoginModel();
        LoginController loginController = new LoginController(loginModel, this);
        LoginView loginView = new LoginView(loginModel, loginController, this);
        loginController.setLoginView(loginView);

    }

    /*private void userRemembered(){

        SharedPreferences sharedPreferences = this.getSharedPreferences("USER", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Limpio lo almacenado para guardar los nuevos registros.
        editor.clear();
        editor.putString(key, value);
        editor.commit();

    }*/

    public void goToCategoryListActivity() {

        Intent categoryList = new Intent(this, CategoryListActivity.class);
        this.startActivity(categoryList);

    }

}
