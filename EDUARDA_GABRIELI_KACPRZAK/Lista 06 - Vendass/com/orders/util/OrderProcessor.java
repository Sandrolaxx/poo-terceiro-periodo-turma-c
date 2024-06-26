package com.orders.util;

public class OrderProcessor { 
    public void processOrder(Order order) { 
        String messageProcess = "Processing Order: " +
                order.id + "\n" +
                "Creation Date: " +
                order.creationDate + "\n" +
                "Data de Pagamento: " +
                order.paymentDate + "\n" +
                "Prazo: " +
                order.dueDate + "\n" +
                "Cliente: " +
                order.customer.name + "\n" +
                "Vendedor: " +
                order.salesperson.name + "\n" +
                "Loja: " +
                order.store.name + "\n";
        System.out.println(messageProcess);
    }

    private void confirmPayment(Order order) { 
        int result = order.paymentDate.compareTo(order.dueDate);

        if (result <= 0) {
            System.out.println("Pagamento confirmado com sucesso!");
        } else {
            System.out.println("Algo deu errado, tente novamente.");
        }
    }
    public void testMethod(Order order) { 
        confirmPayment(order);
    }
}
