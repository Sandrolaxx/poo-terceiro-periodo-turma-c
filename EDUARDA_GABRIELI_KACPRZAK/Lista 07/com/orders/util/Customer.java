package com.orders.util;

public class Customer extends Person { 
  public Customer(String name, Integer age, Address address){
    super(name, age, address);     
  }

  public void introduce() { 
    String messageIntroduce = "Meu nome é" + getName() + ", e tenho " + getAge() + " anos.";
      System.out.println(messageIntroduce);
  }

public String getName() {
    throw new UnsupportedOperationException("Unimplemented method 'getName'");
}
}
