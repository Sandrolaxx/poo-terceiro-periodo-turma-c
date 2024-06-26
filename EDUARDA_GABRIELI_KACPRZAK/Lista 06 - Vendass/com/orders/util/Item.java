package com.orders.util;

public class Item {
  Integer id;
  String name; 
  String type; 
  Float price;

  public void generateDescription() { 
    String messageItem = "ID: " + id + "\n" +
                         "Name: " + name + "\n" +
                         "Type: " + type + "\n" +
                         "Price: " + price + "\n";
    System.out.println(messageItem);
  }
}
