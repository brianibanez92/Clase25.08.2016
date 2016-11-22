package com.trabajo.utn.trabajo_practico.vistas;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.trabajo.utn.trabajo_practico.CategoriaActivity;
import com.trabajo.utn.trabajo_practico.R;
import com.trabajo.utn.trabajo_practico.controladores.CategoriaController;
import com.trabajo.utn.trabajo_practico.modelos.CategoriaModel;


/**
 * Created by julian.moreno on 9/25/2016.
 */
public class CategoriaView{
    private Button btnCreate;
    private EditText txtNombre;
    private EditText txtDescripcion;
    private CheckBox chkFavorito;
    private Button btnFoto;
    private CategoriaModel model;

    public CategoriaView(CategoriaModel model, CategoriaActivity ma, CategoriaController controller){
        this.setModel(model);
        this.setBtnCreate((Button)ma.findViewById(R.id.btnCrearCategoria));
        this.setTxtNombre((EditText)ma.findViewById(R.id.txtNombreCategoria));
        this.setTxtDescripcion((EditText)ma.findViewById(R.id.txtDescripcionCategoria));
        this.setChkFavorito((CheckBox)ma.findViewById(R.id.chkFavorito));
        this.setBtnFoto((Button)ma.findViewById(R.id.btnFotoCategoria));

        this.getBtnFoto().setOnClickListener(controller);
        this.getBtnCreate().setOnClickListener(controller);
    }

    public Button getBtnCreate() {
        return btnCreate;
    }

    public void setBtnCreate(Button btnCreate) {
        this.btnCreate = btnCreate;
    }

    public EditText getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(EditText txtNombre) {
        this.txtNombre = txtNombre;
    }

    public EditText getTxtDescripcion() {
        return txtDescripcion;
    }

    public void setTxtDescripcion(EditText txtDescripcion) {
        this.txtDescripcion = txtDescripcion;
    }

    public CheckBox getChkFavorito() {
        return chkFavorito;
    }

    public void setChkFavorito(CheckBox chkFavorito) {
        this.chkFavorito = chkFavorito;
    }

    public CategoriaModel getModel() {
        return model;
    }

    public void setModel(CategoriaModel model) {
        this.model = model;
    }

    public Button getBtnFoto() {
        return btnFoto;
    }

    public void setBtnFoto(Button btnFoto) {
        this.btnFoto = btnFoto;
    }
}
