package com.codecool.modules;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class Basket {
    private int id;
    private Iterator<Product> iterator;
    private List<Displayable> products;

    public Basket() {
        this.products = new ArrayList<>();
        this.iterator = new ProductIterator();
    }

    public List<Displayable> getProducts() { return products; }
    public Iterator<Product> getIterator() {
        return iterator;
    }

    public void addProduct(Displayable product, int amount) {
        ((Product)product).setAmount(amount);
        if (products.isEmpty() ) {this.products.add(product); return;};
        for(Displayable displayable: this.products){
            if (((Product)displayable).getName().equals(((Product)product).getName())) return;
        }
        this.products.add(product);
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
                return (Product)products.get(index++);
            }
            return null;
        }
    }
}