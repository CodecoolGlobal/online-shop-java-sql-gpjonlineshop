package com.codecool.modules;

import java.util.ArrayList;

public class Category implements Displayable {

    private int id;
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public Category(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String[] returnStringList() {
        return new String[] {Integer.toString(this.id), this.name};
    }

    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }

}
