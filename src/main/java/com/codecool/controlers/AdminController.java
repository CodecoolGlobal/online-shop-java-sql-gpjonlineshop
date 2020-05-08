package com.codecool.controlers;

import com.codecool.dao.CategoryDao;
import com.codecool.dao.ProductDao;
import com.codecool.dao.UserDao;
import com.codecool.modules.Category;
import com.codecool.modules.Displayable;
import com.codecool.modules.Product;
import java.sql.SQLException;
import java.util.List;

public class AdminController extends Controller {

    ProductDao productDao = new ProductDao();
    UserDao userDao = new UserDao();
    CategoryDao categoryDao = new CategoryDao();

    AdminController() {
        addMethodsToHandleProduct();
        addMethodsToHandleUser();
        addMethodsToHandleCategory();
        this.actionMap.put("Log out", this::logOut);
    }

    private void addMethodsToHandleCategory() {
        this.actionMap.put("Add category", () -> categoryDao.addElement(getCategoryToAdd()));
        this.actionMap.put("Delete category", () -> categoryDao.removeElement(getNameOfElement("category")));
    }

    private void addMethodsToHandleProduct() {
        this.actionMap.put("Add product", () -> productDao.addElement(getProductToAdd()));
        this.actionMap.put("Delete product", () -> productDao.removeElement(getNameOfElement("product")));
        this.actionMap.put("Edit name of product", () -> productDao.editElementName(
                getNameOfElement("previous product"), getNameOfElement("new product")));
    }

    private void addMethodsToHandleUser() {
        this.actionMap.put("List all users", () -> view.setQuerryList(this.showAllUsers()));
        this.actionMap.put("Add user", () -> {
            try {
                userDao.addElement(getCustomerToAdd());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        this.actionMap.put("Delete user", () -> {
            try {
                userDao.removeElement(getNameOfElement("user"));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        this.actionMap.put("Edit name of user", () -> userDao.editElementName(
                getNameOfElement("previous user"), getNameOfElement("new user")));
    }

    private List<Displayable> showAllUsers(){
        String[] headers = new String[]{"Id", "Name", "Surname", "Email", "Created at"};
        this.view.setQuerryHeaders(headers);
        return this.userDao.getTable("%");
    }

    private Product getProductToAdd() {
        int id = inputProvider.getPositiveNumber("Enter id of product");
        String name = inputProvider.getValidateWord("Enter name of product");
        int price = inputProvider.getPositiveNumber("Enter price of product");
        int amount = inputProvider.getPositiveNumber("Enter amount of product");
        List<Displayable> categories = categoryDao.getTable("Default");
        int categoryId = ((Category) categories.get(0)).getId();
        String categoryName = inputProvider.getValidateWord("Enter category name");
        categories = categoryDao.getTable(categoryName);
        if (categories.size() != 0) {
            categoryId = ((Category) categories.get(0)).getId();
        }
        Category category = new Category(categoryName, categoryId);
        return new Product(id, name, price, amount, category);
    }

    private Category getCategoryToAdd() {
        String name = inputProvider.getValidateWord("Enter category name");
        return new Category(name);
    }

    private String getNameOfElement(String elementName) {
        return inputProvider.getValidateWord(String.format("Provide name of %s :", elementName));
    }

}
