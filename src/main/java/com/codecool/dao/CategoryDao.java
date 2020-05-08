package com.codecool.dao;

import com.codecool.modules.Category;
import com.codecool.modules.Displayable;
import com.codecool.modules.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao extends Dao {

    @Override
    public List<Displayable> getTable(String searchName) {
        List<Displayable> categories = new ArrayList<>();
        connect();

        try {
            ResultSet results = statement.executeQuery("SELECT * FROM Category " +
                    " WHERE name LIKE \"" + searchName + "\";");
            while (results.next()) {
                int id = results.getInt("id");
                String name = results.getString("name");
                Category category = new Category(name, id);
                categories.add(category);
            }
            results.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public List<Displayable> getCategory(String foreignKeyName) {
        return null; // ToDo implement
    }

    @Override
    public void addElement(Object element) {
        Category category = (Category) element;
        connect();
        try {
            statement.executeUpdate("INSERT INTO Category (name) VALUES(\'" + category.getName() + "\')");
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
            statement.executeUpdate("DELETE FROM Category WHERE name =\'" + name + "\';");
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void editElementName(String previousName, String newName) {
        // ToDo implement
    }
}
