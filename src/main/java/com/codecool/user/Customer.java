package com.codecool.user;

import com.codecool.controlers.Controller;
import com.codecool.controlers.CustomerController;
import com.codecool.models.Basket;
import com.codecool.models.Order;

import java.util.Date;
import java.util.List;

public class Customer extends User {
    private Basket basket;
    private List<Order> orderList;

    public Customer(int id, String name, String surname, String email, String password, Date createAt) {
        super(id, name, surname, email, password, createAt);
    }

    public Controller getController() {
        return new CustomerController();
    }
}