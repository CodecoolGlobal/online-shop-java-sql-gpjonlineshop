package com.codecool.user;

import com.codecool.modules.Displayable;

import java.util.Date;

public abstract class User implements Displayable {
    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private Date createdAt;

    protected User(int id, String name, String surname, String email, String password, Date createdAt) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
    }

    @Override
    public String[] returnStringList(){
        String[] userList = new String[]{Integer.toString(id), name, surname, email, createdAt.toString()};
        return userList;
    }

    public int getId() { return id; }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}