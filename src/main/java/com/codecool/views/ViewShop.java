package com.codecool.views;

import com.codecool.modules.Order;
import com.codecool.modules.Product;

import java.util.ArrayList;

public class ViewShop {
    public String currentOrderToString(Order order) {
        StringBuilder currentOrder = new StringBuilder();
        int index = 0;

//        for (Product product : Order.getBasket()) {
//            currentOrder.append(String.format("%d. %s", index, product));
//            index++;
//        }
//        return currentOrder.toString(); // tutaj moze dolozyc ui do printowania

        return "";
    }

    public void orderHistory(ArrayList<Order> orderHistory) {
        //TODO
    }
}
