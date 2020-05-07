package com.codecool.controlers;

import com.codecool.dao.Dao;
import com.codecool.dao.ProductDao;
import com.codecool.dao.UserDao;
import com.codecool.user.Admin;
import com.codecool.user.Customer;
import com.codecool.user.User;
import com.codecool.views.View;
import com.codecool.views.ViewShop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class  Controller {

    private static Controller controller;

    public static Controller initializeController() {
        controller = new IncognitoController();
        return controller;
    }

    public static Controller getController() {
        return controller;
    }


    View view;
    Customer customer;
    Admin admin;
    Dao dao;
    HashMap<String, Runnable> actionMap;
    HashMap<Integer, String> actionKeysMap;

    Controller(){

        dao = new ProductDao();
        view = new View();
        actionKeysMap = new HashMap<>();
        actionMap = new HashMap<String,Runnable>();
        this.actionMap.put("Show all products", () -> this.dao.getTable("Product")  );
        // this.actionMap.put("Display products from category", () -> dao.displayProductsFromCategory());
       //  ViewShop view = new ViewShop(dao.getTable("products"));
    }

    public void getAction(){
        String[][] screen = new String[actionMap.size()][2];
        int i=0;
        String input =  "";
        for(Map.Entry<String, Runnable> entry : actionMap.entrySet()){
            screen[i][0] = String.valueOf(i);
            screen[i][1] = entry.getKey();
            i++;
        }

        input = getInput(screen);

        actionMap.get(input).run();

    }

    void signIn() {
        String nick = ""; //getinput
        String password = ""; //getInput
        List<User> users = new UserDao().getTable(nick);
        if (!(users.isEmpty())) {
            return;

        }
        User user = users.get(0);
        if (user.getPassword().equals(password)) {
            if (user instanceof Customer) {
                this.customer = (Customer) user;
                controller = new CustomerController();
            } else {
                this.admin = (Admin) user;
                controller = new AdminController();
            }
        }
        restartActionKeyMap();
    }

    void logOut() {
        this.admin = null;
        this.customer = null;
        controller = new IncognitoController();
    }
    void quit() {
        controller = null;
    };

    private String getInput(String[][] screen){
        String[] headers = new String[]{"Key:", "Action:"};
        this.view.displayContent(screen, headers);
        int choice = 0;
        // get choice
        // map choice into key
        return "";
    }

    void restartActionKeyMap() {
        int n = 1;
        for (String action : actionMap.keySet()) {
            actionKeysMap.put(n, action);
            n++;
        }
    }

}
