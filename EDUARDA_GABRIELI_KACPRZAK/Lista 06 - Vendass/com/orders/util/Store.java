package com.orders.util;

public class Store { 
    String name; 
    String city;
    String neighborhood; 
    String street; 
    String corporateName; 
    Integer cnpj; 
    Salesperson[] salespeople = new Salesperson[5]; 
    Customer[] customers = new Customer[5]; 

    public void countSalespeople() {
        int count = 0;
        for (int i = 0; i < salespeople.length; i++) {
            if (salespeople[i] != null) {
                count++;
            }
        }
        System.out.println("Quantidade de Clientes " + name + ": " + count);
    }
       public void countCustomers() {
        int count = 0;
        for (int i = 0; i < customers.length; i++) {
            if (customers[i] != null) {
                count++;
            }
        }
        System.out.println("Number of customers at " + name + ": " + count);
    }
   public void introduce() {
        String message = "Store " + name + "\n" +
                "Corporate Name: " + corporateName + "\n" +
                "CNPJ: " + cnpj + "\n" +
                "Located in the city of: " + city + "\n" +
                "Neighborhood: " + neighborhood + "\n" +
                "Street: " + street + "\n";
        System.out.println(message);
    }
}
