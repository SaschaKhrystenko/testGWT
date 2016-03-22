package com.example.test.client;

import java.io.Serializable;

/**
 * Created by ua001022 on 18.03.2016.
 */
public class EmployeeModel implements Serializable {

    private int id;
    private String name;
    private String position;
    private String email;

    public EmployeeModel() {
    }

    public EmployeeModel(String name, String position, String email) {
        this.name = name;
        this.position = position;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
