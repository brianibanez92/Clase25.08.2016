package com.trabajo.utn.trabajo_practico.vistas;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.trabajo.utn.trabajo_practico.LoginActivity;
import com.trabajo.utn.trabajo_practico.R;
import com.trabajo.utn.trabajo_practico.RegistroActivity;
import com.trabajo.utn.trabajo_practico.controladores.LoginController;
import com.trabajo.utn.trabajo_practico.controladores.RegistroController;
import com.trabajo.utn.trabajo_practico.modelos.LoginModel;
import com.trabajo.utn.trabajo_practico.modelos.RegistroModel;

/**
 * Created by julian.moreno on 9/22/2016.
 */
public class RegistroView {
    private EditText txtNombre;
    private EditText txtApellido;
    private EditText txtUsername;
    private EditText txtEmail;
    private EditText txtContraseña;
    private EditText txtContraseñaValidador;
    private Button btnRegistrar;
    private RegistroModel model;

    public RegistroView(RegistroModel model, RegistroActivity ma, RegistroController controller)
    {
        this.setModel(model);
        this.setBtnRegistrar((Button)ma.findViewById(R.id.btnRegister));

        this.setTxtNombre((EditText)ma.findViewById(R.id.name));
        this.setTxtApellido((EditText)ma.findViewById(R.id.last_name));
        this.setTxtUsername((EditText)ma.findViewById(R.id.username));
        this.setTxtEmail((EditText)ma.findViewById(R.id.email_register));
        this.setTxtContraseña((EditText)ma.findViewById(R.id.password));
        this.setTxtContraseñaValidador((EditText)ma.findViewById(R.id.repeat_password));

        this.getBtnRegistrar().setOnClickListener(controller);
    }

    public EditText getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(EditText txtNombre) {
        this.txtNombre = txtNombre;
    }

    public EditText getTxtApellido() {
        return txtApellido;
    }

    public void setTxtApellido(EditText txtApellido) {
        this.txtApellido = txtApellido;
    }

    public EditText getTxtContraseña() {
        return txtContraseña;
    }

    public void setTxtContraseña(EditText txtContraseña) {
        this.txtContraseña = txtContraseña;
    }

    public EditText getTxtContraseñaValidador() {
        return txtContraseñaValidador;
    }

    public void setTxtContraseñaValidador(EditText txtContraseñaValidador) {
        this.txtContraseñaValidador = txtContraseñaValidador;
    }

    public Button getBtnRegistrar() {
        return btnRegistrar;
    }

    public void setBtnRegistrar(Button btnRegistrar) {
        this.btnRegistrar = btnRegistrar;
    }

    public RegistroModel getModel() {
        return model;
    }

    public void setModel(RegistroModel model) {
        this.model = model;
    }

    public EditText getTxtUsername() {
        return txtUsername;
    }

    public void setTxtUsername(EditText txtUsername) {
        this.txtUsername = txtUsername;
    }

    public EditText getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(EditText txtEmail) {
        this.txtEmail = txtEmail;
    }
}
