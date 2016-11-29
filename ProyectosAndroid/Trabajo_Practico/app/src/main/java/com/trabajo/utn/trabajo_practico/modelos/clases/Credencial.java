package com.trabajo.utn.trabajo_practico.modelos.clases;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by julian.moreno on 11/7/2016.
 */

public class Credencial {
    private String name;
    private String email;
    private String apiKey;
    private String createdAt;
    private Estado estado;

    public Credencial(){
        super();
        this.estado=new Estado();
    }

    public Credencial(JSONObject json){
        this();
        this.convertJsonToCredencial(json);
    }
    private void convertJsonToCredencial(JSONObject json) {
        try {
            getEstado().setError(json.getBoolean("error"));
            if(getEstado().getError()){
                getEstado().setMensaje(json.getString("message"));
            }else{
            name=json.getString("name");
            email=json.getString("email");
            apiKey=json.getString("apiKey");
            createdAt=json.getString("createdAt");}
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }


    public String getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
