package com.codecool.dao;

import com.codecool.modules.Category;
import com.codecool.modules.Displayable;
import com.codecool.modules.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao extends Dao {

    @Override
    public List<Displayable> getTable(String searchName) {
        List<Displayable> products = new ArrayList<>();
        connect();

        try {
            ResultSet results = statement.executeQuery("SELECT Product.id, Product.name, Product.price, Product.amount," +
                                                        " ct.name AS categoryName"
                                                        + "   FROM Product LEFT JOIN Category ct ON ct.id = Product.category"
                                                        +  " WHERE Product.name LIKE \"%" + searchName + "%\";");
            while (results.next()) {
                int id = results.getInt("id");
                String name = results.getString("name");
                int price = results.getInt("price");
                int amount = results.getInt("amount");
                Category category = new Category(results.getString("categoryName"));
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

    public List<Displayable> getCategory(String foreignKeyName){
        List<Displayable> products = new ArrayList<>();
        connect();

        try {
            ResultSet results = statement.executeQuery("SELECT Product.id, Product.name, Product.price, Product.amount,"
                                                            + " ct.name AS categoryName"
                                                            + " FROM Product LEFT JOIN Category ct ON ct.id = Product.category "
                                                            + "WHERE categoryName = \""+ foreignKeyName+"\";");
            while (results.next()) {
                int id = results.getInt("id");
                String name = results.getString("name");
                int price = results.getInt("price");
                int amount = results.getInt("amount");
                Category category = new Category(results.getString("categoryName"));
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

    @Override
    public void addElement(Object element) {
        Product product = (Product) element;
        connect();
        try {
            statement.executeUpdate("INSERT INTO Product (name, price, amount, category) VALUES(\'" + product.getName() + "\', \'"
                    + product.getPrice() + "\', \'" + product.getAmount() + "\', \'" + product.getCategory().getId() + "\');");
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void removeElement(String name) {
        connect();
        try {
            statement.executeUpdate("DELETE FROM Product WHERE name =\'" + name + "\';");
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void editElementName(String previousName, String newName) {
        connect();
        try {
            statement.executeUpdate("Update Product SET name = \'" + newName + "\' WHERE name = \'" + previousName + "\';");
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
