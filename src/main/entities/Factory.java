package main.entities;

/**
 * Created by julian.egea on 26/2/16.
 */
public class Factory {
    int id;
    String owner;
    String dni;
    String poblation;
    int postal_code;
    int phone;
    float comission;

    public Factory(int id, String owner, String dni, String poblation, int postal_code, int phone, float comission){
        this.id=id;
        this.owner=owner;
        this.dni=dni;
        this.poblation=poblation;
        this.postal_code=postal_code;
        this.phone=phone;
        this.comission=comission;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPoblation() {
        return poblation;
    }

    public void setPoblation(String poblation) {
        this.poblation = poblation;
    }

    public int getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(int postal_code) {
        this.postal_code = postal_code;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public float getComission() {
        return comission;
    }

    public void setComission(float comission) {
        this.comission = comission;
    }
}
