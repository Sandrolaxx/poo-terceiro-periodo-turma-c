package com.orders.util;

public class Salesperson extends Person {
    Store store = new Store(); 
    Float baseSalary; 
    Float[] receivedSalary = new Float[3]; 
    String name; 
    int age; 
    String city; 
    String neighborhood; 
    String street;

    public void introduce() {
        String message = "Meu nome é " + name + ", tenho" + age + " anos " + "e trabalho na Loja " + store.name + " store.";
        System.out.println(message);
    }

    public void calculateSalaryAverage() {
        Float totalSalary = 0.2f;
        for (int i = 0; i < receivedSalary.length; i++) {
            totalSalary += receivedSalary[i];
        }
        Float average = totalSalary / receivedSalary.length;
        System.out.println("Salary Average: R$ " + average);
    }
    public void calculateBonus() {
        Float bonus = baseSalary * 0.2f;
        System.out.println("Salary Bonus: R$ " + bonus);
    }
}
