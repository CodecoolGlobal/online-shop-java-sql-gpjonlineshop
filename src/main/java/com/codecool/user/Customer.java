package com.codecool.user;

import com.codecool.modules.Basket;
import com.codecool.modules.Order;

import java.util.Date;
import java.util.List;

public class Customer extends User {
    private Basket basket;
    private List<Order> orderList;

    public Customer(int id, String name, String surname, String email, String password, Date createAt) {
        super(id, name, surname, email, password, createAt);
    }




}