package com.orders.util;

public class Salesperson extends Person {
    private Store store;
    private Float baseSalary;
    private Float[] receivedSalaries;
    
    public Salesperson(String name, Integer age, Address address, Float[] receivedSalaries) {
        super(name, age, address);
        this.receivedSalaries = receivedSalaries;
    }

    @Override
    public void introduce() {
        System.out.println("Meu nome é " + this.getName() + ", tenho " + this.getAge() + " anos e eu trabalho na loja " + store.getName());
    }

    public void calculateAverageSalary() {
        Float totalSalary = 0f;
        for (Float salary : receivedSalaries) {
            totalSalary += salary;
        }
        Float average = totalSalary / receivedSalaries.length;
        System.out.println("A média do salário é: R$ " + average);
    }

    public void calculateBonus() {
        if (baseSalary != null) {
            Float bonus = baseSalary * 0.2f;
            System.out.println("O bônus é: R$ " + bonus);
        } else {
            System.out.println("Base salarial não colocada.");
        }
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public void setBaseSalary(Float baseSalary) {
        this.baseSalary = baseSalary;
    }

    public void calculateSalaryAverage() {
        throw new UnsupportedOperationException("Unimplemented method 'calculateSalaryAverage'");
    }
}
