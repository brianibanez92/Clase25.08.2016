package ibanez.brian.esoquieroapp.Models;

/**
 * Created by brian.ibanez on 26/09/2016.
 */
public class LoginModel {

    private String username;
    private String password;
    private boolean rememberMe;
    private String name;

    public LoginModel()
    {
    }

    public boolean isRememberMe()
    {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe)
    {
        this.rememberMe = rememberMe;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

}
