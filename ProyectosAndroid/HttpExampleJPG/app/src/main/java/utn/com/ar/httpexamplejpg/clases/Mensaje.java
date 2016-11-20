package utn.com.ar.httpexamplejpg.clases;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by julian.moreno on 11/20/2016.
 */
public class Mensaje {
    private boolean error=false;
    private String mensaje;

    public Mensaje(){super();}
    public Mensaje(JSONObject json){
        this();
        try {
            error=json.getBoolean("error");
            mensaje=json.getString("message");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
