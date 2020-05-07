package com.codecool.controlers;

import com.codecool.dao.UserDao;

public class IncognitoController extends Controller {
    IncognitoController() {
        this.actionMap.put("Sign in", this::signIn);
        this.actionMap.put("Sign up", () -> new UserDao().addElement(this.getCustomerToAdd()));
        this.actionMap.put("Quit", this::quit);
    }

}
