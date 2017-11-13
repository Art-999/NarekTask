package com.example.arturmusayelyan.narektask;

/**
 * Created by artur.musayelyan on 13/11/2017.
 */

public class Contacts {
    private String name;
    private String email;
    private String mobile;

    public Contacts() {

    }

    public Contacts(String name, String email, String mobile) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
