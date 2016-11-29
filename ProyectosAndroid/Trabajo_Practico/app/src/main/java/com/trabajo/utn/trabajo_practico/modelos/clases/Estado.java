package com.trabajo.utn.trabajo_practico.modelos.clases;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by julian.moreno on 11/28/2016.
 */

public class Estado {
    private Boolean error;
    private String mensaje;

    public Estado(){}
    public Estado(boolean estado,String mensaje){
        this.error=estado;
        this.mensaje=mensaje;
    }
    public Estado(JSONObject json){
        try {
            setError(json.getBoolean("error"));
            if(getError()){
                setMensaje(json.getString("message"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String descripcion) {
        this.mensaje = descripcion;
    }
}
