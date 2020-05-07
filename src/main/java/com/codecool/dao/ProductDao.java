package com.codecool.dao;

import com.codecool.modules.Category;
import com.codecool.modules.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao extends Dao {

    @Override
    public List<Product> getTable(String searchName) {
        List<Product> products = new ArrayList<>();
        connect();

        try {
            ResultSet results = statement.executeQuery("SELECT * FROM Product WHERE name = \"" + searchName + "\";");
            while (results.next()) {
                int id = results.getInt("id");
                String name = results.getString("name");
                int price = results.getInt("price");
                int amount = results.getInt("amount");
                Category category = new Category(results.getString("Category.name"));
                Product product = new Product(id, name, price, amount, category);
                products.add(product);
            }
            results.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
