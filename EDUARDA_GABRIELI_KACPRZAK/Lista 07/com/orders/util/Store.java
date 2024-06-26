package com.orders.util;

public class Store { 
    String name; 
    String city;
    String neighborhood; 
    String street; 
    public Address address;
    String corporateName; 
    Integer cnpj; 
    Salesperson[] salespeople = new Salesperson[5]; 
    Customer[] customers = new Customer[5]; 

    public Store(String name, String corporateName, Address address, Salesperson[] salespeople, Customer[] customers) {
        this.name = name;
        this.corporateName = corporateName;
        this.address = address;
        this.salespeople = salespeople;
        this.customers = customers;
    }

    public Integer getCNPJ() {
        return cnpj;
      }
    
      public void setCNPJ(String string) {
        this.cnpj = string;
      }
      
    public void countSalespeople() {
        int count = 0;
        for (int i = 0; i < salespeople.length; i++) {
            if (salespeople[i] != null) {
                count++;
            }
        }
        System.out.println("Quantidade de Vendedores" + name + ": " + count);
    }

       public void countCustomers() {
        int count = 0;
        for (int i = 0; i < customers.length; i++) {
            if (customers[i] != null) {
                count++;
            }
        }

        System.out.println("Quantidade de Clientes " + name + ": " + count);
    }

   public void introduce() {
        String message = "Loja " + name + "\n" +
                "Razão Social: " + corporateName + "\n" +
                "CNPJ: " + cnpj + "\n" +
                "Cidade: " + address.getCity() + "\n" +
                "Bairro: " + address.getNeighborhood() + "\n" +
                "Street: " + address.getStreet() + "\n";
        System.out.println(message);
    }

public String getName() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getName'");
}
}
