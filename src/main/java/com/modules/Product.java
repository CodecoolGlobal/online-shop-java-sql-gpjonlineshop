package com.modules;

public class Product {

    private int id;
    private String name;
    private double price;
    private int amount;
    private boolean isAvailable;
    private Category category;

    public Product(int id, String name, double price, int amount, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.category = category;
    }
}
