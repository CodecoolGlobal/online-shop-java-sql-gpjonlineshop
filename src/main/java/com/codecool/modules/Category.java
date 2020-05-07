package com.codecool.modules;

import java.util.ArrayList;

public class Category {

    private int id;

    public String getName() {
        return name;
    }

    private String name;
    private boolean isAvailable;
    private ArrayList<Product> products;

    public Category(String name) {
        this.name = name;
    }
}
