package com.views;

import com.modules.Order;
import com.modules.Product;

import java.util.ArrayList;
import java.util.List;

public class ViewShop {

    public ViewShop(List<Product> products){

    }

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
