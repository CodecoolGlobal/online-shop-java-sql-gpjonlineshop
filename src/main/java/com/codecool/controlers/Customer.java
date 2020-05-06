package com.codecool.controlers;

public class Customer extends Controller {
    Customer(){
        this.actionMap.put("Show all products", () -> this.dao.getTable("Product")  );
        // ... this.actionMap.put("nazwa", () -> wykonywana akcja);
        // ...
        // ...
    }
}
