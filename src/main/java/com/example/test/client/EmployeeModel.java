package com.example.test.client;

import java.io.Serializable;

/**
 * Created by ua001022 on 18.03.2016.
 */
public class EmployeeModel implements Serializable {

    private Integer id;
    private String name;
    private String position;
    private String email;

    private static int COUNTER = 0;

    public EmployeeModel() {
        this.id = Integer.valueOf(COUNTER++);
    }

    public EmployeeModel(String name, String position, String email) {
        this();
        this.name = name;
        this.position = position;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
