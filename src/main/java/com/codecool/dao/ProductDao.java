package com.codecool.dao;

import com.codecool.modules.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao extends Dao {

    public List<Product> getProducts(String productCategory) {
        List<Product> products = new ArrayList<>();
        connect();

        try {
            ResultSet results = statement.executeQuery(String.format("SELECT * FROM %s;", productCategory));
            while (results.next()) {
                int id = results.getInt("id");
                String name = results.getString("name");
                int price = results.getInt("price");
                int amount = results.getInt("amount");
                Category category = new Category(results.getString(" ")); //TODO pobranie category name

                Product product = new Product(id, name, price, amount, category);
                products.add(product);
            }
            results.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products; // czy zwracac w postaci stringa
    }

    public Product checkProductAvailiability(String productCategory, String productName) {//zwraca info o jednym konkretnym produkcie
        Product product = null;
        connect();

        try {
            ResultSet results = statement.executeQuery(String.format("SELECT * FROM %s WHERE name = %s;", productCategory, productName));
            while (results.next()) {
                int id = results.getInt("id");
                String name = results.getString("name");
                int price = results.getInt("price");
                int amount = results.getInt("amount");
                Category category = new Category(results.getString(" ")); //TODO pobranie category name

                product = new Product(id, name, price, amount, category);
            }
            results.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
}
