package com.orders.util;

public class Customer extends Person { 
  public void introduce() { 
    String messageIntroduce = "Meu nome é" + name + ", e tenho " + age + " anos.";
      System.out.println(messageIntroduce);
  }
}
