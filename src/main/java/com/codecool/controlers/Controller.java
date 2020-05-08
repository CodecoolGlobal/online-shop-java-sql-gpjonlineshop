package com.codecool.controlers;

import com.codecool.dao.CategoryDao;
import com.codecool.dao.Dao;
import com.codecool.dao.ProductDao;
import com.codecool.dao.UserDao;
import com.codecool.input.InputProvider;
import com.codecool.models.Command;
import com.codecool.models.Displayable;
import com.codecool.user.Customer;
import com.codecool.user.User;
import com.codecool.views.View;
import java.util.*;

public abstract class  Controller {

    private static Controller controller;
    View view;
    Dao dao;
    HashMap<String, Runnable> actionMap;
    List<Displayable> commandList;
    InputProvider inputProvider;

    Controller(){
        inputProvider = new InputProvider();
        dao = new ProductDao();
        view = new View();
        commandList = new ArrayList<>();
        actionMap = new LinkedHashMap<>();
        view.setQuerryList(this.dao.getCategory("Starships"));
        this.actionMap.put("Dislay all categories", () -> view.setQuerryList(this.showAllCategories()));
        this.actionMap.put("Show all products", () -> view.setQuerryList(this.showAllProduct()));
        this.actionMap.put("Display products from category", () -> view.setQuerryList(this.displayProductsFromCategory()));
        this.actionMap.put("Search product with given name", () -> view.setQuerryList(this.displayProductsWithGivenName()));
    }

    private List<Displayable> showAllCategories() {
        String[] headers = new String[]{"Id", "Name"};
        this.view.setQuerryHeaders(headers);
        return new CategoryDao().getTable("%");
    }

    private List<Displayable> showAllProduct(){
        String[] headers = new String[]{"Id", "Name", "Price", "Ammount", "Category"};
        this.view.setQuerryHeaders(headers);
        return this.dao.getTable("%");
    }

    private List<Displayable> displayProductsWithGivenName(){
        String searchTerm = inputProvider.getValidateWord("Enter name of product");
        String[] headers = new String[]{"Id", "Name", "Price", "Ammount", "Category"};
        this.view.setQuerryHeaders(headers);
        return  this.dao.getTable(searchTerm);
    }

    private List<Displayable> displayProductsFromCategory(){
        String category = inputProvider.getValidateWord("Enter name of category");
        String[] headers = new String[]{"Id", "Name", "Price", "Ammount", "Category"};
        this.view.setQuerryHeaders(headers);
        return this.dao.getCategory(category);
    }

    public static Controller initializeController() {
        controller = new IncognitoController();
        controller.restartActionKeyMap();
        return controller;
    }

    public static Controller getController() {
        return controller;
    }

    public void getAction(){
        restartActionKeyMap();
        this.view.setCommaandList(this.commandList);
        this.view.displayContent();
        int input = inputProvider.getProperActionKey(commandList.size(), "Enter number of action");
        actionMap.get(((Command)commandList.get(input)).getAction()).run();
    }

    void signIn() {
        String nick = inputProvider.getValidateWord("Enter your name");
        String password = inputProvider.getValidateWord("Enter your password");
        List<Displayable> users = new UserDao().getTable(nick);
        if ((users.isEmpty())) {
            //TODO throw new exception UserNotFoundException
            return;

        }
        User user = (User)users.get(0);
        if (user.getPassword().equals(password)) {
            controller = user.getController();
        }
    }

    void logOut() {
        controller = new IncognitoController();
    }

    User getCustomerToAdd() {
        List<String> allNicks = getAllNicks();
        String name;
        do {
            name = inputProvider.getValidateWord("Enter name");
        } while (allNicks.contains(name));
        String surname = inputProvider.getValidateWord("Enter surname");
        String email = inputProvider.getValidateWord("Enter email");
        String password = inputProvider.getValidateWord("Enter password");
        Date createAt = new Date(System.currentTimeMillis());
        int id = 1;
        //todo constructor without id param
        return new Customer(id, name, surname, email, password, createAt);
    }

    private List<String> getAllNicks() {
        List <String> allNicks = new ArrayList<>();
        new UserDao().getTable("%").forEach(u -> allNicks.add(((User) u).getName()));
        return allNicks;
    }

    void quit() {
        controller = null;
    };

    void restartActionKeyMap() {
        commandList.clear();
        int commandId = 0;
        for (String action : actionMap.keySet()) {
            commandList.add(new Command(commandId, action));
            commandId++;
        }
    }
}
