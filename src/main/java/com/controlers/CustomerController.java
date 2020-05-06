package com.controlers;

public class CustomerController extends Controller {
    CustomerController(){
        this.actionMap.put("Add product to basket", () -> this.customer.addProductToBasket());
        this.actionMap.put("Edit product quantity", () -> this.customer.editProductQuantity());
        // this.actionMap.put("See whole basket", () -> this.view.showWholeBasket(this.customer.getBasket()));
        this.actionMap.put("Place an order", () -> this.customer.placeAnOrder());
        // this.actionMap.put("Check availability of product", this.dao.checkAvailabilityOfProduct());
        this.actionMap.put("Log out", this::logOut);
    }
}