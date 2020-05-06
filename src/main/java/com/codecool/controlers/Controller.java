package com.codecool.controlers;

import com.codecool.dao.Dao;
import com.codecool.dao.ProductDao;
import com.codecool.user.Customer;
import com.codecool.user.User;
import com.codecool.views.View;
import com.codecool.views.ViewShop;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class  Controller {
    private View view;
    private User user;
    Dao dao;
    HashMap<String, Runnable> actionMap;

    Controller(){

        user = new Customer();
        dao = new ProductDao();
        view = new View();
        actionMap = new HashMap<String,Runnable>();
       //  ViewShop view = new ViewShop(dao.getTable("products"));



    }

    void getAction(HashMap<String, Runnable> actionMap){
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

    private String getInput(String[][] screen){
        String[] headers = new String[]{"Key:", "Action:"};
        this.view.displayContent(screen, headers);
        int choice = 0;
        // get choice
        // map choice into key
        return "";
    }

}
