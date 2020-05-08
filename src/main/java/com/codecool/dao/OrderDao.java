package com.codecool.dao;

import com.codecool.modules.Displayable;
import com.codecool.modules.Order;
import com.codecool.modules.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class OrderDao extends Dao{
    @Override
    public List<Displayable> getTable(String searchName) {
        return null;
    }

    @Override
    public List<Displayable> getCategory(String foreignKeyName) {
        return null;
    }

    @Override
    public void addElement(Object element) throws SQLException {
        Order order = (Order) element;
        connect();
        String pattern = "yyyyMMdd";
        DateFormat df = new SimpleDateFormat(pattern);
        String dateToSql = df.format(order.getOrderCreatedAt());
        try {
            statement.executeUpdate("INSERT INTO \"main\".\"Order\" (ordedCreatedAt, orderStatus, Owner) VALUES(" + dateToSql + ", \'Pending"
                                    + "\', \'" + order.getOwner() + "\');");
            statement.close();
            ResultSet results = statement.executeQuery("SELECT id FROM \"main\".\"Order\" ORDER BY id DESC LIMIT 1;");
            int orderId = results.getInt("id");
            statement.close();
            results.close();
            Iterator<Product> productIterator = order.getBasket().getIterator();
            while (productIterator.hasNext()){
                Product product = productIterator.next();
                statement.executeUpdate("INSERT INTO OrderedItems(amount, order_id, product_id) VALUES(" + product.getAmount()
                                        + ", " + orderId + ", " + product.getId() + ");");
                statement.close();
                statement.executeUpdate("UPDATE Product SET amount = amount - " + product.getAmount() + " WHERE id = " + product.getId()
                                        + ";");
                statement.close();
            }
            connection.close();
            order.getBasket().getProducts().clear();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void removeElement(String name) throws SQLException {

    }

    @Override
    public void editElementName(String previousName, String newName) {

    }
}
