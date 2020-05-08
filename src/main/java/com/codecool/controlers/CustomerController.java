package com.codecool.controlers;

import com.codecool.modules.Basket;
import com.codecool.modules.Displayable;
import com.codecool.modules.Order;
import com.codecool.modules.Product;
import com.codecool.user.Customer;

import java.util.List;

public class CustomerController extends Controller {
    private Basket basket;

    CustomerController(){
        this.basket = new Basket();
        this.actionMap.put("Add product to basket", () -> this.addProductToBasket());
        this.actionMap.put("Edit product quantity", () -> this.editQuantityInBasket());
        this.actionMap.put("Delete product from basket", () -> this.deleteProductFromBasket());
        this.actionMap.put("Place an order", () -> this.placeAnOrder());
        // this.actionMap.put("Check availability of product", this.dao.checkAvailabilityOfProduct());
        this.actionMap.put("Log out", this::logOut);
    }
    public void addProductToBasket() {
        List<Displayable> productList = dao.getTable("%");
        int selectedProductIndex = inputProvider.getProperActionKey(productList.size()+1, "Please enter products ID:");
        if (selectedProductIndex == 0) return;
        Displayable selectedProduct = productList.get(selectedProductIndex-1);
        int selectedAmmount = inputProvider.getProperActionKey(((Product)selectedProduct).getAmount()+1, "Please enter ammount:");
        this.basket.addProduct(selectedProduct, selectedAmmount);
        this.view.setBasketList(this.basket.getProducts());
    }
    public void editQuantityInBasket(){
        List<Displayable> productList = dao.getTable("%");
        int selectedProductIndex = inputProvider.getProperActionKey(productList.size()+1, "Please enter products ID:");
        if (selectedProductIndex == 0) return;
        Displayable selectedProduct = productList.get(selectedProductIndex-1);
        int selectedAmmount = inputProvider.getProperActionKey(((Product)selectedProduct).getAmount()+1, "Please enter ammount:");
        this.basket.changeProduct(selectedProduct, selectedAmmount);
        this.view.setBasketList(this.basket.getProducts());
    }
    public void deleteProductFromBasket() {
        List<Displayable> productList = dao.getTable("%");
        int selectedProductIndex = inputProvider.getProperActionKey(productList.size()+1, "Please enter products ID:");
        if (selectedProductIndex == 0) return;
        this.basket.removeProduct(productList.get(selectedProductIndex-1));
        this.view.setBasketList(this.basket.getProducts());
    }
    public void placeAnOrder() {
        Order order = new Order(this.basket, "Klient");
        order.processOrder();
        this.view.setQuerryList(this.dao.getTable("%"));
    }
}