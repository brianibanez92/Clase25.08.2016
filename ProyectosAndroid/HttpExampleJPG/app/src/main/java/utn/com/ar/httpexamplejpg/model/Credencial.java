package utn.com.ar.httpexamplejpg.model;

import android.util.JsonReader;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by julian.moreno on 11/19/2016.
 */

public class Credencial {
    private boolean error;
    private String name;
    private String email;
    private String apiKey;
    private String createdAt;

    public Credencial(){
        super();
    }

    public Credencial(JSONObject json){
        this();
        this.convertJsonToCredencial(json);
    }
    public boolean getError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
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

    @Override
    public String toString(){
        return "Credencial[Name:"+name+" ,Email:"+email+", ApiKey:"+apiKey+" ,CreatedAt:"+createdAt+"]";
    }
    private void convertJsonToCredencial(JSONObject json) {
        try {
            error=json.getBoolean("error");
            name=json.getString("name");
            email=json.getString("email");
            apiKey=json.getString("apiKey");
            createdAt=json.getString("createdAt");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
