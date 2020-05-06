package com.codecool;

import com.codecool.controlers.Controller;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        Controller controller = Controller.initializeController();
        while(true) {
            controller = Controller.getController();
            controller.getAction();
        }
    }

}
