package com.codecool.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class Dao {
    protected Connection connection;
    protected Statement statement;

    public static final String DB_NAME = "src/main/resources/online_shop.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:" + DB_NAME;

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
