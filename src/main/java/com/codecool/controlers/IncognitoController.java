package com.codecool.controlers;

import com.codecool.dao.UserDao;

import java.sql.SQLException;

public class IncognitoController extends Controller {
    IncognitoController() {
        this.actionMap.put("Sign in", this::signIn);
        this.actionMap.put("Sign up", () -> {
            try {
                new UserDao().addElement(this.getCustomerToAdd());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        this.actionMap.put("Quit", this::quit);
    }

}
