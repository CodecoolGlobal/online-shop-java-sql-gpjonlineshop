package com.modules;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Basket {
    private int id;
    private Iterator<Product> iterator;
    private List<Product> products;

    public Basket() {
        this.products = new ArrayList<>();
        this.iterator = new ProductIterator();
    }

    public Iterator<Product> getIterator() {
        return iterator;
    }

    public void addProduct(Product product, int amount) {

    }

    public void deleteProduct(Product product) {

    }
    
    private class ProductIterator implements Iterator<Product> {
        int index;

        @Override
        public boolean hasNext() {
            return index < products.size();
        }

        @Override
        public Product next() {
            if (this.hasNext()) {
                return products.get(index++);
            }
            return null;
        }
    }
}