package com.codecool.user;

import java.util.Date;

public abstract class User {
    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private Date hasJoined;

    public User(int id, String name, String surname, String email, String password, Date hasJoined) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.hasJoined = hasJoined;
    }

    // czy wszystkie potrzebne
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

    public Date getHasJoined() {
        return hasJoined;
    }

    public void setHasJoined(Date hasJoined) {
        this.hasJoined = hasJoined;
    }
}