package com.codecool.user;

import com.codecool.dao.Dao;
import com.codecool.dao.ProductDao;
import com.codecool.dao.UserDao;

import java.util.Date;

public class Admin extends User {

    private UserDao userDao = new UserDao();
    private ProductDao productDao = new ProductDao();

    public Admin(int id, String name, String surname, String email, String password, Date createdAt) {
        super(id, name, surname, email, password, createdAt);
    };

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