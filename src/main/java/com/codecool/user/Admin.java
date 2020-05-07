package com.codecool.user;

import java.util.Date;

public class Admin extends User {

    public Admin(int id, String name, String surname, String email, String password, Date hasJoined) {
        super(id, name, surname, email, password, hasJoined);
    };
/*
    public Admin(int id, String name, String surname, String email, String password, Date hasJoined) {
        super(id, name, surname, email, password, hasJoined);
    }

 */

    //wszytskie polaczenie z db i tam operacja
    public void addUser() {
    }

    public void deleteUser() {
    }

    public void addProduct() {
    }

    public void deleteProduct() {
    }

    public void addCategory() {
    }

    public void deleteCategory() {
    }
}