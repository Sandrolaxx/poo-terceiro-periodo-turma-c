package com.orders.util;

import java.util.Scanner;

public class OrderProcessor { 
    public void sale (Order order){
    Scanner scan = new Scanner(System.in);


    Integer id = 0;
    System.out.print("Preencha os dados para adicionar um novo item: ");
    System.out.print("Nome do item: ");
    String name = scan.nextLine();
    System.out.print("Tipo do item: ");
    String type = scan.nextLine();
    System.out.print("Valor do item: ");
    Float price = scan.nextFloat();

    order.saveItem(new Item(id, name, type, price));
    scan.close();
  }

  public void processOrder(Order order) {
    String message = "Processando Pedido: " + order.getId()
            + "\nData de Criação: " + order.getCreationDate().toString()
            + "\nPayment date: " + order.getPaymentDate().toString()
            + "\nDue date: " + order.getDueDate().toString()
            + "\nCustomer: " + order.getCustomer().getName()
            + "\nSalesperson: " + order.getSalesperson().getName()
            + "\nStore: " + order.getStore().getName()
            + "\nPartner company: " + order.getCoPartner();
    System.out.println(message);
}

private void confirmPayment(Order order) {
    int result = order.getPaymentDate().compareTo(order.getDueDate());

    if (result <= 0) {
        System.out.println("Pagamento realizado com sucesso!");
    } else {
        System.out.println("Algo deu errado, tente novamente.");
    }
}

public void testMethod(Order order) {
    confirmPayment(order);
}

public void finalizeOrder(Order order) {
    System.out.println("Finalizando pedido: " + order.getId());
    System.out.print("Empresa Parceira: ");

    Scanner scan = new Scanner(System.in);
    order.setCoPartner(scan.nextLine());
    order.generateDescription();
    scan.close();
}
}

