package com.trabajo.utn.trabajo_practico.modelos;

/**
 * Created by julian.moreno on 9/22/2016.
 */
/*    private EditText txtNombre;
    private EditText txtApellido;
    private EditText txtIdentificacion;
    private EditText txtContraseña;
    private EditText txtContraseñaValidador;
    private Button btnRegistrar;
    */
public class RegistroModel {
    private String nombre;
    private String apellido;
    private String identificacion;
    private String contraseña;
    private String txtContraseñaValidador;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTxtContraseñaValidador() {
        return txtContraseñaValidador;
    }

    public void setTxtContraseñaValidador(String txtContraseñaValidador) {
        this.txtContraseñaValidador = txtContraseñaValidador;
    }
}
