package ibanez.brian.clase06102016;

/**
 * Created by brian.ibanez on 13/10/2016.
 */
public class Persona {

    private String name;
    private String surname;
    private String phoneNumber;
    private String img;

    public Persona(){super();}
    public Persona(String name,String surname,String phoneNumber,String img){
        this();
        this.name=name;
        this.surname=surname;
        this.phoneNumber=phoneNumber;
        this.img=img;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

}
