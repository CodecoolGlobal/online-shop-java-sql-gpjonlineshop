package com.codecool.dao;

import com.codecool.modules.Displayable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class Dao {
    protected Connection connection;
    protected Statement statement;

    public static final String DB_NAME = "./src/main/resources/online_shop.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:" + DB_NAME;

    public abstract List<Displayable> getTable(String searchName);
    public abstract List<Displayable> getCategory(String foreignKeyName);
    public abstract void addElement(Object element) throws SQLException;
    public abstract void removeElement(String name) throws SQLException;
    public abstract void editElementName(String previousName, String newName);

    public void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(CONNECTION_STRING);
            statement = connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.getStackTrace();
        } catch (SQLException e) {
            System.out.println("Couldn't connect to database" + e.getMessage());
        }
    }
}
