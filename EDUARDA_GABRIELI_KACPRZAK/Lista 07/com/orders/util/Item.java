package com.orders.util;

public class Item {
  Integer id;
  String name; 
  String type; 
  Float price;

  public Item(Integer id, String name, String type, Float price) {
    this.id = id;
    this.name = name;
    this.type = type;
    this.price = price;
  }

  public void generateDescription() { 
    String messageItem = "ID: " + id + "\n" +
                         "Name: " + name + "\n" +
                         "Type: " + type + "\n" +
                         "Price: " + price + "\n";
    System.out.println(messageItem);
  }

  public void setId(int position) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setId'");
  }
}
