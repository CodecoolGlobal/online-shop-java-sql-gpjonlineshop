package com.codecool.dao;

import com.codecool.modules.Category;
import com.codecool.modules.Displayable;

import java.util.List;

public class CategoryDao extends Dao {
    @Override
    public List<Displayable> getTable(String searchName) {
        return null; // ToDo implement
    }

    @Override
    public List<Displayable> getCategory(String foreignKeyName) {
        return null; // ToDo implement
    }

    @Override
    public void addElement(Object element) {
        Category category = (Category) element; // ToDo implement
    }

    @Override
    public void removeElement(String name) {
        // ToDo implement
    }

    @Override
    public void editElementName(String previousName, String newName) {
        // ToDo implement
    }
}
