package com.codecool.user;

import java.util.Date;

public class Admin extends User {

    public Admin(int id, String name, String surname, String email, String password, Date createdAt) {
        super(id, name, surname, email, password, createdAt);
    }

}