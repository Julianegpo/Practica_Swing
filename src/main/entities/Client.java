package main.entities;

/**
 * Created by julian.egea on 26/2/16.
 */
public class Client {
    int id;
    String name;
    String surname;
    String dni;
    String poblation;
    int postal_code;
    int phone;
    public Client(int id, String name, String surname, String dni, String poblation, int postal_code, int phone) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.poblation = poblation;
        this.postal_code = postal_code;
        this.phone = phone;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
}
