package com.orders.util;

public class Address { 

  String state; 
  String city; 
  String neighborhood; 
  String street;
  Integer number; 
  String complement; 

  public void displayAddress() { 
      String messageAddress = "Endereço: " +
              street + "\n" +
              "Número: " +
              number.toString() + "\n" +
              "Complemento: " +
              complement + "\n" +
              "Bairro: " +
              neighborhood + "\n" +
              "Cidade: " +
              city + "\n" +
              "Estado: " +
              state + "\n";
      System.out.println(messageAddress);
  }
}
