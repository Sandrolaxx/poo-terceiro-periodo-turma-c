package com.orders.util;

public class Address { 
  String state; 
  String city; 
  String neighborhood; 
  String street;
  Integer number; 
  String complement; 

  public Address (String state, String city, String neighborhood, String street, Integer number, String complement){
    this.complement = complement;
    this.number = number;
    this.street = street;
    this.neighborhood = neighborhood;
    this.city = city;
    this.state = state;
  }

  public String getComplement() {
    return complement;
  }

  public Integer getNumber() {
    return number;
  }

  public String getStreet() {
    return street;
  }

  public String getState() {
    return state;
  }

  public String getCity() {
    return city;
  }

  public String getNeighborhood() {
    return neighborhood;
  }

  public void displayAddress() { 
      String messageAddress = 
              "Endereço: " +
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

public void displayStreet() {
    throw new UnsupportedOperationException("Unimplemented method 'displayStreet'");
}
}
