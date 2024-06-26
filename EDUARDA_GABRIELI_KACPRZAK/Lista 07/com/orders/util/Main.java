package com.orders.util;

import java.util.Date;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    Float[] receivedSalary = { 1000.0f, 1500.0f, 2000.0f };
    Address sellerAddress = new Address("Parana", "Cascavel", "Centro", "AV. Brasil", 000, null);
    Salesperson sellerInput = new Salesperson("Maria", 40, sellerAddress, receivedSalary);
    Address customerAddress = new Address("Parana", "Lindoeste", "Centro", "AV. Souza Naves", 000, null);
    Customer customerInput = new Customer("Florinda", 20, customerAddress);
    Store Store = new Store("Plante Aki", "Plante Aki LTDA", sellerAddress, new Salesperson[] { sellerInput }, new Customer[] { customerInput });
    Store storeInput = null;
    Salesperson salespersonInput = null;

    int choice = 0;

    String opc = "S";
    while (opc.equals("S") || opc.equals("s")) {
      System.out.println("Deseja iniciar o programa? ");
      System.out.println("S/N:   ");
      opc = scan.next();

      while (choice != 4) {
        System.out.println("\n");
        System.out.println("\n-------------------------------------------");
        System.out.println("Menu:");
        System.out.println("[1] - Cadastrar Item");
        System.out.println("[2] - Exibir Itens");
        System.out.println("[3] - Finalizar Pedido");
        System.out.println("[4] - Sair");
        System.out.printf("Escolha uma das opções: ");

        Order orderInput;
        
        switch (choice) {
          case 1:
            orderProcessor.sale(orderInput);
            break;

          case 2:
            orderInput.generateItemsDescription();
            break;

          case 3:
            orderInput.finalizeOrder(orderInput);
            break;

          default:
            System.out.println("Opção inválida!");
            break;
        }
      }
    }

    System.out.println("\n-----------------");
    System.out.println("\n--- Vendendor ---");
    System.out.println("\n-----------------");

    salespersonInput.setStore(storeInput);
    salespersonInput.setBaseSalary(1150.0f);
    salespersonInput.introduce();
    salespersonInput.calculateSalaryAverage();
    salespersonInput.calculateBonus();

    
    System.out.println("\n-----------------");
    System.out.println("\n--- Cliente ---");
    System.out.println("\n-----------------");
    customerInput.introduce();

    
    System.out.println("\n-----------------");
    System.out.println("\n--- Loja ---");
    System.out.println("\n-----------------");
    storeInput.setCNPJ("00.000.000/0000-00");
    storeInput.introduce();
    storeInput.countSalespeople();
    storeInput.countCustomers();

    Address managerAddress = new Address("Parana", "Cascavel", "Downtown", "AV. Brasil", 1200, "House");
    Item itemInput = new Item(0, "Headset Fifine ", "Fone de ouvido", 269.0f);
    Order orderInput = new Order();
    Manager managerInput = new Manager("Beatriz", 19, storeInput, managerAddress,
        new Float[] { 2200.0f, 2400.0f, 2600.0f });

    managerInput.setBasesalary(2200.0f);
    managerInput.introduce();
    managerInput.calculateAverageSalary();

    managerInput.calculateBonus();

    System.out.println("\n-----------------");
    System.out.println("\n--- Address ---");
    System.out.println("\n-----------------");
    managerAddress.displayStreet();

    
    System.out.println("\n-----------------");
    System.out.println("\n--- Item ---");
    System.out.println("\n-----------------");
    itemInput.generateDescription();

    
    System.out.println("\n-----------------");
    System.out.println("\n--- Pedido ---");
    System.out.println("\n-----------------");

    Date today = new Date();

    long millisecondsPerDay = 1000 * 60 * 60 * 24;
    Date threeDaysFromNow = new Date(today.getTime() + (millisecondsPerDay * 3));

    orderInput.setId(0);
    orderInput.setCreationDate(today);
    orderInput.setPaymentDate(today);
    orderInput.setDueDate(threeDaysFromNow);
    orderInput.setCustomer(customerInput);
    orderInput.setSalesperson(sellerInput);
    orderInput.setStore(storeInput);

    orderInput.calculateTotalPrice();

    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the partner company name: ");
    String coPartner = scanner.nextLine();

    orderInput.generateDescription();

    System.out.println("\n--- Processar Pedido ---");

    OrderProcessor orderProcessor = new OrderProcessor();
    orderProcessor.processOrder(orderInput);
    orderProcessor.testMethod(orderInput);
  }
}