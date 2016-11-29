package ibanez.brian.clase_20161124;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Handler.Callback, View.OnClickListener
{

    private static String chat = "";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler.Callback callback = this;
        Handler handler = new Handler(this);

        ClientSocket cs = new ClientSocket(handler, "PRUEBAAAAAA");
        cs.start();

        Button button = (Button)this.findViewById(R.id.btEnviar);

        button.setOnClickListener(this);
    }

    @Override
    public boolean handleMessage(Message message)
    {
        String msj = (String) message.obj;

        chat = chat + msj;

        TextView et = (TextView) this.findViewById(R.id.tvChat);
        et.setText(chat);

        return false;
    }

    @Override
    public void onClick(View view)
    {
        if (view.getId() == R.id.btEnviar)
        {
            EditText editText= (EditText) this.findViewById(R.id.etMensaje);
            String mensaje = editText.getText().toString();

            editText.setText("");

            Handler.Callback callback = this;
            Handler handler = new Handler(this);

            ClientSocket cs = new ClientSocket(handler, mensaje);
            cs.start();

        }

    }
}
