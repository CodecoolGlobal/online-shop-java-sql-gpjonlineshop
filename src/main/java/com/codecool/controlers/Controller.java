package com.codecool.controlers;

import com.codecool.dao.Dao;
import com.codecool.dao.ProductDao;
import com.codecool.dao.UserDao;
import com.codecool.input.InputProvider;
import com.codecool.modules.Command;
import com.codecool.modules.Displayable;
import com.codecool.user.Admin;
import com.codecool.user.Customer;
import com.codecool.user.User;
import com.codecool.views.View;

import java.util.ArrayList;
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
    List<Displayable> commandList;
    InputProvider inputProvider;

    Controller(){
        inputProvider = new InputProvider();
        dao = new ProductDao();
        view = new View();
        commandList = new ArrayList<>();
        actionMap = new HashMap<String,Runnable>();
        this.actionMap.put("Show all products", () -> view.setObjectList(this.dao.getTable("%")));
        this.actionMap.put("Display products from category", () -> view.setObjectList(this.displayProductsFromCategory()));
        this.actionMap.put("Search product with given name", () -> view.setObjectList(this.displayProductsWithGivenName()));

    }

    private List<Displayable> displayProductsWithGivenName(){
        String searchTerm = inputProvider.getValidateWord();
        return  this.dao.getTable(searchTerm);
    }

    private List<Displayable> displayProductsFromCategory(){
        String category = inputProvider.getValidateWord();
        return this.dao.getCategory(category);
    }

    public void getAction(){
        String[][] screen = new String[actionMap.size()][2];
        int i=0;
        for(Map.Entry<String, Runnable> entry : actionMap.entrySet()){
            screen[i][0] = String.valueOf(i);
            screen[i][1] = entry.getKey();
            i++;
        }
        this.view.setHeaders(new String[]{"Key:", "Action:"});
        this.view.setObjectList(this.commandList);
        this.view.displayContent();
        int input = inputProvider.getProperActionKey(commandList.size());
        actionMap.get(((Command)commandList.get(input)).getAction()).run();
        view.displayContent();
    }

    void signIn() {
        String nick = inputProvider.getValidateWord();
        String password = inputProvider.getValidateWord();
        List<Displayable> users = new UserDao().getTable(nick);
        if (!(users.isEmpty())) {
            return;

        }
        User user = (User)users.get(0);
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

        int choice = 0;
        // get choice
        // map choice into key
        return "";
    }

    void restartActionKeyMap() {
        commandList.clear();
        int commandId = 0;
        for (String action : actionMap.keySet()) {
            commandList.add(new Command(commandId, action));
            commandId++;
        }
    }

}
