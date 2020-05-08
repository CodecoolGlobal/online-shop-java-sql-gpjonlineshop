package com.codecool.modules;

import com.codecool.dao.OrderDao;

import java.sql.SQLException;
import java.util.Date;

public class Order {
    private int id;
    private Basket basket;
    private Date orderCreatedAt;
    private OrderStatus orderStatus;
    private Date orderPayAt;
    private String owner;

    public Order(Basket basket, String name) {
        this.basket = basket;
        this.owner = name;
        this.orderCreatedAt = new Date(System.currentTimeMillis());

    }

    // OrderStatus sprawdzic status i jesli zaplacone to timestamp
    public void processOrder(){
        OrderDao dao = new OrderDao();
        try {
            dao.addElement(this);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public String getOwner() {
        return owner;
    }

    public Date getOrderCreatedAt() {
        return orderCreatedAt;
    }

    public boolean pay() {
        //TODO
        return true;
    }


    public Basket getBasket() {
        return basket;
    }
}