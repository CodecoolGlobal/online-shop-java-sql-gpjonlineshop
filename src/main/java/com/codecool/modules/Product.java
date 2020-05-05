package com.codecool.modules;

public class Product {

    private int id;
    private String name;
    private double price;
    private int amount;
    private boolean isAvailable;
    private Category category;

    public Product(String name, double price, int amount, Category category) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.category = category;
    }
}
