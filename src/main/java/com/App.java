package com;

import com.controlers.Controller;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        Controller controller = Controller.initializeController();
        while(controller != null) {
            controller = Controller.getController();
            controller.getAction();
        }
    }

}
