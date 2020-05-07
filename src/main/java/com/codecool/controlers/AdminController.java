package com.codecool.controlers;

public class AdminController extends Controller {
    AdminController() {
        this.actionMap.put("Add product", () -> this.admin.addProduct());
        this.actionMap.put("Delete product", () -> this.admin.deleteProduct());
        // this.actionMap.put("Create new product category", this.dao.CreateNewCategory());
        // this.actionMap.put("Edit category name", this.dao.editCategoryName());
        // this.actionMap.put("Delete category", this.dao.deleteCategory());
        this.actionMap.put("Log out", this::logOut);
    }
}
