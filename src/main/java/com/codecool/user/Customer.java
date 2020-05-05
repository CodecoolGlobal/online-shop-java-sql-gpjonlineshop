package com.codecool.user;

import com.codecool.modules.Basket;
import com.codecool.modules.Order;
import com.codecool.modules.Product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Customer extends User {
    private Basket basket;
    private List<Order> orderList;

    public Customer(int id, String name, String surname, String email, String password,
                    Date createdAt) {
        super(id, name, surname, email, password, createdAt);
    }

    public String currentOrderToString(Order order) { //ewentualnie w formie tabelki fliptable
        StringBuilder currentOrder = new StringBuilder();
        int index = 0;

        for (Product product : order.getBasket()) {
            currentOrder.append(String.format("%d. %s", index, product));
            index++;
        }
        return currentOrder.toString(); // tutaj moze dolozyc ui do printowania 
    }

    public String orderHistory(ArrayList<Order> orderHistory) {
        //TODO
    }
}