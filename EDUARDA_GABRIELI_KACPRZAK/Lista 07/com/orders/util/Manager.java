package com.orders.util;

public class Manager extends Person {
    Store store = new Store(); 
    Float baseSalary; 
    Float[] receivedSalary = new Float[3]; 
    String street; 
    String neighborhood; 
    String city; 
    int age; 
    String name; 

    public Manager(String string, int i, Store storeInput, Address managerAddress, Float[] floats) {
        //TODO Auto-generated constructor stub
    }

    public Float getBasesalary() {
        return baseSalary;
      }
    
      public void setBasesalary(Float baseSalary) {
        this.baseSalary = baseSalary;
      }
    
      public Store getStore() {
        return store;
      }
    
      public void setStore(Store store) {
        this.store = store;
      }


    public void introduce() {
        String messageIntroduce = "Meu nome é " + name + ", tenho " + age + " anos" + " e trabalho na Loja " + store.name;
        System.out.println(messageIntroduce);
    }

    public void calculateSalaryAverage() {
        Float totalSalary = 0.2f;
        for (int i = 0; i < receivedSalary.length; i++) {
            totalSalary += receivedSalary[i];
        }

    Float media = totalSalary / receivedSalary.length;
    System.out.println("Média de salário: R$" + media);
    }

    public void calculateBonus() {
        Float bonus = baseSalary * 0.35f;
        System.out.println("Bônus salarial: R$" + bonus);
    }

    public void calculateAverageSalary() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calculateAverageSalary'");
    }
}
