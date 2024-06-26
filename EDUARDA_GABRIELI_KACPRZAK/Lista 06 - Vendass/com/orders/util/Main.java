package com.orders.util;

import java.util.Date;

public class Main {
  public static void main(String[] args) {
    Store storeInput = new Store();
    Salesperson salespersonInput = new Salesperson();
    Customer customerInput = new Customer();

    salespersonInput.name = "Vendedor";
    salespersonInput.age = 30;
    salespersonInput.store = storeInput;
    salespersonInput.city = "Cidade";
    salespersonInput.neighborhood = "Bairro";
    salespersonInput.street = "Rua";
    salespersonInput.baseSalary = 1300.0f;
    salespersonInput.receivedSalary[0] = 1100.0f;
    salespersonInput.receivedSalary[1] = 1400.0f;

    customerInput.name = "Cliente";
    customerInput.age = 30;
    customerInput.city = "Cidade";
    customerInput.neighborhood = "Bairro";
    customerInput.street = "Rua";

    storeInput.name = "Loja";
    storeInput.corporateName = "Nome Corporativo";
    storeInput.cnpj = 0000000000/00;
    storeInput.city = "Cidade";
    storeInput.neighborhood = "Bairro";
    storeInput.street = "Rua";
    storeInput.salespeople[0] = salespersonInput;
    storeInput.customers[0] = customerInput;

    storeInput.introduce(); 
    salespersonInput.introduce(); 
    customerInput.introduce(); 
    storeInput.countSalespeople(); 
    storeInput.countCustomers(); 
    salespersonInput.calculateSalaryAverage(); 
    salespersonInput.calculateBonus(); 

    System.out.println("\n");

    Manager managerInput = new Manager();
    managerInput.name = "Gerente";
    managerInput.age = 55;
    managerInput.store = storeInput;
    managerInput.city = "Cidade";
    managerInput.neighborhood = "Bairro";
    managerInput.street = "Rua";
    managerInput.baseSalary = 1800.0f;
    managerInput.receivedSalary[0] = 2000.0f;
    managerInput.receivedSalary[1] = 2200.0f;
    managerInput.receivedSalary[2] = 2400.0f;
    managerInput.introduce(); 
    managerInput.calculateSalaryAverage(); 
    managerInput.calculateBonus(); 

    Address address = new Address();
    address.city = "Cascavel";
    address.neighborhood = "Centro";
    address.street = "Rua Pará";
    address.number = 1534;
    address.complement = "Condomínio";
    address.state = "Paraná";
    address.displayAddress(); 

    Item bulletItem = new Item();
    bulletItem.id = 1;
    bulletItem.name = "Item";
    bulletItem.type = "Tipo";
    bulletItem.price = 15.0f;
    bulletItem.generateDescription(); 

    Order placedOrder = new Order();
    placedOrder.id = 1;
    placedOrder.creationDate = new Date();
    placedOrder.paymentDate = new Date();
    placedOrder.dueDate = new Date();
    placedOrder.customer = customerInput;
    placedOrder.salesperson = salespersonInput;
    placedOrder.store = storeInput;
    placedOrder.items[0] = bulletItem;
    placedOrder.calculateTotalPrice(); 
    placedOrder.generateSaleDescription(); 

    OrderProcessor processor = new OrderProcessor(); 
    Order order = new Order();
    
    processor.testMethod(order); 
  }
}