package com.codecool.dao;

import com.codecool.modules.Displayable;
import com.codecool.user.Admin;
import com.codecool.user.Customer;
import com.codecool.user.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDao extends Dao {

    @Override
    public List<Displayable> getTable(String searchName) {
        List<Displayable> users = new ArrayList<>();
        connect();

        try {
            ResultSet results = statement.executeQuery("SELECT * FROM User WHERE name LIKE \'" + searchName + "\';");
            while (results.next()) {
                int id = results.getInt("id");
                String name = results.getString("name");
                String surname = results.getString("surname");
                String email = results.getString("email");
                String password = results.getString("password");
                Integer created_at = results.getInt("created_at");
                SimpleDateFormat originalFormat = new SimpleDateFormat("yyyyMMdd");
                Date creationDate = originalFormat.parse(created_at.toString());
                String type = results.getString("type");
                User user;
                if (type.equals("admin")) {
                    user = new Admin(id, name, surname, email, password, creationDate);
                } else {
                    user = new Customer(id, name, surname, email, password, creationDate);
                }
                users.add(user);
            }
            results.close();
            statement.close();
            connection.close();
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public List<Displayable> getCategory(String foreignKeyName){
        List<Displayable> users = new ArrayList<>();
        return users;
    }

    @Override
    public void addElement() {}

    @Override
    public void removeElement() {}

    @Override
    public void editElementName() {}
}
