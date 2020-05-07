package com.codecool.controlers;

import com.codecool.dao.Dao;
import com.codecool.dao.ProductDao;
import com.codecool.dao.UserDao;
import com.codecool.modules.Displayable;
import com.codecool.user.Admin;
import com.codecool.user.Customer;
import com.codecool.user.User;
import com.codecool.views.View;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class  Controller {

    private static Controller controller;

    public static Controller initializeController() {
        controller = new IncognitoController();
        return controller;
    }

    public static Controller getController() {
        return controller;
    }

    Admin admin;
    Customer customer;
    View view;
    User user;
    Dao dao;
    HashMap<String, Runnable> actionMap;
    HashMap<Integer, String> actionKeysMap;

    Controller(){

        dao = new ProductDao();
        view = new View();
        actionKeysMap = new HashMap<>();
        actionMap = new HashMap<String,Runnable>();
        this.actionMap.put("Show all products", () -> view.setObjectList(this.dao.getTable("%")));
        this.actionMap.put("Display products from category", () -> view.setObjectList(this.displayProductsFromCategory()));
        this.actionMap.put("Search product with given name", () -> view.setObjectList(this.displayProductsWithGivenName()));

    }

    private List<Displayable> displayProductsWithGivenName(){
        String searchTerm = "%";
        // get input into category
        return  this.dao.getTable(searchTerm);
    }

    private List<Displayable> displayProductsFromCategory(){
        String category = "";
        // get input into category
        return this.dao.getCategory(category);
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
        view.displayContent();
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
        this.view.setHeaders(new String[]{"Key:", "Action:"});
        this.view.setObjectList(this.actionKeysMap);
        this.view.displayContent();
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
