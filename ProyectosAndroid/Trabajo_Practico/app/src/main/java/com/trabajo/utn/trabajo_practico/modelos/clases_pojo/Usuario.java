package com.trabajo.utn.trabajo_practico.modelos.clases_pojo;

import java.util.Date;

/**
 * Created by julian.moreno on 11/7/2016.
 */

public class Usuario {
    private boolean error;
    public String name;
    public String email;
    public String apiKey;
    private Date createdDate;
    private String message;

    public Usuario(){}

    public Usuario(String name,String email,String apiKey){
        this.name=name;
        this.email=email;
        this.apiKey=apiKey;
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
