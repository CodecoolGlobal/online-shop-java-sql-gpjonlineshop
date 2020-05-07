package com.codecool.modules;

import java.util.List;

public class Product implements Displayable {

    private int id;
    private String name;
    private int price;
    private int amount;
    private boolean isAvailable;
    private Category category;

    public Product(int id, String name, int price, int amount, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.category = category;
    }

    @Override
    public String[] returnStringList(){
        String[] productList = new String[]{Integer.toString(id), name, Integer.toString(price), Integer.toString(amount), category.getName()};
        return productList;
    }

    public int getAmount() {
        return this.amount;
    }

    public String getName() {
        return name;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
