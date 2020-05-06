package com.codecool.controlers;

public class CustomerController extends Controller {
    CustomerController(){
        this.actionMap.put("Add product to basket", () -> this.customer.addProductToBasket());
        this.actionMap.put("Edit product quantity", () -> this.customer.editProductQuantity());
        this.actionMap.put("See whole basket", () -> this.view.showWholeBasket(this.customer.getBasket()));
        this.actionMap.put("Log out", this::logOut)
        // ... this.actionMap.put("nazwa", () -> wykonywana akcja);
        // ...
        // ...
    }
}