package com.orders.util;
import java.util.Date;

public class Order {
    Integer id;
    Date creationDate;
    Date paymentDate;
    Date dueDate;
    Customer customer;
    Salesperson salesperson;
    Store store;
    Item[] items = new Item[3];

    public float calculateTotalPrice() {
        Float totalPrice = 0.0f;

        for (int i = 0; i < items.length; i++) {
            totalPrice += items[i].price;
        }
        System.out.println("Total Price: " + totalPrice); 
        return totalPrice;
    }
    public void generateSaleDescription() {
        String message = "Data de Criação: " + creationDate.toString()
                + ", Preço total: " + calculateTotalPrice() + "";
        System.out.println(message); 
}
