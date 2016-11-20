package utn.com.ar.httpexamplejpg.model;

/**
 * Created by julian.moreno on 11/19/2016.
 */

public class Credencial {
    private String error;
    private String name;
    private String email;
    private String apiKey;
    private String createdAt;

    public String getError() {
        return error;
    }

    public void setError(String error) {
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
}
