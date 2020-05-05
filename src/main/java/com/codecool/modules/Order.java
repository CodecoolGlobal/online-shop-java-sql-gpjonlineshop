package com.codecool.modules;

import java.util.Date;

public class Order {
    private int id;
    private Basket basket;
    private Date orderCreatedAt;
    private OrderStatus orderStatus;
    private Date orderPayAt;

    public Order(int id, Basket basket) {
        this.id = id;
        this.basket = basket;
        this.orderCreatedAt = new Date(System.currentTimeMillis());//przy princie format SimpleDateFormat
    }

    // OrderStatus sprawdzic status i jesli zaplacone to timestamp

    public boolean pay() {
        //TODO
        return true;
    }

    public Basket getBasket() {
        return basket;
    }
}