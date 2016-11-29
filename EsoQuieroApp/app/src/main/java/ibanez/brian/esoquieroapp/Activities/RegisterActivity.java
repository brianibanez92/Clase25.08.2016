package ibanez.brian.esoquieroapp.Activities;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ibanez.brian.esoquieroapp.Core.Http.HttpManager;
import ibanez.brian.esoquieroapp.R;

public class RegisterActivity extends AppCompatActivity implements Handler.Callback
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ActionBar myActionBar = getSupportActionBar();
        myActionBar.hide();

    }

    @Override
    public boolean handleMessage(Message message)
    {
        return false;
    }
}
