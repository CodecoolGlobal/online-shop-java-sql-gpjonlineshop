package com.codecool.dao;

import com.codecool.models.Category;
import com.codecool.models.Displayable;
import com.codecool.models.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao extends Dao {

    public Product createProduct(ResultSet results) throws SQLException {
        int id = results.getInt("id");
        String name = results.getString("name");
        int price = results.getInt("price");
        int amount = results.getInt("amount");
        Category category = new Category(results.getString("categoryName"));

        return new Product(id, name, price, amount, category);
    }

    @Override
    public List<Displayable> getTable(String searchName) {
        List<Displayable> products = new ArrayList<>();
        connect();

        try {
//            PreparedStatement statement = connection.prepareStatement(
//                    "SELECT p.*, b.quantity FROM Baskets b " +
//                            "JOIN Products p ON p.id = b.product_id WHERE order_id = ? AND p.name = ?;");
//            statement.setInt(1, 123);
//            statement.setString(2, "jogurt");
//            ResultSet results = statement.executeQuery();

            ResultSet results = statement.executeQuery("SELECT Product.id, Product.name, Product.price, Product.amount," +
                                                        " ct.name AS categoryName"
                                                        + "   FROM Product LEFT JOIN Category ct ON ct.id = Product.category"
                                                        +  " WHERE Product.name LIKE \"%" + searchName + "%\";");
            while (results.next()) {
                products.add(createProduct(results));
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
                products.add(createProduct(results));
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
            //todo we can extract this query into Dao, and pass table parameter
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
