package com.codecool;

import com.codecool.controlers.Controller;

public class Main
{
    public static void main(String[] args) {
        Controller controller = Controller.initializeController();
        while(controller != null) {
            controller.getAction();
            controller = Controller.getController();
        }
    }

}
