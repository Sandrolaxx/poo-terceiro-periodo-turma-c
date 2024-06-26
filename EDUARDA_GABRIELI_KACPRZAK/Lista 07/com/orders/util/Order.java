package com.orders.util;

import java.util.Date;

public class Order {
    private Integer id;
    private Date creationDate;
    private Date paymentDate;
    private Date dueDate;
    private Customer customer;
    private Salesperson salesperson;
    private Store store;
    private String coPartner;
    private Item[] items = new Item[5];

    public void setId(Integer id) {
        this.id = id;
      }
    
      public Integer getId() {
        return id;
      }
    
      public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
      }
    
      public Date getCreationDate() {
        return creationDate;
      }
    
      public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
      }
    
      public Date getPaymentDate() {
        return paymentDate;
      }
    
      public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
      }
    
      public Date getDueDate() {
        return dueDate;
      }
    
      public void setCustomer(Customer customer) {
        this.customer = customer;
      }
    
      public Customer getCustomer() {
        return customer;
      }
    
      public void setSalesperson(Salesperson Salesperson) {
        this.salesperson = Salesperson;
      }
    
      public Salesperson getSalesperson() {
        return salesperson;
      }
    
      public void setStore(Store Store) {
        this.store = Store;
      }
    
      public Store getStore() {
        return store;
      }
    
      public void setCoPartner(String coPartner) {
        this.coPartner = coPartner;
      }
    
      public String getCoPartner() {
        return coPartner;
      }

    private int position = 0;

    public void saveItem(Item item) {
        items[position++] = item;
        item.setId(position);
    }

    public float calculateTotalPrice() {
        if (items[0] == null) return 0;

        Float totalPrice = 0.0f;
        for (int i = 0; i < items.length; i++) {
            totalPrice += items[i].price;
        }

        System.out.println("Valor total: " + totalPrice); 
        return totalPrice;
    }

    public void generateDescription() {
        String message = "Data de criação: " + creationDate.toString()
                + "\nValor total: " + calculateTotalPrice() + ""
                + "\nEm parceria com: " + coPartner;
        System.out.println(message);
    }
    
      public void generateItemsDescription() {
        for (int i = 0; i < items.length; i++) {
          if (items[i] != null) {
            items[i].generateDescription();
          }
        }
      }

    public void finalizeOrder(Order orderInput) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'finalizeOrder'");
    }
}
